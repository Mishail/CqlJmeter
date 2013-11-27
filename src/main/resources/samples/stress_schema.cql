CREATE KEYSPACE stress WITH replication = {
  'class': 'SimpleStrategy',
  'replication_factor': '1'
};

USE stress;

CREATE TABLE t1 (
  id timeuuid,
  num int,
  str text,
  PRIMARY KEY (id)
);

CREATE INDEX t1_num_idx ON t1 (num);
