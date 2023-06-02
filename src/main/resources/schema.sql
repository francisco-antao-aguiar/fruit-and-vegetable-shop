create table PRODUCT(
  NAME varchar(100) not null,
  PRICE decimal not null,
  PRIMARY KEY ( NAME )
);

create table PRODUCT_ORDER(
  ID int not null AUTO_INCREMENT,
  DATE date not null,
  USERNAME varchar(20) not null,
  AMOUNT int not null,
  PRODUCT varchar(100) not null,
  PRIMARY KEY ( ID )
);