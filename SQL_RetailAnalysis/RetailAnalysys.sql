-- table customer

create table customers(customer_id int primary key,name Varchar(255), city varchar(255));


-- table products

create table products(product_id int primary key,name varchar(255),category varchar(255), price float check (price>0.0));


-- table orders

create table orders(order_id int primary key,
                    customer_id int,
                    "date" Date,
                    Foreign key(customer_id) references customers(customer_id));


-- table order_items

create table order_items(order_id int, product_id int, quantity int check(quantity>0),
                            Foreign key(product_id) references products(product_id),
                            Foreign key(order_id) references orders(order_id)
                            );


-- Insert data into tables
--Customer data

INSERT ALL
INTO Customers VALUES (1, 'Rahul Sharma', 'Delhi')
INTO Customers VALUES (2, 'Anjali Verma', 'Mumbai')
INTO Customers VALUES (3, 'Ravi Kumar', 'Hyderabad')
INTO Customers VALUES (4, 'Sneha Reddy', 'Bangalore')
INTO Customers VALUES (5, 'Arjun Patel', 'Ahmedabad')
INTO Customers VALUES (6, 'Pooja Singh', 'Lucknow')
INTO Customers VALUES (7, 'Kiran Rao', 'Chennai')
INTO Customers VALUES (8, 'Vikram Mehta', 'Pune')
INTO Customers VALUES (9, 'Neha Gupta', 'Delhi')
INTO Customers VALUES (10, 'Amit Das', 'Kolkata')
INTO Customers VALUES (11, 'Suresh Babu', 'Hyderabad')
INTO Customers VALUES (12, 'Meena Iyer', 'Chennai')
INTO Customers VALUES (13, 'Rohit Jain', 'Jaipur')
INTO Customers VALUES (14, 'Priya Nair', 'Kochi')
INTO Customers VALUES (15, 'Deepak Yadav', 'Noida')
INTO Customers VALUES (16, 'Swati Kulkarni', 'Pune')
INTO Customers VALUES (17, 'Manoj Tiwari', 'Varanasi')
INTO Customers VALUES (18, 'Kavya Shetty', 'Mangalore')
INTO Customers VALUES (19, 'Nitin Agarwal', 'Indore')
INTO Customers VALUES (20, 'Divya Sharma', 'Delhi')
SELECT * FROM dual; 


--Product Data

INSERT ALL
INTO Products VALUES (101, 'Laptop', 'Electronics', 65000)
INTO Products VALUES (102, 'Smartphone', 'Electronics', 28000)
INTO Products VALUES (103, 'Tablet', 'Electronics', 20000)
INTO Products VALUES (104, 'Headphones', 'Accessories', 2500)
INTO Products VALUES (105, 'Bluetooth Speaker', 'Accessories', 3500)
INTO Products VALUES (106, 'Keyboard', 'Accessories', 1200)
INTO Products VALUES (107, 'Mouse', 'Accessories', 800)
INTO Products VALUES (108, 'Office Chair', 'Furniture', 7000)
INTO Products VALUES (109, 'Study Table', 'Furniture', 9000)
INTO Products VALUES (110, 'Desk Lamp', 'Furniture', 1500)
INTO Products VALUES (111, 'Monitor', 'Electronics', 15000)
INTO Products VALUES (112, 'Printer', 'Electronics', 12000)
INTO Products VALUES (113, 'Power Bank', 'Accessories', 1800)
INTO Products VALUES (114, 'USB Cable', 'Accessories', 300)
INTO Products VALUES (115, 'Router', 'Electronics', 2500)
INTO Products VALUES (116, 'External HDD', 'Electronics', 6000)
INTO Products VALUES (117, 'Pen Drive', 'Accessories', 700)
INTO Products VALUES (118, 'Gaming Chair', 'Furniture', 12000)
INTO Products VALUES (119, 'Webcam', 'Electronics', 2200)
INTO Products VALUES (120, 'Microphone', 'Electronics', 3000)
SELECT * FROM dual;


--Orders Data

INSERT ALL
INTO Orders VALUES (1001, 1, TO_DATE('2026-04-01','YYYY-MM-DD'))
INTO Orders VALUES (1002, 2, TO_DATE('2026-04-01','YYYY-MM-DD'))
INTO Orders VALUES (1003, 3, TO_DATE('2026-04-02','YYYY-MM-DD'))
INTO Orders VALUES (1004, 4, TO_DATE('2026-04-02','YYYY-MM-DD'))
INTO Orders VALUES (1005, 5, TO_DATE('2026-04-03','YYYY-MM-DD'))
INTO Orders VALUES (1006, 6, TO_DATE('2026-04-03','YYYY-MM-DD'))
INTO Orders VALUES (1007, 7, TO_DATE('2026-04-04','YYYY-MM-DD'))
INTO Orders VALUES (1008, 8, TO_DATE('2026-04-04','YYYY-MM-DD'))
INTO Orders VALUES (1009, 9, TO_DATE('2026-04-05','YYYY-MM-DD'))
INTO Orders VALUES (1010, 10, TO_DATE('2026-04-05','YYYY-MM-DD'))
INTO Orders VALUES (1011, 11, TO_DATE('2026-04-06','YYYY-MM-DD'))
INTO Orders VALUES (1012, 12, TO_DATE('2026-04-06','YYYY-MM-DD'))
INTO Orders VALUES (1013, 13, TO_DATE('2026-04-07','YYYY-MM-DD'))
INTO Orders VALUES (1014, 14, TO_DATE('2026-04-07','YYYY-MM-DD'))
INTO Orders VALUES (1015, 15, TO_DATE('2026-04-08','YYYY-MM-DD'))
INTO Orders VALUES (1016, 16, TO_DATE('2026-04-08','YYYY-MM-DD'))
INTO Orders VALUES (1017, 17, TO_DATE('2026-04-09','YYYY-MM-DD'))
INTO Orders VALUES (1018, 18, TO_DATE('2026-04-09','YYYY-MM-DD'))
INTO Orders VALUES (1019, 19, TO_DATE('2026-04-10','YYYY-MM-DD'))
INTO Orders VALUES (1020, 20, TO_DATE('2026-04-10','YYYY-MM-DD'))
SELECT * FROM dual;


--Order_Items Data

INSERT ALL
INTO Order_Items VALUES (1001, 101, 1)
INTO Order_Items VALUES (1001, 104, 2)
INTO Order_Items VALUES (1002, 102, 1)
INTO Order_Items VALUES (1002, 113, 1)
INTO Order_Items VALUES (1003, 103, 1)
INTO Order_Items VALUES (1003, 106, 1)
INTO Order_Items VALUES (1004, 108, 1)
INTO Order_Items VALUES (1004, 110, 2)
INTO Order_Items VALUES (1005, 111, 1)
INTO Order_Items VALUES (1005, 114, 3)
INTO Order_Items VALUES (1006, 105, 2)
INTO Order_Items VALUES (1007, 107, 2)
INTO Order_Items VALUES (1008, 109, 1)
INTO Order_Items VALUES (1008, 115, 1)
INTO Order_Items VALUES (1009, 116, 1)
INTO Order_Items VALUES (1010, 117, 4)
INTO Order_Items VALUES (1011, 118, 1)
INTO Order_Items VALUES (1012, 119, 2)
INTO Order_Items VALUES (1013, 120, 1)
INTO Order_Items VALUES (1014, 101, 1)
INTO Order_Items VALUES (1015, 102, 2)
INTO Order_Items VALUES (1016, 103, 1)
INTO Order_Items VALUES (1017, 104, 3)
INTO Order_Items VALUES (1018, 105, 1)
INTO Order_Items VALUES (1019, 106, 2)
INTO Order_Items VALUES (1020, 107, 1)
SELECT * FROM dual;


-- top selling products

select p.product_id, p.name, sum(o.quantity) as total_sold
from products p
join order_items o 
on p.product_id = o.product_id
group by p.product_id, p.name
order by total_sold desc;


-- Most valuable customers

select c.customer_id, c.name, sum(oi.quantity) as total_items_bought
from customers c
join orders o 
on c.customer_id = o.customer_id
join order_items oi 
on o.order_id = oi.order_id
group by c.customer_id, c.name
order by total_items_bought desc;


-- monthly revenue sales 

select 
    to_char(o."date", 'yyyy-mm') as month,
    -- total revenue (already there)
    sum(p.price * oi.quantity) as total_revenue,
    -- average revenue in that month
    avg(p.price * oi.quantity) as avg_sale,
    -- most sales date in that month 
    max(o."date") as most_sales_date
from orders o
join order_items oi 
on o.order_id = oi.order_id
join products p 
on oi.product_id = p.product_id

group by to_char(o."date", 'yyyy-mm')
order by month;


-- category wise analysis 

select 
    p.category,
    -- total sold (already there)
    sum(oi.quantity) as total_sold,
    -- average quantity per order
    avg(oi.quantity) as avg_quantity,
    -- most frequent quantity (simple way using max)
    max(oi.quantity) as most_frequent_quantity
from products p
join order_items oi 
on p.product_id = oi.product_id
group by p.category
order by total_sold desc;


-- detect inactive customers

select c.customer_id, c.name
from customers c
left join orders o 
on c.customer_id = o.customer_id
where o.order_id is null; 