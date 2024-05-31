from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date
from datetime import date, datetime, timedelta

# Cassandra Configuration
cassandra_host = "127.0.0.1"
cassandra_port = "9042"
cassandra_keyspace = "keyspacedatasci"
cassandra_table = "counts_cctv"

# Hive Configuration
hive_database = "cctvdata"
hive_table = "count_cctv"

# Initialize Spark session
spark = SparkSession.builder \
    .appName("CassandraToHiveMigration") \
    .config("hive.metastore.uris", "thrift://0.0.0.0:9083") \
    .master("local[*]") \
    .config("spark.cassandra.connection.host", cassandra_host) \
    .config("spark.cassandra.connection.port", cassandra_port) \
    .config("spark.jars", "C:\\DS_BigDataPipeline\\lib\\kafka-clients-3.5.1.jar,"
                          "C:\\DS_BigDataPipeline\\lib\\spark-streaming-kafka-0-10_2.12-3.0.3.jar,"
                          "C:\\DS_BigDataPipeline\\lib\\spark-cassandra-connector_2.12-3.0.1.jar") \
    .config("spark.jars.packages", "org.apache.spark:spark-sql-kafka-0-10_2.12:3.0.3,"
                                   "com.datastax.spark:spark-cassandra-connector_2.12:3.0.1") \
    .enableHiveSupport() \
    .getOrCreate()

# Get today's date
today_date = date(2023, 9, 27)

# Calculate the end of the day timestamp (11:59:59 PM)
end_of_day_timestamp = datetime.combine(today_date, datetime.min.time()) + timedelta(hours=23, minutes=59, seconds=59)

# Read data from Cassandra
cassandra_df = spark.read \
    .format("org.apache.spark.sql.cassandra") \
    .options(keyspace=cassandra_keyspace, table=cassandra_table) \
    .load()

# Filter data for today up to the end of the day
filtered_df = cassandra_df.filter(
    (cassandra_df.date_saved.cast("timestamp") >= datetime.combine(today_date, datetime.min.time())) &
    (cassandra_df.date_saved.cast("timestamp") <= end_of_day_timestamp)
)


# Register the DataFrame as a temporary table
filtered_df.createOrReplaceTempView("cctv_data")

# Insert data into Hive
spark.sql("INSERT INTO cctvdata.count_cctv SELECT * FROM cctv_data")

# Stop the Spark session
spark.stop()
