# prog2.2024.practico08


# Libros y Autores  
Crear una aplicación básica de gestión de bibliotecas. La aplicación debe manejar dos entidades principales: Libro y Autor, y demostrar el uso de JPA/ORM/Hibernate, la creación de repositorios, controladores, servicios y consultas avanzadas.

### . Descripción de entidad y repository
**Tarea**:
- Definir la entidad `Libro` con los atributos `id`, `titulo`, `isbn` y una relación con la entidad `Autor`.
- Definir la entidad `Autor` con los atributos `id`, `nombre`, `nacionalidad` y una relación con la entidad `Libro`.
- Crear interfaces de repositorio para `Libro` y `Autor` que extiendan `JpaRepository`.

### . Definir consultas con `derivedQuery` y JPQL
**Tarea**:
- Crear un método en el repositorio de `Libro` que busque libros por título usando derived queries.
- Crear una consulta JPQL personalizada en el repositorio de `Libro` para buscar libros por título.

### . CRUD con controlador y servicio
**Tarea**:
- Crear servicios para `Libro` y `Autor` que proporcionen métodos para crear, leer, actualizar y eliminar registros.
- Crear controladores REST para `Libro` y `Autor` que expongan endpoints CRUD.

### . Consultas con Criteria y Specification
**Tarea**:
- Crear una clase Specification para `Libro` que permita filtrar libros por título.
- Modificar el servicio de `Libro` para incluir un método que use Specification para realizar consultas dinámicas.

### . Relaciones entre tablas `@OneToOne` y `@OneToMany`
**Tarea**:
- Definir una relación `@OneToMany` entre `Autor` y `Libro`.
- Definir una relación `@ManyToOne` entre `Libro` y `Autor`.
- Asegurarse de que las entidades y las relaciones estén correctamente mapeadas en la base de datos.
- Construir un endpoint que me permita consultar un `Autor` y la respuesta incluya todos los `Libro` del mismo autor.
- La respuesta de la consulta de un `Libro` debe incluir el `Autor` relacionado

### . Inicialización
**Tarea**:
- Generar datos mínimos suficientes para demostrar la funcionalidad solicitada.

### . Ampliar README.md
**Tarea**:
- Extender el archivo README con la especificación de cada endpoint y un `curl` que demuestre el uso y un ejemplo del resultado obtenido

