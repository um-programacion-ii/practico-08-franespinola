# API de Gestión de Bibliotecas

## API de Libros

Esta API permite gestionar libros y autores.

**Endpoints:**

### Libros

| Método | Endpoint | Descripción | Ejemplo de solicitud | Ejemplo de respuesta |
|---|---|---|---|---|
| **GET** | `/libros` | Buscar todos los libros | `curl http://localhost:8080/libros` | `[{"id": 1, "titulo": "El Hobbit", "isbn": "978-0-618-05328-5", "autor": {"id": 1, "nombre": "J.R.R. Tolkien", "nacionalidad": "Británico"}}, ...]` |
| **GET** | `/libros/{id}` | Buscar un libro por ID | `curl http://localhost:8080/libros/1` | `{"id": 1, "titulo": "El Hobbit", "isbn": "978-0-618-05328-5", "autor": {"id": 1, "nombre": "J.R.R. Tolkien", "nacionalidad": "Británico"}}` |
| **GET** | `/libros/titulo-derived/{titulo}` | Buscar libros por título usando una consulta derivada | `curl http://localhost:8080/libros/titulo-derived/El%20Hobbit` | `[{"id": 1, "titulo": "El Hobbit", "isbn": "978-0-618-05328-5", "autor": {"id": 1, "nombre": "J.R.R. Tolkien", "nacionalidad": "Británico"}}]` |
| **GET** | `/libros/titulo-JPQL/{titulo}` | Buscar libros por título usando JPQL | `curl http://localhost:8080/libros/titulo-JPQL/El%20Hobbit` | `[{"id": 1, "titulo": "El Hobbit", "isbn": "978-0-618-05328-5", "autor": {"id": 1, "nombre": "J.R.R. Tolkien", "nacionalidad": "Británico"}}]` |
| **POST** | `/libros` | Agregar un nuevo libro | `curl -X POST -H "Content-Type: application/json" -d '{"titulo":"señor de los aniños", "isbn":"335656", "autor":{"id": 10, "nombre": "benja", "nacionalidad": "portugeggs"}}' http://localhost:8080/libros` | `{"id": 2, "titulo": "señor de los aniños", "isbn": "335656", "autor": {"id": 10, "nombre": "benja", "nacionalidad": "portugeggs"}}` |
| **DELETE** | `/libros/{id}` | Eliminar un libro por ID | `curl -X DELETE http://localhost:8080/libros/1` | `204 No Content` |
| **PUT** | `/libros/{id}` | Actualizar un libro por ID | `curl -X PUT -H "Content-Type: application/json" -d '{"titulo":"fffffffff", "isbn":"titulo99"}' http://localhost:8080/libros/1` | `{"id": 1, "titulo": "fffffffff", "isbn": "titulo99", "autor": {"id": 1, "nombre": "J.R.R. Tolkien", "nacionalidad": "Británico"}}` |



**Nota:**

* Los ejemplos de respuesta muestran una estructura genérica. La información específica dependerá de los datos almacenados en la base de datos.
* Recuerda reemplazar `{id}`, `{titulo}` con los valores correspondientes.
* Asegúrate de tener la API en ejecución en `http://localhost:8080` antes de ejecutar los comandos curl.