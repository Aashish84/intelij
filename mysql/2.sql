# Find the average temperature from each sensor for each day.
SELECT FROM_UNIXTIME(1447430881);
select timestamp from temperature_data;
select from_unixtime(timestamp/1000) as ts from temperature_data;
select from_unixtime(timestamp/1000 , '%d , %m , %Y') as ts from temperature_data group by ts;

#01 , 08 , 2022
select avg(value) , from_unixtime(timestamp/1000 , '%d , %m , %Y') as ts from temperature_data group by ts;
select primary_id, avg(value) as average_value from temperature_data group by primary_id;

select primary_id, value , from_unixtime(timestamp/1000 , '%d , %m , %Y') as ts from temperature_data;

with cte1 as ( select primary_id, value , from_unixtime(timestamp/1000 , '%d , %m , %Y') as ts from temperature_data )
select primary_id,ts , avg(value) as average_value from cte1 group by ts , primary_id;

with cte1 as ( select primary_id, value , from_unixtime(timestamp/1000 , '%d , %m , %Y') as ts from temperature_data )
select avg(value) from cte1 where primary_id = "bjn2p3tp0jt000a5eiug" and ts="01 , 08 , 2022";

select primary_id, avg(value) , from_unixtime(timestamp/1000 , '%d , %m , %Y') as ts from temperature_data  group by ts,primary_id;
