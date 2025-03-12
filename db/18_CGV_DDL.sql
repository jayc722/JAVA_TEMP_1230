DROP DATABASE IF EXISTS `CGV`;

CREATE DATABASE `CGV`;

USE `CGV`;

-- ----------------------------------------------------------- 이 부분 추가 --------------------------------- --

DROP TABLE IF EXISTS `MOVIE`;

CREATE TABLE `MOVIE` (
	`MV_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`MV_TITLE`	VARCHAR(200) NOT	NULL,
	`MV_TIME`	INT NOT	NULL,
	`MV_DATE`	DATE	NULL,
	`MV_CONTENT`	LONGTEXT NOT	NULL,
	`MV_STATE`	ENUM("상영중", "상영예정","상영종료") NOT	NULL,
	`MV_MR_AGE`	VARCHAR(10)	NOT NULL
);

DROP TABLE IF EXISTS `GENRE`;

CREATE TABLE `GENRE` (
	`GR_NAME`	VARCHAR(10) PRIMARY KEY	NOT NULL
);

DROP TABLE IF EXISTS `MOVIE_GENRE`;

CREATE TABLE `MOVIE_GENRE` (
	`MG_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`MG_MV_NUM`	INT	NOT NULL,
	`MG_GR_NAME`	VARCHAR(10)	NOT NULL
);

DROP TABLE IF EXISTS `ACTOR`;

CREATE TABLE `ACTOR` (
	`AT_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`AT_POSITION`	ENUM("배우","감독") NOT	NULL,
	`AT_PR_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `MOVIE_ACTOR`;

CREATE TABLE `MOVIE_ACTOR` (
	`MA_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`MA_ROLE`	VARCHAR(50) NOT	NULL,
	`MA_MV_NUM`	INT	NOT NULL,
	`MA_AT_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `COUNTRY`;

CREATE TABLE `COUNTRY` (
	`CT_NAME`	VARCHAR(50) PRIMARY KEY	NOT NULL
);

DROP TABLE IF EXISTS `MOVIE_COUNTRY`;

CREATE TABLE `MOVIE_COUNTRY` (
	`MC_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`MC_CT_NAME`	VARCHAR(50)	NOT NULL,
	`MC_MV_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `FILE`;

CREATE TABLE `FILE` (
	`FI_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`FI_NAME`	VARCHAR(255) NOT	NULL,
	`FI_TYPE`	ENUM("S","T") NOT	NULL,
	`FI_MV_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `PERSON`;

CREATE TABLE `PERSON` (
	`PR_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`PR_NAME`	VARCHAR(50) NOT	NULL,
	`PR_BIRTH`	DATE	NULL,
	`PR_DETAIL`	LONGTEXT NOT	NULL,
	`PR_CT_NAME`	VARCHAR(50)	NULL
);

DROP TABLE IF EXISTS `MOVIE_RATINGS`;

CREATE TABLE `MOVIE_RATINGS` (
	`MR_AGE`	VARCHAR(10) PRIMARY KEY	NOT NULL
);

DROP TABLE IF EXISTS `SCHEDULE`;

CREATE TABLE `SCHEDULE` (
	`SD_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`SD_DATE`	DATE NOT	NULL,
	`SD_TIME`	TIME NOT	NULL,
	`SD_POS_SEAT`	INT NOT	NULL,
	`SD_EARLY`	ENUM("Y","N") DEFAULT "N" NOT 	NULL,
	`SD_MV_NUM`	INT	NOT NULL,
	`SD_SC_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `SCREEN`;

CREATE TABLE `SCREEN` (
	`SC_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`SC_NAME`	VARCHAR(20) NOT	NULL,
	`SC_SEAT`	INT NOT	NULL,
	`SC_POS`	ENUM("Y","N") DEFAULT "Y" NOT	NULL,
	`SC_TT_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `THEATER`;

CREATE TABLE `THEATER` (
	`TT_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`TT_NAME`	VARCHAR(30) NOT	NULL,
	`TT_ADDR`	VARCHAR(255) NOT	NULL,
	`TT_COUNT`	INT NOT	NULL,
	`TT_RG_NAME`	VARCHAR(15)	NOT NULL
);

DROP TABLE IF EXISTS `REGION`;

CREATE TABLE `REGION` (
	`RG_NAME`	VARCHAR(15) PRIMARY KEY	NOT NULL
);

DROP TABLE IF EXISTS `SEAT`;

CREATE TABLE `SEAT` (
	`SE_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`SE_NAME`	VARCHAR(3) NOT	NULL,
	`SE_POS`	ENUM("Y","N") DEFAULT "Y" NOT	NULL,
	`SE_SC_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `MEMBER` (
	`ME_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`ME_ID`	VARCHAR(13) UNIQUE NOT	NULL,
	`ME_PW`	VARCHAR(15) NOT	NULL,
	`ME_AUTHORITY`	ENUM("ADMIN","USER") DEFAULT "USER" NOT	NULL
);

DROP TABLE IF EXISTS `TICKET`;

CREATE TABLE `TICKET` (
	`TI_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`TI_ADULT`	INT NOT	NULL,
	`TI_TEEN`	INT NOT	NULL,
	`TI_PRICE`	INT NOT	NULL,
	`TI_STATE`	ENUM("결제","취소") DEFAULT "결제" NOT	NULL,
	`TI_ME_NUM`	INT	NOT NULL,
	`TI_SD_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `TICKET_LIST`;

CREATE TABLE `TICKET_LIST` (
	`TL_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`TL_TI_NUM`	INT	NOT NULL,
	`TL_SE_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `FEE`;

CREATE TABLE `FEE` (
	`FE_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`FE_TYPE`	VARCHAR(10) NOT	NULL,
	`FE_PRICE`	INT NOT	NULL,
	`FE_DATE`	DATE	NULL
);

ALTER TABLE `MOVIE` ADD CONSTRAINT `FK_MOVIE_RATINGS_TO_MOVIE_1` FOREIGN KEY (
	`MV_MR_AGE`
)
REFERENCES `MOVIE_RATINGS` (
	`MR_AGE`
);

ALTER TABLE `MOVIE_GENRE` ADD CONSTRAINT `FK_MOVIE_TO_MOVIE_GENRE_1` FOREIGN KEY (
	`MG_MV_NUM`
)
REFERENCES `MOVIE` (
	`MV_NUM`
);

ALTER TABLE `MOVIE_GENRE` ADD CONSTRAINT `FK_GENRE_TO_MOVIE_GENRE_1` FOREIGN KEY (
	`MG_GR_NAME`
)
REFERENCES `GENRE` (
	`GR_NAME`
);

ALTER TABLE `ACTOR` ADD CONSTRAINT `FK_PERSON_TO_ACTOR_1` FOREIGN KEY (
	`AT_PR_NUM`
)
REFERENCES `PERSON` (
	`PR_NUM`
);

ALTER TABLE `MOVIE_ACTOR` ADD CONSTRAINT `FK_MOVIE_TO_MOVIE_ACTOR_1` FOREIGN KEY (
	`MA_MV_NUM`
)
REFERENCES `MOVIE` (
	`MV_NUM`
);

ALTER TABLE `MOVIE_ACTOR` ADD CONSTRAINT `FK_ACTOR_TO_MOVIE_ACTOR_1` FOREIGN KEY (
	`MA_AT_NUM`
)
REFERENCES `ACTOR` (
	`AT_NUM`
);

ALTER TABLE `MOVIE_COUNTRY` ADD CONSTRAINT `FK_COUNTRY_TO_MOVIE_COUNTRY_1` FOREIGN KEY (
	`MC_CT_NAME`
)
REFERENCES `COUNTRY` (
	`CT_NAME`
);

ALTER TABLE `MOVIE_COUNTRY` ADD CONSTRAINT `FK_MOVIE_TO_MOVIE_COUNTRY_1` FOREIGN KEY (
	`MC_MV_NUM`
)
REFERENCES `MOVIE` (
	`MV_NUM`
);

ALTER TABLE `FILE` ADD CONSTRAINT `FK_MOVIE_TO_FILE_1` FOREIGN KEY (
	`FI_MV_NUM`
)
REFERENCES `MOVIE` (
	`MV_NUM`
);

ALTER TABLE `PERSON` ADD CONSTRAINT `FK_COUNTRY_TO_PERSON_1` FOREIGN KEY (
	`PR_CT_NAME`
)
REFERENCES `COUNTRY` (
	`CT_NAME`
);

ALTER TABLE `SCHEDULE` ADD CONSTRAINT `FK_MOVIE_TO_SCHEDULE_1` FOREIGN KEY (
	`SD_MV_NUM`
)
REFERENCES `MOVIE` (
	`MV_NUM`
);

ALTER TABLE `SCHEDULE` ADD CONSTRAINT `FK_SCREEN_TO_SCHEDULE_1` FOREIGN KEY (
	`SD_SC_NUM`
)
REFERENCES `SCREEN` (
	`SC_NUM`
);

ALTER TABLE `SCREEN` ADD CONSTRAINT `FK_THEATER_TO_SCREEN_1` FOREIGN KEY (
	`SC_TT_NUM`
)
REFERENCES `THEATER` (
	`TT_NUM`
);

ALTER TABLE `THEATER` ADD CONSTRAINT `FK_REGION_TO_THEATER_1` FOREIGN KEY (
	`TT_RG_NAME`
)
REFERENCES `REGION` (
	`RG_NAME`
);

ALTER TABLE `SEAT` ADD CONSTRAINT `FK_SCREEN_TO_SEAT_1` FOREIGN KEY (
	`SE_SC_NUM`
)
REFERENCES `SCREEN` (
	`SC_NUM`
);

ALTER TABLE `TICKET` ADD CONSTRAINT `FK_MEMBER_TO_TICKET_1` FOREIGN KEY (
	`TI_ME_NUM`
)
REFERENCES `MEMBER` (
	`ME_NUM`
);

ALTER TABLE `TICKET` ADD CONSTRAINT `FK_SCHEDULE_TO_TICKET_1` FOREIGN KEY (
	`TI_SD_NUM`
)
REFERENCES `SCHEDULE` (
	`SD_NUM`
);

ALTER TABLE `TICKET_LIST` ADD CONSTRAINT `FK_TICKET_TO_TICKET_LIST_1` FOREIGN KEY (
	`TL_TI_NUM`
)
REFERENCES `TICKET` (
	`TI_NUM`
);

ALTER TABLE `TICKET_LIST` ADD CONSTRAINT `FK_SEAT_TO_TICKET_LIST_1` FOREIGN KEY (
	`TL_SE_NUM`
)
REFERENCES `SEAT` (
	`SE_NUM`
);

/*  -- 이 부분 지워줘야 AUTO INCREMENT 적용됨
ALTER TABLE `SEAT` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
	`SE_NUM`
);

ALTER TABLE `TICKET` ADD CONSTRAINT `PK_TICKET` PRIMARY KEY (
	`TI_NUM`
);

ALTER TABLE `FEE` ADD CONSTRAINT `PK_FEE` PRIMARY KEY (
	`FE_NUM`
);

ALTER TABLE `COUNTRY` ADD CONSTRAINT `PK_COUNTRY` PRIMARY KEY (
	`CT_NAME`
);

ALTER TABLE `GENRE` ADD CONSTRAINT `PK_GENRE` PRIMARY KEY (
	`GR_NAME`
);

ALTER TABLE `MEMBER` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`ME_NUM`
);

ALTER TABLE `MOVIE_ACTOR` ADD CONSTRAINT `PK_MOVIE_ACTOR` PRIMARY KEY (
	`MA_NUM`
);

ALTER TABLE `FILE` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
	`FI_NUM`
);

ALTER TABLE `ACTOR` ADD CONSTRAINT `PK_ACTOR` PRIMARY KEY (
	`AT_NUM`
);

ALTER TABLE `PERSON` ADD CONSTRAINT `PK_PERSON` PRIMARY KEY (
	`PR_NUM`
);

ALTER TABLE `TICKET_LIST` ADD CONSTRAINT `PK_TICKET_LIST` PRIMARY KEY (
	`TL_NUM`
);

ALTER TABLE `SCHEDULE` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
	`SD_NUM`
);

ALTER TABLE `MOVIE_COUNTRY` ADD CONSTRAINT `PK_MOVIE_COUNTRY` PRIMARY KEY (
	`MC_NUM`
);

ALTER TABLE `MOVIE_RATINGS` ADD CONSTRAINT `PK_MOVIE_RATINGS` PRIMARY KEY (
	`MR_AGE`
);

ALTER TABLE `MOVIE_GENRE` ADD CONSTRAINT `PK_MOVIE_GENRE` PRIMARY KEY (
	`MG_NUM`
);

ALTER TABLE `REGION` ADD CONSTRAINT `PK_REGION` PRIMARY KEY (
	`RG_NAME`
);

ALTER TABLE `THEATER` ADD CONSTRAINT `PK_THEATER` PRIMARY KEY (
	`TT_NUM`
);

ALTER TABLE `MOVIE` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
	`MV_NUM`
);

ALTER TABLE `SCREEN` ADD CONSTRAINT `PK_SCREEN` PRIMARY KEY (
	`SC_NUM`
);
*/