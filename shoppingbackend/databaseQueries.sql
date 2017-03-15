CREATE TABLE category(
id IDENTITY,
name VARCHAR(100),
imgURL VARCHAR(300),
is_active BOOLEAN,
CONSTRAINT pk_category_id PRIMARY KEY(id)
	
);


insert into category (name,imgurl,is_active) values ('Hot Set','hs1.jpg','true')