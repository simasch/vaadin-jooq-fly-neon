create table person
(
    id         serial primary key,
    first_name varchar null,
    last_name  varchar null
);

insert into person (first_name, last_name) values ('John', 'Doe') on conflict do nothing;
insert into person (first_name, last_name) values ('Jane', 'Doe') on conflict do nothing;