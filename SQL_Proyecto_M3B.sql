/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA USUARIO ADMINISTRADOR
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Admin_User (
    Cedula     VARCHAR2(10),
    Usuario    VARCHAR2(25),
    Contraseña VARCHAR2(25),
    PRIMARY KEY ( Cedula )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA PERSONAS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Persona (
    Ci               VARCHAR2(10),
    Nombre           VARCHAR2(25),
    Apellido         VARCHAR2(25),
    Correo           VARCHAR2(35),
    Direccion        VARCHAR2(40),
    Num_Celular      VARCHAR2(10),
    Estado           VARCHAR2(20),
    Fecha_Nacimiento VARCHAR2(20),
    PRIMARY KEY ( Ci )
);
drop table buf_usuarios;
drop table buf_clientes;
drop table buf_secretarias;
drop table buf_abogados;
drop table buf_persona;

/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA ABOGADOS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Abogados (
    Id_Abogado    NUMBER(8),
    Num_Matricula NUMBER(8),
    Ci_Abg        VARCHAR2(10),
    Num_Cuenta    NUMBER(10),
    Horario       VARCHAR2(70),
    Foto          BLOB,
    CONSTRAINT Fk_Pers_Abg FOREIGN KEY ( Ci_Abg )
        REFERENCES Buf_Persona ( Ci ),
    PRIMARY KEY ( Id_Abogado )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA SECRETARIAS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Secretarias (
    Id_Secretaria NUMBER(8),
    Id_Abg        NUMBER(8),
    Ci_Secre      VARCHAR2(10),
    Horario       VARCHAR2(50),
    Foto          BLOB,
    CONSTRAINT Fk_Pers_Secre FOREIGN KEY ( Ci_Secre )
        REFERENCES Buf_Persona ( Ci ),
    CONSTRAINT Fk_Abg_Secre FOREIGN KEY ( Id_Abg )
        REFERENCES Buf_Abogados ( Id_Abogado ),
    PRIMARY KEY ( Id_Secretaria )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA USUARIOS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Usuarios (
    Id_Abg     NUMBER(8),
    Ci_User    VARCHAR2(10),
    Usuario    VARCHAR2(20),
    Contraseña VARCHAR2(15),
    CONSTRAINT Fk_Pers_User FOREIGN KEY ( Ci_User )
        REFERENCES Buf_Persona ( Ci ),
    CONSTRAINT Fk_Abg_User FOREIGN KEY ( Id_Abg )
        REFERENCES Buf_Abogados ( Id_Abogado ),
    PRIMARY KEY ( Ci_User )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CLIENTES
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Clientes (
    Id_Cliente NUMBER(8),
    Ci         VARCHAR2(10),
    Id_Abg     NUMBER(8),
    Ocupacion  VARCHAR2(50),
    CONSTRAINT Fk_Pers_Clientes FOREIGN KEY ( Ci )
        REFERENCES Buf_Persona ( Ci ),
    CONSTRAINT Fk_Abg_Clientes FOREIGN KEY ( Id_Abg )
        REFERENCES Buf_Abogados ( Id_Abogado ),
    PRIMARY KEY ( Id_Cliente )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso (
    Id_Caso NUMBER(5),
    Cedula  VARCHAR2(10),
    Caso    VARCHAR2(30),
    CONSTRAINT Fk_Pers_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Persona ( Ci ),
    PRIMARY KEY ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CITAS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Citas (
    Id_Cita     NUMBER(5),
    Ci          VARCHAR2(10),
    Num_Celular VARCHAR2(10),
    Descripcion VARCHAR2(50),
    Nom_Caso    VARCHAR2(30),
    Id_Caso     NUMBER(5),
    Hora        VARCHAR2(20),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Ci )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Num_Celular )
        REFERENCES Buf_Cliente ( Num_Celular ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso ),
    PRIMARY KEY ( Id_Cita )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CONSULTAS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Consultas (
    Id_Consulta NUMBER(5),
    Nombre      VARCHAR2(20),
    Apellido    VARCHAR2(20),
    Descripcion VARCHAR2(50),
    Caso        VARCHAR2(20),
    Hora        VARCHAR2(20),
    PRIMARY KEY ( Id_Consulta )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_DIVORCIO
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Divorcio (
    Id_Caso     NUMBER(5),
    Cedula      VARCHAR2(10),
    Req_1       BLOB,
    Req_2       BLOB,
    Req_3       BLOB,
    Req_4       BLOB,
    Req_5       BLOB,
    Req_6       BLOB,
    Honorarios  DECIMAL,
    Observacion VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_PENSION ALIMENTICIA
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Pension_Aliment (
    Id_Caso     NUMBER(5),
    Cedula      VARCHAR2(10),
    Req_1       BLOB,
    Req_2       BLOB,
    Req_3       BLOB,
    Req_4       BLOB,
    Req_5       BLOB,
    Req_6       BLOB,
    Honorarios  DECIMAL,
    Observacion VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_PETICION_FAMILIAR
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Peticion_Familiar (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Req_6             BLOB,
    Req_7             BLOB,
    Req_8             BLOB,
    Req_9             BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_PERDON
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Perdon (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Req_6             BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_VISA_EEUU
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Visa_Eeuu (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Req_6             BLOB,
    Req_7             BLOB,
    Req_8             BLOB,
    Req_9             BLOB,
    Req_10            BLOB,
    Req_11            BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_VISA_EUROPA
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Visa_Europa (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Req_6             BLOB,
    Req_7             BLOB,
    Req_8             BLOB,
    Req_9             BLOB,
    Req_10            BLOB,
    Req_11            BLOB,
    Req_12            BLOB,
    Req_13            BLOB,
    Req_14            BLOB,
    Req_15            BLOB,
    Req_16            BLOB,
    Req_17            BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_VISA_LOTERIA
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Visa_Loteria (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Req_6             BLOB,
    Req_7             BLOB,
    Req_8             BLOB,
    Req_9             BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_VISA_MEXICO
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Visa_Mexico (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_RENOVACION_PASAPORTE
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Renovacion_Pasaporte (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Req_6             BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_RETORNANTE_INMIGRANTE
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Retornante_Inmigrante (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Req_6             BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CASO_REPORTE_CONSULAR
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Caso_Reporte_Consular (
    Id_Caso           NUMBER(5),
    Cedula            VARCHAR2(10),
    Req_1             BLOB,
    Req_2             BLOB,
    Req_3             BLOB,
    Req_4             BLOB,
    Req_5             BLOB,
    Req_6             BLOB,
    Req_7             BLOB,
    Req_8             BLOB,
    Honorarios        DECIMAL,
    Num_Beneficiarios NUMBER(10),
    Observacion       VARCHAR2(50),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA PAGOS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Pagos (
    Id_Pago    NUMBER(7) NOT NULL,
    Id_Caso    NUMBER(5) NOT NULL,
    Cedula     VARCHAR2(10) NOT NULL,
    Fecha_Pago DATE NOT NULL,
    Abono      DECIMAL NOT NULL,
    Saldo      DECIMAL NOT NULL,
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Cliente ( Ci ),
    CONSTRAINT Fk_Cita_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso ),
    PRIMARY KEY ( Id_Pago )
);