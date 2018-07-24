-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-07-24 14:52:58.145

-- tables
-- Table: Asiento

CREATE DATABASE TransFlorencio;
USE TransFlorencio ;

CREATE TABLE Asiento (
    idAsiento int  NOT NULL IDENTITY(1, 1),
    numAsiento int  NOT NULL,
    tipoAsiento varchar(50)  NOT NULL,
    CONSTRAINT Asiento_pk PRIMARY KEY  (idAsiento)
);

-- Table: BoletoDeViaje
CREATE TABLE BoletoDeViaje (
    idBoleto int  NOT NULL IDENTITY(1, 1),
    Empresa_idEmpresa int  NOT NULL,
    Chofer_idChofer int  NOT NULL,
    Pasajero_idPasajero int  NOT NULL,
    fechaViaje datetime  NOT NULL,
    totalPagar int  NOT NULL,
    CONSTRAINT BoletoDeViaje_pk PRIMARY KEY  (idBoleto)
);

-- Table: Bus
CREATE TABLE Bus (
    idBus int  NOT NULL IDENTITY(1, 1),
    placa int  NOT NULL,
    Asiento_idAsiento int  NOT NULL,
    Ruta_idRuta int  NOT NULL,
    CONSTRAINT Bus_pk PRIMARY KEY  (idBus)
);

-- Table: Chofer
CREATE TABLE Chofer (
    idChofer int  NOT NULL IDENTITY(1, 1),
    nombre varchar(50)  NOT NULL,
    apellido varchar(50)  NOT NULL,
    dni int  NOT NULL,
    celular int  NOT NULL,
    Bus_idBus int  NOT NULL,
    CONSTRAINT Chofer_pk PRIMARY KEY  (idChofer)
);

-- Table: Empresa
CREATE TABLE Empresa (
    idEmpresa int  NOT NULL IDENTITY(1, 1),
    nombre varchar(50)  NOT NULL,
    razonSocial varchar(50)  NOT NULL,
    direccion varchar(50)  NOT NULL,
    teléfono int  NOT NULL,
    celular int  NOT NULL,
    email varchar(50)  NOT NULL,
    ruc int  NOT NULL,
    Sucursal_idSucursal int  NOT NULL,
    CONSTRAINT Empresa_pk PRIMARY KEY  (idEmpresa)
);

-- Table: Pasajero
CREATE TABLE Pasajero (
    idPasajero int  NOT NULL IDENTITY(1, 1),
    nombre varchar(50)  NOT NULL,
    apellido varchar(50)  NOT NULL,
    nroDocumento int  NOT NULL,
    CONSTRAINT Pasajero_pk PRIMARY KEY  (idPasajero)
);

-- Table: Ruta
CREATE TABLE Ruta (
    idRuta int  NOT NULL IDENTITY(1, 1),
    descripcion varchar(50)  NOT NULL,
    CONSTRAINT Ruta_pk PRIMARY KEY  (idRuta)
);

-- Table: Sucursal
CREATE TABLE Sucursal (
    idSucursal int  NOT NULL IDENTITY(1, 1),
    nombre varchar(50)  NOT NULL,
    lugar varchar(50)  NOT NULL,
    CONSTRAINT Sucursal_pk PRIMARY KEY  (idSucursal)
);

-- foreign keys
-- Reference: BoletoDeViaje_Chofer (table: BoletoDeViaje)
ALTER TABLE BoletoDeViaje ADD CONSTRAINT BoletoDeViaje_Chofer
    FOREIGN KEY (Chofer_idChofer)
    REFERENCES Chofer (idChofer);

-- Reference: BoletoDeViaje_Empresa (table: BoletoDeViaje)
ALTER TABLE BoletoDeViaje ADD CONSTRAINT BoletoDeViaje_Empresa
    FOREIGN KEY (Empresa_idEmpresa)
    REFERENCES Empresa (idEmpresa);

-- Reference: BoletoDeViaje_Pasajero (table: BoletoDeViaje)
ALTER TABLE BoletoDeViaje ADD CONSTRAINT BoletoDeViaje_Pasajero
    FOREIGN KEY (Pasajero_idPasajero)
    REFERENCES Pasajero (idPasajero);

-- Reference: Bus_Asiento (table: Bus)
ALTER TABLE Bus ADD CONSTRAINT Bus_Asiento
    FOREIGN KEY (Asiento_idAsiento)
    REFERENCES Asiento (idAsiento);

-- Reference: Bus_Ruta (table: Bus)
ALTER TABLE Bus ADD CONSTRAINT Bus_Ruta
    FOREIGN KEY (Ruta_idRuta)
    REFERENCES Ruta (idRuta);

-- Reference: Chofer_Bus (table: Chofer)
ALTER TABLE Chofer ADD CONSTRAINT Chofer_Bus
    FOREIGN KEY (Bus_idBus)
    REFERENCES Bus (idBus);

-- Reference: Empresa_Sucursal (table: Empresa)
ALTER TABLE Empresa ADD CONSTRAINT Empresa_Sucursal
    FOREIGN KEY (Sucursal_idSucursal)
    REFERENCES Sucursal (idSucursal);

-- End of file.

