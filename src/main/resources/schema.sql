DROP TABLE IF EXISTS CLIENTS CASCADE;
DROP TABLE IF EXISTS ORDERS CASCADE;

create table clients (
    id serial not null,
    name varchar(255),
    primary key (id));

create table orders (
    id serial not null,
    amount float(53) not null,
    date date,
    description varchar(255),
    client_id integer,
    primary key (id));

alter table if exists orders add constraint FK_order_client
    foreign key (client_id) references clients