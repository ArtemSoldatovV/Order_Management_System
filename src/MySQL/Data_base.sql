create table if not exists customers
(
    customer_ID serial not null primary key,
    customer_name Varchar(50) not null
);
create table if not exists products
(
    product_ID serial not null primary key,
    product_name Varchar(50) not null,
    product_price double(5,2) not null
);

create table if not exists Orders
(
    Order_ID serial not null primary key,
    creation_date date not null,
    customer_ID int not null references customers (customer_ID)
);
create table if not exists order_product
(
    product_ID int not null references products (product_ID),
    Order_ID int not null references Orders (Order_ID)
);