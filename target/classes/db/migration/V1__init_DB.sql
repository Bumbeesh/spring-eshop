create sequence bucket_seq start with 1 increment by 1;
create sequence category_seq start with 1 increment by 1;
create sequence order_seq start with 1 increment by 1;
create sequence product_seq start with 1 increment by 1;
create sequence users_seq start with 1 increment by 1;
create table buckets
(
    id      bigint not null,
    user_id bigint unique,
    primary key (id)
);
create table buckets_categories
(
    category_id bigint not null,
    product_id  bigint not null
);
create table buckets_products
(
    bucket_id  bigint not null,
    product_id bigint not null
);
create table categories
(
    id    bigint not null,
    title varchar(255),
    primary key (id)
);
create table orders
(
    sum     numeric(38, 2),
    created timestamp(6),
    id      bigint not null,
    updated timestamp(6),
    user_id bigint,
    status  varchar(255) check (status in ('NEW', 'APPROVED', 'CANCELLED', 'PAID', 'CLOSED')),
    primary key (id)
);
create table products
(
    price numeric(38, 2),
    id    bigint not null,
    title varchar(255),
    primary key (id)
);
create table users
(
    archive   boolean not null,
    bucket_id bigint unique,
    id        bigint  not null,
    name      varchar(255),
    password  varchar(255),
    role      varchar(255) check (role in ('CLIENT', 'MANAGER', 'ADMIN')),
    primary key (id)
);
alter table if exists buckets add constraint FKnl0ltaj67xhydcrfbq8401nvj foreign key (user_id) references users;
alter table if exists buckets_categories add constraint FK8qo8ij2wgbl0d26h7sr3juylk foreign key (category_id) references categories;
alter table if exists buckets_categories add constraint FKk88wfnjd8wtl8ikv6ila1a7sj foreign key (product_id) references products;
alter table if exists buckets_products add constraint FKloyxdc1uy11tayedf3dpu9lci foreign key (product_id) references products;
alter table if exists buckets_products add constraint FKc49ah45o66gy2f2f4c3os3149 foreign key (bucket_id) references buckets;
alter table if exists orders add constraint FK32ql8ubntj5uh44ph9659tiih foreign key (user_id) references users;
alter table if exists users add constraint FK8l2qc4c6gihjdyoch727guci foreign key (bucket_id) references buckets;