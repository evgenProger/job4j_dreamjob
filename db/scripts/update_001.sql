CREATE TABLE IF NOT EXISTS post
(
    id   SERIAL PRIMARY KEY,
    name TEXT,
    created timestamp
);

CREATE TABLE IF NOT EXISTS city
(
    id   SERIAL PRIMARY KEY,
    name TEXT

);

CREATE TABLE IF NOT EXISTS candidate
(
    id   SERIAL PRIMARY KEY,
    name TEXT,
    city_id int references city(id),
    created timestamp
);

CREATE TABLE IF NOT EXISTS users
(
    id   SERIAL PRIMARY KEY,
    name TEXT,
    email varchar(50) unique,
    password varchar(50)
);

CREATE TABLE IF NOT EXISTS city
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

insert into city(name) values ('Москва');
insert into city(name) values ('Абрамцево');
insert into city(name) values ('Алабино');
insert into city(name) values ('Апрелевка');
insert into city(name) values ('Архангельское');
insert into city(name) values ('Ашитково');
insert into city(name) values ('Байконур');
insert into city(name) values ('Бакшеево');
insert into city(name) values ('Балашиха');
insert into city(name) values ('Барыбино');
insert into city(name) values ('Белозёрский');
insert into city(name) values ('Белоомут');
insert into city(name) values ('Белые Столбы');
insert into city(name) values ('Бородино (Московская обл.)');
insert into city(name) values ('Бронницы');
insert into city(name) values ('Быково (Московская обл.)');
insert into city(name) values ('Валуево');
insert into city(name) values ('Вербилки');
insert into city(name) values ('Верея');
insert into city(name) values ('Видное');
insert into city(name) values ('Внуково');
insert into city(name) values ('Вождь Пролетариата');
insert into city(name) values ('Волоколамск');
insert into city(name) values ('Вороново');
insert into city(name) values ('Воскресенск');
insert into city(name) values ('Восточный');
insert into city(name) values ('Востряково');
insert into city(name) values ('Высоковск');
insert into city(name) values ('Голицыно (Московская обл.)');
insert into city(name) values ('Деденево');
insert into city(name) values ('Дедовск');
insert into city(name) values ('Дзержинский');
insert into city(name) values ('Дмитров');
insert into city(name) values ('Долгопрудный');
insert into city(name) values ('Домодедово');
insert into city(name) values ('Дорохово');
insert into city(name) values ('Дрезна');
insert into city(name) values ('Дубки');
insert into city(name) values ('Дубна');
insert into city(name) values ('Егорьевск');
insert into city(name) values ('Железнодорожный (Московск.)');
insert into city(name) values ('Жилево');
insert into city(name) values ('Жуковка');
insert into city(name) values ('Жуковский');
insert into city(name) values ('Загорск');
insert into city(name) values ('Загорянский');
insert into city(name) values ('Запрудная');
insert into city(name) values ('Зарайск');
insert into city(name) values ('Звенигород');
insert into city(name) values ('Зеленоград');
insert into city(name) values ('Ивантеевка (Московская обл.)');
insert into city(name) values ('Икша');
insert into city(name) values ('Ильинский (Московская обл.)');
insert into city(name) values ('Истра');
insert into city(name) values ('Калининец');
insert into city(name) values ('Кашира');
insert into city(name) values ('Керва');
