from kafka import KafkaProducer
from datetime import datetime
import time
from json import dumps
import random
import uuid

KAFKA_TOPIC_NAME_CONS = "bigdatatopic"   #topic
KAFKA_BOOTSTRAP_SERVERS_CONS = '127.0.0.1:9092'

if __name__ == "__main__":
    print("Kafka Producer1 Application Started ... ")
    kafka_producer_obj = KafkaProducer(bootstrap_servers=KAFKA_BOOTSTRAP_SERVERS_CONS,
                                       value_serializer=lambda x: dumps(x).encode('utf-8'))

    message_list = []
    message = None
    for i in range(750):
        i = i + 1
        date_today = datetime.now()
        message = {}
        print("Preparing message: " + str(i))

        car = random.randint(0,4)
        bus = random.randint(0,2)
        truck = random.randint(0,2)
        jeepney = random.randint(0, 2)
        bike = random.randint(0, 5)
        tryke = random.randint(0, 3)
        others = random.randint(0, 2)
        inout = random.randint(0, 1)

        total = car + bus + truck + jeepney + bike + tryke + others

        message["timeuuid_id"] = str(uuid.uuid1())
        message["lgu_code"] = '1200'
        message["sensor_id"] = 'sensor_01'
        message["date_saved"] = str(date_today.strftime('%m/%d/%Y'))
        message["time_saved"] = str(date_today.strftime("%X"))
        message["total"] = total
        message["car"] = car
        message["bus"] = bus
        message["truck"] = truck
        message["jeepney"] = jeepney
        message["bike"] = bike
        message["tryke"] = tryke
        message["others"] = others
        message["inout"] = inout


        print("Message: ", message)

        kafka_producer_obj.send(KAFKA_TOPIC_NAME_CONS, message)
        time.sleep(5)

    print("Kafka Producer Application Completed. ")



