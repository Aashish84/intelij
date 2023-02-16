use temperature_data_dates;
select * from temperature_data_dates;

# unique primary_id
select distinct(primary_id) from temperature_data_dates;

# Which sensor has the highest average temperature value?
# bjn2p3tp0jt000a5eiug
select primary_id, avg(value) as average_value from temperature_data_dates where primary_id = "bjn2p3tp0jt000a5eiug";
select primary_id, avg(value) as average_value from temperature_data_dates group by primary_id;
select primary_id, avg(value) as average_value from temperature_data_dates group by primary_id order by average_value desc limit 1;

# From which sensor did we receive the maximum number of data?
select primary_id, count(primary_id) as id_count from temperature_data_dates group by primary_id ;
select primary_id, count(primary_id) as id_count from temperature_data_dates group by primary_id order by id_count desc limit 1;




