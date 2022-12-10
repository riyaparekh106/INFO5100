use test;

create table users(
  username VARCHAR (50) PRIMARY KEY,
  password VARCHAR (50)
);

create table vaults(
  vaultName VARCHAR (50) PRIMARY KEY,
  userName VARCHAR (50)
);

create table credentials (
   username VARCHAR (50) NOT NULL,
   vaultName VARCHAR (50) NOT NULL,
   credentialTitle VARCHAR(50) PRIMARY KEY,
   credentialUsername VARCHAR(50) NOT NULL,
   credentialPassword VARCHAR(50) NOT NULL
   );
   
create table notes (
   username VARCHAR (50),
   vaultName VARCHAR (50),
   noteTitle VARCHAR (50) PRIMARY KEY,
   noteContent VARCHAR (50)
   );


select * from users;
select * from vaults;
select * from credentials;
select * from notes;