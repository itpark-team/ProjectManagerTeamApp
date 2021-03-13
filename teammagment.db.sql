BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "roles" (
	"id"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "staff" (
	"id"	INTEGER NOT NULL,
	"login"	TEXT NOT NULL,
	"password"	TEXT NOT NULL,
	"name"	TEXT NOT NULL,
	"position_id"	INTEGER NOT NULL,
	"age"	INTEGER NOT NULL,
	"photo"	TEXT NOT NULL,
	"work_experience"	INTEGER NOT NULL,
	"description"	TEXT NOT NULL,
	"role_id"	INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "positions" (
	"id"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "roles" ("id","name") VALUES (1,'Руководитель'),
 (2,'Сотрудник');
INSERT INTO "staff" ("id","login","password","name","position_id","age","photo","work_experience","description","role_id") VALUES (1,'ann','123','Анна',1,21,'ann',3,'Имеет хорошие знания по своей специальности, достаточную эрудицию в других служебных вопросах. Может решать все вопросы, касавшиеся своей работы, совершенно самостоятельно, не ожидая чьей-либо подсказки или указания.',2),
 (2,'ivan','123','Иван',4,41,'ivan',15,'За время своей работы продемонстрировал лидерские качества, отличные навыки планирования, умение оперативно решать сложные вопросы и работать на стратегическое развитие компании. ',1),
 (3,'dima','123','Дмитрий',2,18,'dima',4,'К работе относится творчески, ответственно.  Всегда готов прийти на помощь и дать полезный совет.',2),
 (4,'ilya','123','Илья',3,24,'ilya',5,'В отношениях с коллегами и деловыми партнёрами корректен, вежлив, приветлив. Отличается вниманием и умением слушать. Дискуссии ведёт спокойно и аргументированно.  ',2),
 (5,'elena','123','Елена',5,18,'elena',3,'Трудолюбива, обладает высокой работоспособностью, всячески поддерживает работу компании в сложные моменты, в том числе и во внеурочное время.',2);
INSERT INTO "positions" ("id","name") VALUES (1,'Менеджер по продажам'),
 (2,'Программист'),
 (3,'Руководитель команды'),
 (4,'Директор подразделения'),
 (5,'Дизайнер');
COMMIT;
