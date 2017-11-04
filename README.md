# PruebaBackEnd

Para la ejecución de la prueba es necesario ejecutar las siguientes líneas de código en la terminal

En una instancia de terminal
`cd  front-end-suma-matriz`
`npm install`
`bower install`
`grunt serve`

En otra instanciade terminal
`cd  back-end-suma-matriz`
`java -jar target/back-end-suma-matriz-0.0.1-SNAPSHOT.jar server back-end-suma-matriz-local.yml`

Ya puede la aplicación desde el navegador.

Lo podría haber hecho todo desde el front. Sin embargo tratandose de una prueba back end cree un microservicio web con arquitectura REST para la comunicación con el front end.

## Explicación del diseño

### Front-end
Aplicación de Angular en donde diferencié correctamete la definición de la aplicación `app.js`. La lógica de controlador(encargada del comportamiento de los datos de la vista) `main.js` y el servicio que maneja la conexión con el back end `ProcedureManagementService.js`.

### Back-end
Es un microservicio hecho con el framework Dropwizard. En ella creé una clase esclusiva que expone los servicios: `MatrixResource.java`. Una Clase para la lógica de negocio `MatrixBusiness.java`.

Para este caso no vi necesario usar una base de datos.

# Code Refactoring

Malas pŕacticas encontradas:

* Hay código conmentado que no hace ninguna funcionalidad.
* No hay docmuentación de que hace cada función.
* No se manejan constantes. Por ejemplo los códigos de error.
* Los nombres de las variables no están correctamente nombradas, estas deberían representar más el contexto.
* El código maneja más de un idioma.
* Es una única funcion con toda la lógica. Se debería separar las funcionalidades en diferentes métodos.
* Las notificaciones no están centralizadas (no hay reuso ni estandarización de los mensajes).

### Preguntas

* El principio de responsabilidad única hace referencia a que los metodos o fuciones deben hacer una única cosa. Esto sirve para el reuso del código y la mantenibilidad.
* Un código que cumpla los estandares propuestos por SonarQuebe. Yo soy muy estricto con las buenas pŕacticas con el código. La principal característica es que el código lo pueda leer cualquier otro programador y que sea mantenible.  
