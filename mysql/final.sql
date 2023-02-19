use temperature_data_dates;
alter table temperature_data_dates rename temperature_data;
select * from temperature_data;
select distinct(primary_id) from temperature_data;
#ANS 1 :
select count(distinct(primary_id)) as unique_primary_id_count from temperature_data;

# Which sensor has the highest average temperature value?
select  primary_id , avg(value) as avg_temperature from temperature_data group by primary_id;
#ANS 2 :
select primary_id , avg(value) as avg_value from temperature_data group by primary_id order by avg_value desc limit 1;

# From which sensor did we receive the maximum number of data?
select primary_id , count(value) from temperature_data group by primary_id;
# only more than 3500
select primary_id , count(value) as count_value from temperature_data where count_value > 3500 group by primary_id;
select primary_id , count(value) as count_value from temperature_data group by primary_id having count_value > 3500;
#ANS 3 :
select primary_id , count(value) as data_count from temperature_data group by primary_id order by data_count desc limit 1;


# Find the average temperature from each sensor for each day.
SELECT FROM_UNIXTIME(1447430881);
select primary_id, value , from_unixtime(timestamp/1000) from temperature_data;
select primary_id , value , from_unixtime(timestamp/1000 , "%d %m %Y") as date from temperature_data;
#ANS 4 :
select primary_id , avg(value) , from_unixtime(timestamp/1000 , "%d %m %Y") as date from temperature_data group by date , primary_id;

# Find the hottest day for each sensor
select primary_id , max(value) as max_value  from temperature_data group by primary_id;

with tmp as (select primary_id , max(value) as max_value from temperature_data group by primary_id)
	select  from_unixtime(t1.timestamp/1000 ) as date ,t1.primary_id , t1.value from temperature_data t1 where primary_id = 
		(select cte.primary_id from tmp cte where cte.primary_id = t1.primary_id and cte.max_value = t1.value);

#ANS 5 :
with tmp as (select primary_id , max(value) as max_value from temperature_data group by primary_id)
	select  distinct from_unixtime(t1.timestamp/1000 , "%d %m %Y") as date ,t1.primary_id , t1.value from temperature_data t1 where primary_id = 
		(select cte.primary_id from tmp cte where cte.primary_id = t1.primary_id and cte.max_value = t1.value);

# select primary_id , from_unixtime(timestamp/1000 , "%d %m %Y") as date , max(value) over (partition by value) as max_value  from temperature_data;

# formatting sql query
with tmp as (
  select 
    primary_id, 
    max(value) as max_value 
  from 
    temperature_data 
  group by 
    primary_id
) 
select 
  distinct from_unixtime(t1.timestamp / 1000, "%d %m %Y") as date, 
  t1.primary_id, 
  t1.value 
from 
  temperature_data t1 
where 
  primary_id = (
    select 
      cte.primary_id 
    from 
      tmp cte 
    where 
      cte.primary_id = t1.primary_id 
      and cte.max_value = t1.value
  );