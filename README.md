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

Ya podría usar desde el navegador la aplicación.

Lo podría haber hecho todo desde el front. Sin embargo tratandose de una prueba back end cree un microservicio web con arquitectura REST para la comunicación con el front end.

## Explicación del diseño

### Front-end
Cree una aplicación de Angular en donde diferencié correctamete la definición de la aplicación `app.js`. La lógica de controlador(encargada del comportamiento de los datos de la vista) `main.js` y el servicio que maneja la conexión con el back end `ProcedureManagementService.js`.
