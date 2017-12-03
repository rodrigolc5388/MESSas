# Práctica Fundamentos Android
## V KeepCoding Mobile Development Bootcamp

### Sinopsis
- Aplicación creada para un restaurante.  
- Permite: llevar un control de los pedidos de cada una de las mesas, peticiones especiales para cada orden y el total de las consumisiones de una mesa.

-

### Ramas
#### Master
- La apliación corre y funciona 100% sobre activities en esta rama.

#### Fragments
- La aplicación corre y funciona 100% sobre fragments en esta rama.  
- La comunicación entre cada fragment y su activity se ha implementado utilizando siempre una interface.
- El objetivo de crear un fragment para cada activity era implementar también una versión para tablets; actualmente esta versión no está implementada.

-

### Pantallas
#### TablesActivity 
- Muestra un listado de las mesas del restaurante.
- Al seleccionar una mesa, se lanza la siguiente actividad.

#### TableActivity
- Muestra el detalle de la mesa.
- Contiene un botón, en la parte inferior derecha de la pantalla, desde el cual se puede agregar un plato a la lista de pedidos de la mesa.
- La ActionBar contiene en la parte derecha un botón que:
	- Se actualiza y muestra la suma total de los pedidos de la mesa.
	- Al pulsaro, despliega un AlertDialog mediante el cual se puede dar la cuenta por pagada y se limpia el listado de pedidos de la mesa.

#### PlatesActivity
- Muestra, mediante un RecyclerView, un listado de los platos disponibles (5 en total).
- Al seleccionar uno de los platos, se navega hacia una vista detalle del mismo.
- La ActionBar contiene un botón que permite volver a la vista detalle de la mesa sin necesidad de agregar ningún plato.

#### PlateDetailActivity
- Muestra una vista detalle del plato seleccionado en la activity anterior.
- Contiene:
	- Imagen del plato.
	- Listado de alérgenos; se indica la presencia de cada uno de ellos mediante su ícono. Si éste está en color, quiere decir que el alérgeno está presente en el plato; si está en gris, no.
	- Un EditText dentro del cual se podrán introducir peticiones especiales para el plato: agregar/quitar ingrediente, punto de la carne, etc.
	- Un botón que:
		- Agrega el plato a la mesa.
		- Indica el precio del plato.
- La ActionBar también contiene un botón para volver al listado de platos.




