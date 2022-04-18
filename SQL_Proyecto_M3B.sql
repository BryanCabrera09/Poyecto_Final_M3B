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

SELECT * FROM Buf_Admin_User;

SELECT P.Ci, P.Nombre, P.Apellido, A.horario FROM Buf_Persona P JOIN Buf_Abogados A ON P.Ci = A.ci_Abg;

SELECT
    * FROM Buf_Citas;
    
    
SELECT
    * FROM Buf_Consultas;

SELECT P.Ci, P.Nombre, P.Apellido, P.Correo, P.Num_Celular, P.direccion, S.id_Abg, P.Fecha_Nacimiento, S.foto FROM Buf_Persona P JOIN Buf_Secretarias S ON P.Ci = S.ci_Secre;
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

DROP TABLE Buf_Usuarios;

DROP TABLE Buf_Clientes;

DROP TABLE Buf_Secretarias;

DROP TABLE Buf_Abogados;

DROP TABLE Buf_Persona;

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
TABLA USUARIOS DE ABOGADOS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Usuarios (
    Id_User    NUMBER(8),
    Ci_User    VARCHAR2(10),
    Usuario    VARCHAR2(20),
    Contraseña VARCHAR2(15),
    CONSTRAINT Fk_Pers_User FOREIGN KEY ( Ci_User )
        REFERENCES Buf_Persona ( Ci ),
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
    PRIMARY KEY ( Ci )
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
    CONSTRAINT Fk_Caso_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    PRIMARY KEY ( Id_Caso )
);


/*
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
TABLA CITAS
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
CREATE TABLE Buf_Citas (
    Id_Cita     NUMBER(6),
    Ci          VARCHAR2(10),
    Id_Caso     NUMBER(5),
    Nom_Caso    VARCHAR2(30),
    Num_Celular VARCHAR2(10),
    Descripcion VARCHAR2(50),
    Hora        VARCHAR2(70),
    CONSTRAINT Fk_Cita_Cliente FOREIGN KEY ( Ci )
        REFERENCES Buf_Clientes ( Ci ),
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
    Id_Consulta NUMBER(6),
    Nombre      VARCHAR2(20),
    Apellido    VARCHAR2(20),
    Celular     VARCHAR2(10),
    Descripcion VARCHAR2(80),
    Caso        VARCHAR2(30),
    Hora        VARCHAR2(70),
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
    CONSTRAINT Fk_Req_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Req_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Pension_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Alimenticia_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Peticion_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Familiar_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Perdon_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Perdon_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Vis_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Eeuu_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Visa_Client FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Europa_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Visa_Clientes FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Loteria_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Visa_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Mexico_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Renovacion_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Pasaporte_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Retornante_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Inmigrante_Caso FOREIGN KEY ( Id_Caso )
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
    CONSTRAINT Fk_Reporte_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Consular_Caso FOREIGN KEY ( Id_Caso )
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
    Fecha_Pago VARCHAR2(20) NOT NULL,
    Abono      DECIMAL,
    Saldo      DECIMAL,
    CONSTRAINT Fk_Pago_Cliente FOREIGN KEY ( Cedula )
        REFERENCES Buf_Clientes ( Ci ),
    CONSTRAINT Fk_Pago_Caso FOREIGN KEY ( Id_Caso )
        REFERENCES Buf_Caso ( Id_Caso ),
    PRIMARY KEY ( Id_Pago )
);