create table user_tb(
                        id bigint auto_increment primary key,
                        username varchar(10) not null,
                        password varchar(20) not null,
                        email varchar(25) not null,
                        nickname varchar(10) not null,
                        created_at timestamp not null,
                        updated_at timestamp
);

create table role_tb(
                        id bigint auto_increment primary key,
                        role varchar(10) not null,
                        user_id bigint,
                        foreign key (user_id) references user_tb(id)
);