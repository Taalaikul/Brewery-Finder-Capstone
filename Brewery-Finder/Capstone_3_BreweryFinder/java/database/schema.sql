BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS beers;
DROP SEQUENCE IF EXISTS seq_beer_id;
DROP TABLE IF EXISTS breweries;
DROP SEQUENCE IF EXISTS seq_brewery_id;
DROP TABLE IF EXISTS reviews;
DROP SEQUENCE IF EXISTS seq_reviews_id;
DROP TABLE IF EXISTS brewery_beers;
DROP SEQUENCE IF EXISTS seq_brewery_beers_id;
DROP TABLE IF EXISTS beer_reviews;
DROP SEQUENCE IF EXISTS seq_beer_reviews_id;
DROP TABLE IF EXISTS brewery_users;
DROP SEQUENCE IF EXISTS seq_brewery_users_id;
DROP TABLE IF EXISTS user_reviews;
DROP SEQUENCE IF EXISTS seq_user_reviews_id;


CREATE SEQUENCE seq_user_id
      INCREMENT BY 1
      NO MAXVALUE
      NO MINVALUE
      CACHE 1;

CREATE SEQUENCE seq_beer_id
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;

CREATE SEQUENCE seq_brewery_id
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;

CREATE SEQUENCE seq_reviews_id
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;

CREATE SEQUENCE seq_brewery_beers_id
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;

CREATE SEQUENCE seq_beer_reviews_id
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;

CREATE SEQUENCE seq_brewery_users_id
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;

CREATE SEQUENCE seq_user_reviews_id
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;

CREATE TABLE users (
    user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
    username varchar(50) NOT NULL,
    password_hash varchar(200) NOT NULL,
    role varchar(50) NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
) ;


CREATE TABLE beers (
    beer_id int DEFAULT nextval('seq_beer_id'::regclass) NOT NULL,
    beer_name varchar(100) NOT NULL,
    description varchar (300) NOT NULL,
    image varchar(100) NOT NULL,
    abv int NOT NULL,
    type varchar(50),
    PRIMARY KEY (beer_id)
) ;

CREATE TABLE brewery (
    brewery_id int DEFAULT nextval('seq_brewery_id'::regclass) NOT NULL,
    brewery_name varchar(100) NOT NULL,
    phone_number varchar(10) NOT NULL,
    history varchar(300) NOT NULL,
    hours_of_operation varchar(50) NOT NULL,
    images varchar(100) NOT NULL,
    address varchar(100) NOT NULL,
    activity varchar(100) NOT NULL,
    PRIMARY KEY (brewery_id)
) ;

CREATE TABLE reviews (
    review_id int DEFAULT nextval('seq_reviews_id'::regclass) NOT NULL,
    stars int NOT NULL,
    review varchar(300) NOT NULL,
    PRIMARY KEY (review_id)
) ;

CREATE TABLE brewery_beers (
    brewery_beers_id int DEFAULT nextval('seq_brewery_beers_id'::regclass) NOT NULL,
    beer_id int NOT NULL,
    brewery_id int NOT NULL,
    FOREIGN KEY (beer_id) REFERENCES beers(beer_id),
    FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)

);

CREATE TABLE beer_reviews (
    brewery_reviews int DEFAULT nextval('seq_beer_reviews_id'::regclass) NOT NULL,
    beer_id int NOT NULL,
    review_id int NOT NULL,
    FOREIGN KEY (beer_id) REFERENCES beers(beer_id),
    FOREIGN KEY (review_id) REFERENCES reviews(review_id)
);

CREATE TABLE brewery_users (
    brewery_users_id int DEFAULT nextval('seq_brewery_users_id'::regclass) NOT NULL,
    brewery_id int NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)

);

CREATE TABLE user_reviews (
    user_reviews_id int DEFAULT nextval('seq_user_reviews_id'::regclass) NOT NULL,
    user_id int NOT NULL,
    review_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (review_id) REFERENCES reviews(review_id)

);


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;