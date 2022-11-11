create table artist (
    id int auto_increment,
    name varchar(200) not null,
    nationality varchar(100) not null,
    year_start int not null,
    constraint artist_pk primary key (id)
);

create table album (
    id int auto_increment,
    title varchar(200) not null,
    publish_date date not null,
    genre varchar(20) not null,
    discs_amount int default 1 not null,
    artist_id int not null,
    constraint album_pk primary key (id),
    constraint album_artist_fk foreign key (id) references artist(id)
);


create table track (
    id int auto_increment,
    title varchar(200) not null,
    duration_in_seconds int not null,
    album_id int not null,
    constraint track_pk primary key (id),
    constraint track_album_fk foreign key (album_id) references album(id)
);

create table application_user (
    id int auto_increment,
    name varchar(200) not null,
    surname varchar(200) not null,
    email varchar(200) not null,
    password varchar(200) not null,
    created date not null,
    constraint application_user_pk primary key (id)
);

create table role (
  id int not null,
  name varchar(50) not null,
  constraint role_pk primary key (id)
);

insert into role values (1, 'ADMIN');
insert into role values (2, 'USER');

create table application_user_role (
    application_user_id int not null,
    role_id int not null,
    constraint application_user_role_pk primary key (application_user_id, role_id),
    constraint application_user_role_au_fk foreign key (application_user_id) references application_user(id),
    constraint application_user_role_r_fk foreign key (role_id) references role(id)
);