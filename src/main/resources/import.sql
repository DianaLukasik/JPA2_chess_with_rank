insert into user_profile (about_me,email,life_motto,name,surname) values ('aaaaaa','mail@mm.com','some motto','Mirek','Goniec');
insert into user_profile (about_me,email,life_motto,name,surname) values ('yyyyyyyy','poczta@mm.com','nie mam motto','Alina','Pionek');
insert into user_profile (about_me,email,life_motto,name,surname) values ('bla bla blaaa','imejl@aa.com','ale motto','Adam','Rzeka');
insert into user_profile (about_me,email,life_motto,name,surname) values ('randoooom','costam@cos.com','niemotto','Henryk','Kania');

insert into user (login, password, score, user_profile) values ('ktostam', '12345678', 100, 1);
insert into user (login, password, score, user_profile) values ('loginek', '11122233', 25, 2);
insert into user (login, password, score, user_profile) values ('studnia', 'kakakakaka1', 80, 3);
insert into user (login, password, score, user_profile) values ('kamien', 'veuwiwueo', 50, 4);

insert into game (loser_points, winner_points, loser, winner) values (1,9,1,2);
insert into game (loser_points, winner_points, loser, winner) values (8,2,2,1);
insert into game (loser_points, winner_points, loser, winner) values (3,5,2,1);
insert into game (loser_points, winner_points, loser, winner) values (1,10,2,1);

insert into ranking_position (total_score, user) values (100,1);
insert into ranking_position (total_score, user) values (25,2);
insert into ranking_position (total_score, user) values (80,3);
insert into ranking_position (total_score, user) values (50,4);

insert into user_game_set (user_entity_user_game,game_set_id_game) values (1,1);
insert into user_game_set (user_entity_user_game,game_set_id_game) values (2,1);
insert into user_game_set (user_entity_user_game,game_set_id_game) values (3,2);
insert into user_game_set (user_entity_user_game,game_set_id_game) values (4,2);
insert into user_game_set (user_entity_user_game,game_set_id_game) values (1,3);
insert into user_game_set (user_entity_user_game,game_set_id_game) values (2,3);
insert into user_game_set (user_entity_user_game,game_set_id_game) values (3,4);
insert into user_game_set (user_entity_user_game,game_set_id_game) values (1,4);
