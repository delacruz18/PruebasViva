#Carlos De la cruz 21/10/2021
@tag
Feature: realizar Compra de vuelo bajo modalidad Solo ida.

	Debe ingresar al portar
	Seleccionar un tipo de vuelo “One Way”
	Seleccionar el origen y destino
	Seleccionar la fecha de salida
	Debe seleccionar el vuelo más economico. Si todos los vuelos tienen el mismo precio, seleccione el primero.
	En la siguiente pagina dar click en “Detalles del vuelo” y validar que aparezca la información del vuelo seleccionado.


  @tag2
Scenario: Compra de vuelo
	Given open browser page Avianca 
	And search Flight from and destination 
	And select Fligh
  Then show the flight information 
	
