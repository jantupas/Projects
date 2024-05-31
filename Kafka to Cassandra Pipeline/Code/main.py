from pyspark.sql import SparkSession
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyspark.sql.streaming import DataStreamWriter
import time

kafka_topic_name = "bigdatatopic"
kafka_bootstrap_servers = '127.0.0.1:9092'

cassandra_host_name = '127.0.0.1'
cassandra_port_num = '9042'
cassandra_keyspace_name = 'dskeyspacebd'
cassandra_table_name = 'prod_messages'

if __name__ == "__main__":
    print("Welcome!")
    print("Data Processing Application Started...")
    print(time.strftime('''%Y-%m-%d %H:%M:%S'''))

    spark = SparkSession \
        .builder \
        .appName("Pyspark Streaming with Kafka and Cassandra") \
        .master("local[*]") \
        .config("spark.cassandra.connection.host", cassandra_host_name) \
        .config("spark.cassandra.connection.port", cassandra_port_num) \
        .config("spark.jars", "C:\\DS_BigDataPipeline\\lib\\kafka-clients-3.5.1.jar,"
                              "C:\\DS_BigDataPipeline\\lib\\spark-streaming-kafka-0-10_2.12-3.0.3.jar,"
                              "C:\\DS_BigDataPipeline\\lib\\spark-cassandra-connector_2.12-3.0.1.jar") \
        .config("spark.jars.packages", "org.apache.spark:spark-sql-kafka-0-10_2.12:3.0.3,"
                                       "com.datastax.spark:spark-cassandra-connector_2.12:3.0.1") \
        .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    schema = StructType([
        StructField("sensor_id", StringType(), True),
        StructField("time_saved", StringType(), True),
        StructField("car", IntegerType(), True),
        StructField("others", IntegerType(), True),
        StructField("jeepney", IntegerType(), True),
        StructField("lgu_code", StringType(), True),
        StructField("timeuuid_id", StringType(), True),
        StructField("bike", IntegerType(), True),
        StructField("truck", IntegerType(), True),
        StructField("tryke", IntegerType(), True),
        StructField("bus", IntegerType(), True),
        StructField("date_saved", StringType(), True),
        StructField("total", LongType(), True)
    ])

    kafka_stream = spark \
        .readStream \
        .format("kafka") \
        .option("kafka.bootstrap.servers", kafka_bootstrap_servers) \
        .option("subscribe", kafka_topic_name) \
        .load()

    kafka_data = kafka_stream.selectExpr("CAST(value AS STRING)")
    parsed_data = kafka_data.select(from_json("value", schema).alias("data")).select("data.*")

    cassandra_stream = parsed_data.writeStream \
        .foreachBatch(lambda df, epoch_id: df.write \
                      .format("org.apache.spark.sql.cassandra") \
                      .options(table=cassandra_table_name, keyspace=cassandra_keyspace_name) \
                      .mode("append") \
                      .save())

    query = cassandra_stream.start()

    try:
        query.awaitTermination()
    except KeyboardInterrupt:
        print("Terminating...")
        query.stop()
