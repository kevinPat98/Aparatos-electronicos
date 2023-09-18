DROP USER ELECTRONIC_DEVICES CASCADE;
CREATE USER ELECTRONIC_DEVICES IDENTIFIED BY A;
GRANT CONNECT, RESOURCE, DBA TO ELECTRONIC_DEVICES;
CONN ELECTRONIC_DEVICES/A

SELECT * from CAT

SELECT * from CLIENTE

/*==============================================================*/
/* Table: CLIENTE                                  */
/*==============================================================*/

create table CLIENTE
(
   ID_CLIENTE INT not null,
   NOMBRES VARCHAR2(100) not null,
   DIRECCION VARCHAR2(100) not null,
   TELEFONO INT not null,
   CORREO VARCHAR2(100) not null,
   constraint PK_CLIENTE primary key (ID_CLIENTE)
);

create table REPARACION
(
   ID_REPARACION INT not null,
   REPARACIONCOL VARCHAR2(100) not null,
   DESCRIPCION VARCHAR2(100) not null,
   FECHA DATE not null,
   ID_CLIENTE INT not null,
   ID_ELECTRODOMESTICO INT not null,
   constraint PK_REPARACION primary key (ID_REPARACION)
);

create table ELECTRODOMESTICO
(
   ID_ELECTRODOMESTICO INT not null,
   NOMBRE VARCHAR2(100) not null,
   DESCRIPCION VARCHAR2(100) not null,
   constraint PK_ELECTRODOMESTICO primary key (ID_ELECTRODOMESTICO)
);

/*==============================================================*/
/* Index: FACTURA_CLIENTE_FK                                   */
/*==============================================================*/
create index CLIENTE_FK on CLIENTE (
    ID_CLIENTE ASC
);
/*==============================================================*/
/* Index: FACTURA_VENDEDOR_FK                                */
/*==============================================================*/
create index REPARACION_FK on REPARACION (
    ID_REPARACION ASC
);

create index ELECTRODOMESTICO_FK on ELECTRODOMESTICO (
    ID_ELECTRODOMESTICO ASC
);
alter table REPARACION 
   add constraint FK_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE);
alter table REPARACION 
   add constraint FK_ELECTRODOMESTICO foreign key (ID_ELECTRODOMESTICO)
      references ELECTRODOMESTICO (ID_ELECTRODOMESTICO);


create sequence CLIENTE_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence REPARACION_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
create sequence ELECTRODOMESTICO_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;

COMMIT;