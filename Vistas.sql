create view ListarRuta
AS
select * from Ruta
GO
create view ListarAsiento
AS
select * from Asiento
GO
create view ListarPasajero
AS
select * from Pasajero
GO
create view ListarSucursal
AS
select * from Sucursal
GO
create view ListarEmpresa
AS
select  idEmpresa,razonSocial,direccion,teléfono,celular,email,ruc,Sucursal.lugar as Sucursal from Empresa
inner join Sucursal on Sucursal.idSucursal = Empresa.Sucursal_idSucursal
GO
create view Listarchofer
AS
select idChofer,nombre,apellido,dni,celular,Bus.placa as Bus from  chofer
inner join Bus on Bus.idBus = Chofer.Bus_idBus
GO


create view ListarBoleta
AS
select idBoleto,Empresa.nombre as Nombre,Empresa.razonSocial as razon Social, 
concat (Chofer.nombre,','chofer.apellido)as Chofer,concat( Pasajero.nombre,','Pasajero.apellido) 
as Pasajero,fechaViaje,Asiento.tipoAsiento as 'Tipo de asiento' from BoletoDeViaje
inner join Empresa on Empresa.idEmpresa = BoletoDeViaje.Empresa_idEmpresa 
inner join Empresa on Empresa.idEmpresa = BoletoDeViaje.Empresa_idEmpresa 
GO
