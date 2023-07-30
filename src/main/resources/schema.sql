create table homework.CUSTOMERS (
    id           int auto_increment,
    name         varchar(255),
    surname      varchar(255),
    age          int,
    phone_number varchar(15),

    primary key (id)
);

create table homework.ORDERS (
    id           int auto_increment,
    date         varchar(255),
    customer_id  int,
    product_name varchar(255),
    amount       int,

    primary key (id),
    foreign key (customer_id) references CUSTOMERS (id)
);
