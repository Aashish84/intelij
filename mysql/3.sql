#Find the hottest day for each sensor
select primary_id ,max(value) as max_value from temperature_data group by primary_id;

with ctex as (select primary_id ,max(value) as max_value from temperature_data group by primary_id)
select t1.primary_id , t1.value , from_unixtime(t1.timestamp / 1000 , '%d , %m , %Y') as max_value 
from temperature_data t1 where value = (select value from ctex c where c.max_value = t1.value and t1.primary_id = c.primary_id) ;

with ctex as (select primary_id ,max(value) as max_value from temperature_data group by primary_id)
select   value , from_unixtime(timestamp / 1000 , '%d , %m , %Y') from temperature_data_dates 
inner join ctex on temperature_data.value = ctex.max_value && temperature_data.primary_id = ctex.primary_id;

select * from temperature_data_dates where value = 77.54 and primary_id = "bjn2p5tntbig00f90rq0"

