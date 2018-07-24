
create procedure registrarAsiento
@numasiento int,
@tipo nvarchar(50)
AS
BEGIN
insert into Asiento values (@numasiento,@tipo);
END
GO
create procedure registrarRuta
@descripcion nvarchar(50)
AS
BEGIN
insert into Ruta values (@descripcion);
END
GO
create procedure registrarBus
@placa int,
@asiento int,
@ruta int
AS
BEGIN
insert into Bus values (@placa,@asiento,@ruta);
END
GO
create procedure registrarSucursal
@nombre nvarchar(50),
@lugar nvarchar(50)
AS
BEGIN
insert into Sucursal values (@nombre,@lugar);
END
GO
create procedure registrarPasajero
@nombre nvarchar(50),
@apellido nvarchar(50),
@nroDoc int
AS
BEGIN
insert into Pasajero values (@nombre,@apellido,@nroDoc);
END
GO
create procedure registrarChofer
@nombre nvarchar(50),
@apellido nvarchar(50),
@dni int,
@celular int,
@bus int
AS
BEGIN
END

GO


