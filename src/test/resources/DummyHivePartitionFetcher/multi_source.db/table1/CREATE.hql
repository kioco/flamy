CREATE TABLE IF NOT EXISTS multi_source.table1(
  id STRING,
  part2 STRING
)
PARTITIONED BY (part1 STRING)
;
