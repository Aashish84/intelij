drop table stock;

create table stock (
		stock_name varchar(100),
        operation enum ("Sell" , "Buy"),
        operation_day int,
        price int,
        primary key (stock_name , operation_day)
);

select * from stock;

delete from stock where stock_name = "leetcode";

insert into stock 
	values
		("Leetcode" , "Buy", 1,1000),
        ("Corona Masks" , "Buy", 2,10),
        ("leetcode" , "Sell", 5,9000),
        ("Handbags" , "Buy", 17,30000),
        ("Corona Masks" , "Sell", 3,1010),
        ("Corona Masks" , "Buy", 4,1000),
        ("Corona Masks" , "Sell", 5,500),
        ("Corona Masks" , "Buy", 6,1000),
        ("Handbags" , "Sell", 29,7000),
        ("Corona Masks" , "Sell", 10,10000);
        
select distinct(stock_name) from stock;
select * from stock;

select stock_name , operation , sum(price) as sum from stock group by stock_name , operation;

#Solution 1
with tmp_stock as (select stock_name , operation , sum(price) as sum from stock group by stock_name , operation) 
, buy_stock as (select stock_name , operation , sum from tmp_stock where operation = "Buy")
, sell_stock as (select stock_name , operation , sum  from tmp_stock where operation = "Sell")
    select s.stock_name ,(s.sum-b.sum) as capital_gain_loss from buy_stock b inner join sell_stock s on s.stock_name = b.stock_name;
    
     #select * from sell_stock;
     #select * from stock;

# Solution 2 :
select 
	stock_name , 
    sum(case when operation = "Buy" then -price else price end) as capital_gain_loss 
from stock 
group by stock_name;

#Transaction demo :
start transaction;
savepoint before_update;
update stock set price=999999 where stock_name  = "Corona Masks" and operation_day = 2;
select * from stock where stock_name ="Corona Masks" and operation_day = 2; 
rollback to savepoint before_update;
commit;

