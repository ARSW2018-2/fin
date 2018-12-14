### Escuela Colombiana de Ingeniería

### Arquitecturas de Software

Recuperacion Examen final


Se realizo un API rest donde se pueden consultar peliculas accediendo a una api de peliculas "omdbapi.com", con una llave suministrada por ellos realizamos las consultas de cualquier peliculas. 

Y el API rest nos mostrara informacion acerca de la pelicula, año, descripcion de la pelicula e imagen de la misma.

Si se desea conectar a la API deben poner la URL  y el nomrbre de la pelicula deseada y esta le regresara en formato JSON toda la info de la pelicula.


El cliente web al pasar los parametros (nombre de la pelicula y/o año), manda una peticion por axios a la aplicacion en java, que recibe eso, genera una url con la api y la informacion suministrada y pide a omdbapi la informacion requerida, despues de esto obtiene en formato JSON la informaicon y la regresa al cliente wb y se puede visualizar por pantalla.



Cesar Eduardo Lanos Camacho
