CREATE SCHEMA test;

create table test.karyawan(
id INT GENERATED ALWAYS AS IDENTITY,
created_date TIMESTAMP NOT NULL,
deleted_date TIMESTAMP,
updated_date TIMESTAMP,
alamat VARCHAR(100) NOT NULL,
dob TIMESTAMP,
nama VARCHAR(100) NOT NULL,
status VARCHAR(100),
detail_karyawan INT UNIQUE,
PRIMARY KEY(id),
CONSTRAINT fk_karyawan	
FOREIGN KEY(detail_karyawan) 
REFERENCES test.detail_karyawan(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);


create table test.detail_karyawan(
id INT GENERATED ALWAYS AS IDENTITY,
created_date TIMESTAMP NOT NULL,
deleted_date TIMESTAMP,
updated_date TIMESTAMP,
nik VARCHAR(50) NOT NULL,
npwp VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);


create table test.rekening(
id INT GENERATED ALWAYS AS IDENTITY,
created_date TIMESTAMP NOT NULL,
deleted_date TIMESTAMP,
updated_date TIMESTAMP,
jenis VARCHAR(50) NOT NULL,
nama VARCHAR(50) NOT NULL,
rekening int NOT NULL,
id_karyawan int,
PRIMARY KEY(id),
CONSTRAINT fk_karyawan	
FOREIGN KEY(id_karyawan) 
REFERENCES test.karyawan(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);


create table test.training(
id INT GENERATED ALWAYS AS IDENTITY,
created_date TIMESTAMP NOT NULL,
deleted_date TIMESTAMP,
updated_date TIMESTAMP,
pengajar VARCHAR(50) NOT NULL,
tema VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);


create table test.karyawan_training(
id INT GENERATED ALWAYS AS IDENTITY,
created_date TIMESTAMP NOT NULL,
deleted_date TIMESTAMP,
updated_date TIMESTAMP,
tanggal TIMESTAMP,
id_karyawan int,
id_training int,
PRIMARY KEY(id),
CONSTRAINT fk_karyawan	
FOREIGN KEY(id_karyawan) 
REFERENCES test.karyawan(id),
CONSTRAINT fk_training	
FOREIGN KEY(id_training) 
REFERENCES test.training(id)
ON DELETE cascade
ON UPDATE CASCADE
);