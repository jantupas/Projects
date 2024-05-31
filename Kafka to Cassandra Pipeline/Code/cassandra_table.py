from cassandra.cluster import Cluster

cluster = Cluster(['127.0.0.1'], port=9042)
session = cluster.connect()

create_table_query = """
    CREATE TABLE IF NOT EXISTS dskeyspacebd.prod_messages(
        sensor_id TEXT,
        time_saved TEXT,
        car INT,
        others INT,
        jeepney INT,
        lgu_code TEXT,
        timeuuid_id TEXT PRIMARY KEY,
        bike INT,
        truck INT,
        tryke INT,
        bus INT,
        date_saved TEXT,
        total BIGINT
    )
"""

name = 'prod_messages'

existing_tables = session.execute("SELECT table_name FROM system_schema.tables WHERE keyspace_name = 'dskeyspacebd'")
table_exists = False

for row in existing_tables:
    if row.table_name == name:
        table_exists = True
        break

if table_exists:
    print("Table {} already exists".format(name))
else:
    session.execute(create_table_query)
    print("Table {} created".format(name))

session.shutdown()
cluster.shutdown()


