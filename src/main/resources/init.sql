create table IF NOT EXISTS role
(
    id uuid default random_uuid(),
    name varchar_ignorecase(250) not null UNIQUE,
    constraint ROLE_PK primary key (id)
);
