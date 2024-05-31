
from cassandra.cluster import Cluster

cluster = Cluster(['127.0.0.1'], port=9042)
session = cluster.connect()

create_keyspace_query = """
    CREATE KEYSPACE IF NOT EXISTS keyspacedatasci
    WITH replication ={
        'class': 'SimpleStrategy',
        'replication_factor': 1
    };
"""
session.execute(create_keyspace_query)
session.shutdown()
cluster.shutdown()

