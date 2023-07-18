insert into user_tb(username, password, email, nickname, created_at) values ('강경민', '1111', 'abcd@gamil.com', '강씨', now());
insert into user_tb(username, password, email, nickname, created_at) values ('신용호', '1111', 'efgjh@gamil.com', '신씨', now());
insert into user_tb(username, password, email, nickname, created_at) values ('양수현', '1111', 'ijkl@gamil.com', '양씨', now());
insert into user_tb(username, password, email, nickname, created_at) values ('호윤', '1111', 'mnop@gamil.com', '호호', now());

insert into role_tb(role, user_id) values ('새싹', 1);
insert into role_tb(role, user_id) values ('우수', 2);
insert into role_tb(role, user_id) values ('우수', 3);
insert into role_tb(role, user_id) values ('새싹', 4);