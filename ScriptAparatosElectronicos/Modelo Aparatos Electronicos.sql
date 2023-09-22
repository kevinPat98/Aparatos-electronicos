DROP USER ELECTRONIC_DEVICES_PROYECT CASCADE;
CREATE USER ELECTRONIC_DEVICES_PROYECT IDENTIFIED BY A;
GRANT CONNECT, RESOURCE, DBA TO ELECTRONIC_DEVICES_PROYECT;
GRANT ALL PRIVILEGES TO ELECTRONIC_DEVICES_PROYECT;
CONN ELECTRONIC_DEVICES_PROYECT/A

SELECT * from cat;

create table TIPO
(
   ID_TIPO INT not null,
   NOMBRE VARCHAR2(100) not null,
   CARACTERISTICA VARCHAR2(100) not null,
   ID_SUPER_TIPO INT,
   constraint PK_TIPO primary key (ID_TIPO)
);

create table FABRICANTE
(
   ID_FABRICANTE INT not null,
   RIF INT not null,
   NOMBRE VARCHAR2(100) not null,
   DOMICILIO VARCHAR2(100) not null,
   constraint PK_FABRICANTE primary key (ID_FABRICANTE)
);

create table COMPONENTE
(
   ID_COMPONENTE INT not null,
   ID_FABRICANTE INT not null,
   NOMBRE VARCHAR2(100) not null,
   ESPECIFICACIONES VARCHAR2(100) not null,
   constraint PK_COMPONENTE primary key (ID_COMPONENTE)
);

create table REGISTRO_UNIDADES
(
   ID_COMPONENTE INT not null,
   ID_APARATO INT not null,
   UNIDADES INT not null,
   constraint PK_REGISTRO_UNIDADES primary key (ID_COMPONENTE,ID_APARATO)
);

create table APARATO
(
   ID_APARATO INT not null,
   ID_TIPO INT not null,
   CODIGO INT not null,
   NOMBRE VARCHAR2(100) not null,
   DESCRIPCION VARCHAR2(255) not null,
   constraint PK_APARATO primary key (ID_APARATO)
);

create table REPARACION
(
   ID_REPARACION INT not null,
   ID_APARATO INT not null,
   ID_CLIENTE INT not null,
   REFERENCIA VARCHAR2(100) not null,
   DESCRIPCION VARCHAR2(255) not null,
   FECHA_REPARACION DATE not null,
   constraint PK_REPARACION primary key (ID_REPARACION)
);

create table CLIENTE
(
   ID_CLIENTE INT not null,
   DOCUMENTO VARCHAR2(100) not null,
   NOMBRE VARCHAR2(255) not null,
   DIRECCION VARCHAR2(255) not null,
   TELEFONO VARCHAR2(255) not null,
   CORREO VARCHAR2(255) not null,
   constraint PK_CLIENTE primary key (ID_CLIENTE)
);

alter table TIPO 
   add constraint FK_TIPO_TIPO foreign key (ID_SUPER_TIPO)
      references TIPO (ID_TIPO);


alter table COMPONENTE 
   add constraint FK_FABRICANTE foreign key (ID_FABRICANTE)
      references FABRICANTE (ID_FABRICANTE);

ALTER TABLE REGISTRO_UNIDADES
   ADD CONSTRAINT FK_REGISTRO_COMPONENTE FOREIGN KEY (ID_COMPONENTE)
      REFERENCES COMPONENTE(ID_COMPONENTE);

-- Agregar la clave externa a la tabla REGISTRO_UNIDADES que hace referencia a APARATO
ALTER TABLE REGISTRO_UNIDADES
   ADD CONSTRAINT FK_REGISTRO_APARATO FOREIGN KEY (ID_APARATO)
      REFERENCES APARATO(ID_APARATO);


alter table APARATO 
   add constraint FK_APARATO foreign key (ID_TIPO)
      references TIPO (ID_TIPO);
   
alter table REPARACION 
   add constraint FK_REPARACION_APARATO foreign key (ID_APARATO)
      references APARATO (ID_APARATO);

alter table REPARACION 
   add constraint FK_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE);

create sequence TIPO_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence FABRICANTE_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence COMPONENTE_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence APARATO_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence REPARACION_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence CLIENTE_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;

COMMIT;
