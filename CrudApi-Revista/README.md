# Web Revista

## Vista

El cuerpo de la vista para el usuario, se compone de tres secciones, un slider de fotos al inicio, la seccion de numero actual y otro slider para la seccion de numeros anteriores

![vista-revista](https://i.ibb.co/26wCs5S/revista-1.png)

dentro de la seccion de numeros anteriores si se selecciona alguna revista, se modifican los datos en la seccion de numero actual

![vista-revista](https://i.ibb.co/P1NhJsH/revista-2.png)

En la parte del indice y el boton de ver pdf, se accede al documento de la revista

## Administrador

![admin-principal](https://i.ibb.co/P9Y63xz/admin-principal-min.png)

El administrador cuenta con un panel para leer, crear, editar y eliminar registros, segun sea la opcion seleccionada en la interfaz 

![panel-administrador](https://i.ibb.co/dJG63sK/admin-panel-min.png)

## Api

Los datos son crados y consumidos atraves de un API REST

![api](https://i.ibb.co/wwGjm6D/api-min.png)
<center>

### URIS

URL | Descripcion | Actor
:----: | :----: | :----:
```http://localhost/backend-revista/``` | Vista para el usuario | Usuario
```http://localhost/backend-revista/admin``` | Vista para el panel de administrador | Administrador

API

URL | Metodo | Descripcion 
:---- | :----: | :----:
```http://localhost/backend-revista/api/institutos``` | POST | agrega un instituto
```http://localhost/backend-revista/api/institutos``` | GET | obtiene todos los institutos
```http://localhost/backend-revista/api/institutos/ver/${id}``` | GET | obtiene un instituto por id
```http://localhost/backend-revista/api/institutos/actualizar/${id}``` | PUT | actualiza un instituto por id
```http://localhost/backend-revista/api/institutos/eliminar/${id}``` | DELETE | elimina un instituto por id
```http://localhost/backend-revista/api/comites``` | POST | agrega un comite
```http://localhost/backend-revista/api/comites``` | GET | obtiene todos los comites
```http://localhost/backend-revista/api/comites/ver/${id}``` | GET | obtiene un comite por id
```http://localhost/backend-revista/api/comites/actualizar/${id}``` | PUT | actualiza un comite por id
```http://localhost/backend-revista/api/comites/eliminar/${id}``` | DELETE | elimina un comite por id
```http://localhost/backend-revista/api/autores``` | POST | agrega un autor
```http://localhost/backend-revista/api/autores``` | GET | obtiene todos los autores
```http://localhost/backend-revista/api/autores/ver/${id}``` | GET | obtiene un autor por id
```http://localhost/backend-revista/api/autores/actualizar/${id}``` | PUT | actualiza un autor por id
```http://localhost/backend-revista/api/autores/eliminar/${id}``` | DELETE | elimina un autor por id
```http://localhost/backend-revista/api/indices``` | POST | agrega un indice
```http://localhost/backend-revista/api/indices``` | GET | obtiene todos los indices
```http://localhost/backend-revista/api/indices/ver/${id}``` | GET | obtiene un indice por id
```http://localhost/backend-revista/api/indices/actualizar/${id}``` | PUT | actualiza un indice por id
```http://localhost/backend-revista/api/indices/eliminar/${id}``` | DELETE | elimina un indice por id
```http://localhost/backend-revista/api/paginas``` | POST | agrega una pagina
```http://localhost/backend-revista/api/paginas``` | GET | obtiene todos las paginas
```http://localhost/backend-revista/api/paginas/ver/${id}``` | GET | obtiene una pagina por id
```http://localhost/backend-revista/api/paginas/actualizar/${id}``` | PUT | actualiza una pagina por id
```http://localhost/backend-revista/api/paginas/eliminar/${id}``` | DELETE | elimina una pagina por id
```http://localhost/backend-revista/api/revistas``` | POST | agrega una revista
```http://localhost/backend-revista/api/revistas``` | GET | obtiene todos las revistas
```http://localhost/backend-revista/api/revistas/ver/${id}``` | GET | obtiene una revista por id
```http://localhost/backend-revista/api/revistas/actualizar/${id}``` | PUT | actualiza una revista por id
```http://localhost/backend-revista/api/revistas/eliminar/${id}``` | DELETE | elimina una revista por id
```http://localhost/backend-revista/api/revistas-autores``` | POST | agrega una revista-autor
```http://localhost/backend-revista/api/revistas-autores``` | GET | obtiene todas las revistas-autores
```http://localhost/backend-revista/api/revistas-autores/ver/${idAutor}/${idRevista}``` | GET | obtiene una revista-autor por id
```http://localhost/backend-revista/api/revistas-autores/actualizar/${idAutor}/${idRevista}``` | PUT | actualiza una revista-autor por id
```http://localhost/backend-revista/api/revistas-autores/eliminar/${idAutor}/${idRevista}``` | DELETE | elimina una revista-autor por id
```http://localhost/backend-revista/api/revistas-arbitros``` | POST | agrega una revista-arbitro
```http://localhost/backend-revista/api/revistas-arbitros``` | GET | obtiene todas las revistas-arbitros
```http://localhost/backend-revista/api/revistas-arbitros/ver/${idArbitro}/${idRevista}``` | GET | obtiene una revista-arbitro por id
```http://localhost/backend-revista/api/revistas-arbitros/actualizar/${idArbitro}/${idRevista}``` | PUT | actualiza una revista-arbitro por id
```http://localhost/backend-revista/api/revistas-arbitros/eliminar/${idArbitro}/${idRevista}``` | DELETE | elimina una revista-arbitro por id
</center>