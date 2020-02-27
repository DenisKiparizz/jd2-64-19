CREATE TABLE Roles
(
    id        INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    role_name VARCHAR(255)                   not null
);

CREATE TABLE Users
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name     VARCHAR(20)                       not null,
    surname  VARCHAR(30)                       not null,
    username VARCHAR(50)                       not null,
    password VARCHAR(255)                      not null,
    role_id  INT                               NOT NULL DEFAULT 3,
    FOREIGN KEY (role_id) REFERENCES Roles (id)
);

INSERT INTO Roles(id, role_name)
VALUES (1, 'admin'),
       (2, 'master'),
       (3, 'user');

INSERT INTO users(name, surname, username, password, role_id)
VALUES ('Denis', 'Solodkiy', 'DenisKiparis', '12345', 1),
       ('Ivan', 'Ivaniv', 'IvanovIvan', '12345', 3),
       ('Mister', 'Improver', 'Xzibit', '12345', 2);



CREATE TABLE Make
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT not null,
    Make VARCHAR(20)                       NOT NULL
);
CREATE TABLE Model
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT not null,
    Model   VARCHAR(100)                      not null,
    make_id BIGINT                            not null,
    FOREIGN KEY (make_id) REFERENCES Make (id)
);
CREATE TABLE Body
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT not null,
    Type_of_body VARCHAR(30)                       not null
);
CREATE TABLE Engine
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT not null,
    Type_of_engine VARCHAR(30)                       not null
);
CREATE TABLE Car2
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT not null,
    make_id         BIGINT                            not null,
    model_id        BIGINT                            not null,
    body_id         BIGINT                            not null,
    engine_id       BIGINT                            not null,
    value_of_engine INT                               not null,
    age             INT                               not null,
    foreign key (make_id) REFERENCES Model (make_id) ON DELETE CASCADE,
    foreign key (model_id) REFERENCES Model (id) ON DELETE CASCADE,
    foreign key (body_id) REFERENCES Body (id) ON DELETE CASCADE,
    foreign key (engine_id) REFERENCES Engine (id) ON DELETE CASCADE
);

INSERT INTO Make(Make)
VALUES ('Acura'),
       ('Audi'),
       ('BMW'),
       ('Honda'),
       ('Tesla');
INSERT INTO Model(Model, make_id)
VALUES ('RSX', 1),
       ('MDX', 1),
       ('TSX', 1),
       ('A4', 2),
       ('A6', 2),
       ('A8', 2),
       ('e46', 3),
       ('e39', 3),
       ('x5', 3),
       ('Accord', 4),
       ('Civic', 4),
       ('S2000', 4),
       ('ModelS', 5),
       ('ModelX', 5),
       ('CuberTruck', 5);
INSERT INTO Body(Type_of_body)
VALUES ('Sedan'),
       ('Coupe'),
       ('Hatch-Back'),
       ('Minivan'),
       ('Estate'),
       ('Roadster');
INSERT INTO Engine(Type_of_engine)
VALUES ('GAS'),
       ('DISEL'),
       ('ELECTRO');

create table service_type
(
    id        bigint      not null primary key auto_increment,
    name_type varchar(40) not null
);
create table orders
(
    id              bigint       not null primary key auto_increment,
    title           varchar(30)  not null,
    service_type_id bigint,
    description     varchar(255) not null,
    foreign key (service_type_id) references service_type (id) on delete cascade
);

insert into service_type(name_type)
values ('Engine'),
       ('Brakes'),
       ('Body'),
       ('Static'),
       ('Wheels'),
       ('Custom repair');
create table car
(
    carID        bigint not null primary key auto_increment,
    make_id      bigint not null,
    model_id     bigint not null,
    body_id      bigint not null,
    engine_id    bigint not null,
    engine_value bigint not null,
    release_date DATE   not null,
    foreign key (make_id) references Make(id),
    foreign key (model_id) references Model(id),
    foreign key (body_id) references Body(id),
    foreign key (engine_id) references Engine(id)
);

