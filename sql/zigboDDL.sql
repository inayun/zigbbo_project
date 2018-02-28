DROP TABLE APPLY cascade constraint;
DROP TABLE INTEREST cascade constraint;
DROP TABLE ITEM cascade constraint;
DROP TABLE MEMBER cascade constraint;
DROP TABLE PAYMENT cascade constraint;
DROP TABLE REQUEST cascade constraint;
DROP TABLE SELLING cascade constraint;
DROP TABLE REQUEST_PAYMENT cascade constraint;

DROP SEQUENCE apply_code_seq;
DROP SEQUENCE interest_seq;
DROP SEQUENCE item_code_seq;
DROP SEQUENCE member_code_seq;
DROP SEQUENCE payment_code_seq;
DROP SEQUENCE request_code_seq;
DROP SEQUENCE selling_code_seq;
DROP SEQUENCE request_payment_code_seq;


CREATE TABLE APPLY
(
	apply_code           NUMBER(3) PRIMARY KEY,
	request_code         NUMBER(3) NOT NULL ,
	member_code          NUMBER(3) NOT NULL ,
	detail               VARCHAR2(500) NULL 
);


CREATE TABLE INTEREST
(
	member_code          NUMBER(3) NOT NULL,
	selling_code         NUMBER(3) NOT NULL,
	PRIMARY KEY(member_code, selling_code)
);


CREATE TABLE ITEM
(
	item_code            NUMBER(3) NOT NULL PRIMARY KEY,
	title				 VARCHAR2(50) NULL ,
	price                VARCHAR2(50) NULL ,
	detail               VARCHAR2(500) NULL ,
	location             VARCHAR2(200) NULL ,
	picture              VARCHAR2(200) NULL
);


CREATE TABLE MEMBER
(
	member_code          NUMBER(3) NOT NULL PRIMARY KEY,
	email                VARCHAR2(50) NOT NULL ,
	password             VARCHAR2(50) NOT NULL ,
	phone                VARCHAR2(50) NOT NULL ,
	address              VARCHAR2(200) NOT NULL ,
	account              VARCHAR2(40) NOT NULL 
);


CREATE TABLE PAYMENT
(
	payment_code         NUMBER(3) NOT NULL PRIMARY KEY,
	selling_code         NUMBER(3) NOT NULL ,
	member_code          NUMBER(3) NOT NULL ,
	address              VARCHAR2(500) NOT NULL 
);


CREATE TABLE REQUEST_PAYMENT
(
	payment_code         NUMBER(3) NOT NULL PRIMARY KEY,
	request_code         NUMBER(3) NOT NULL ,
	member_code          NUMBER(3) NOT NULL ,
	address              VARCHAR2(500) NOT NULL 
);


CREATE TABLE REQUEST
(
	request_code         NUMBER(3) PRIMARY KEY,
	item_code            NUMBER(3) NOT NULL,
	member_code          NUMBER(3) NOT NULL,
	views                NUMBER(4) NULL,
	upload_date          DATE NULL,
	progress             VARCHAR2(1) NULL ,
	location             VARCHAR2(500) NOT NULL
);


CREATE TABLE SELLING
(
	selling_code         NUMBER(3) NOT NULL PRIMARY KEY,
	member_code          NUMBER(3) NOT NULL ,
	item_code            NUMBER(3) NOT NULL ,
	views                NUMBER(4) NULL ,
	upload_date          DATE NULL ,
	progress             VARCHAR2(1) NULL ,
	location             VARCHAR2(500) NOT NULL 
);

ALTER TABLE APPLY ADD (CONSTRAINT R_1 FOREIGN KEY (request_code) REFERENCES REQUEST (request_code));
ALTER TABLE APPLY ADD (CONSTRAINT R_2 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE INTEREST ADD (CONSTRAINT R_6 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE INTEREST ADD (CONSTRAINT R_7 FOREIGN KEY (selling_code) REFERENCES SELLING (selling_code));
ALTER TABLE PAYMENT ADD (CONSTRAINT R_8 FOREIGN KEY (selling_code) REFERENCES SELLING (selling_code));
ALTER TABLE PAYMENT ADD (CONSTRAINT R_9 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE REQUEST ADD (CONSTRAINT R_10 FOREIGN KEY (item_code) REFERENCES ITEM (item_code));
ALTER TABLE REQUEST ADD (CONSTRAINT R_11 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE SELLING ADD (CONSTRAINT R_12 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE SELLING ADD (CONSTRAINT R_13 FOREIGN KEY (item_code) REFERENCES ITEM (item_code));
ALTER TABLE REQUEST_PAYMENT ADD (CONSTRAINT R_14 FOREIGN KEY (request_code) REFERENCES REQUEST (request_code));
ALTER TABLE REQUEST_PAYMENT ADD (CONSTRAINT R_15 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));


CREATE SEQUENCE apply_code_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE
MINVALUE 0
NOCYCLE
NOCACHE;

CREATE SEQUENCE interest_seq
START WITH 0
INCREMENT BY 1
NOMAXVALUE
MINVALUE 0
NOCYCLE
NOCACHE;

CREATE SEQUENCE item_code_seq
START WITH 0
INCREMENT BY 1
NOMAXVALUE
MINVALUE 0
NOCYCLE
NOCACHE;

CREATE SEQUENCE member_code_seq
START WITH 0
INCREMENT BY 1
NOMAXVALUE
MINVALUE 0
NOCYCLE
NOCACHE;

CREATE SEQUENCE payment_code_seq
START WITH 0
INCREMENT BY 1
NOMAXVALUE
MINVALUE 0
NOCYCLE
NOCACHE;

CREATE SEQUENCE request_payment_code_seq
START WITH 0
INCREMENT BY 1
NOMAXVALUE
MINVALUE 0
NOCYCLE
NOCACHE;

CREATE SEQUENCE request_code_seq
START WITH 0
INCREMENT BY 1
NOMAXVALUE
MINVALUE 0
NOCYCLE
NOCACHE;

CREATE SEQUENCE selling_code_seq
START WITH 0
INCREMENT BY 1
NOMAXVALUE
MINVALUE 0
NOCYCLE
NOCACHE;