# CinemaCentro — Entrega 1

Guía rápida para compilar y probar la primera entrega del TP.

Requisitos
- Java JDK 8+
- NetBeans 8.2 (recomendado) o Ant en terminal
- MariaDB (o MySQL compatible)
- MariaDB JDBC driver (`mariadb-java-client.jar`) añadido a las librerías del proyecto

Pasos para configurar la BD
1. Desde terminal, importar el script SQL del proyecto:

```bash
cd /Users/franco/NetBeansProjects/PROYECTOFINAL
# si tu mysql/mariadb usa root y sin password
mysql -u root < cinemacentro.sql
# o con password
mysql -u root -p < cinemacentro.sql
```

2. Verificar que exista la base `cinemacentro` y la tabla `comprador`:

```bash
mysql -u root -p -e "USE cinemacentro; SHOW TABLES;"
```

Configurar el proyecto en NetBeans
- Abrir NetBeans y abrir el proyecto `CinemaCentro`.
- Agregar el JAR del driver MariaDB a las librerías del proyecto (Project Properties -> Libraries -> Add JAR/Folder).

Compilar y ejecutar demo
- Desde NetBeans: Clean and Build. Ejecutar la clase `Vistas.Test` como aplicación Java.
- Desde terminal (si tienes `ant`):

```bash
cd /Users/franco/NetBeansProjects/PROYECTOFINAL/CinemaCentro
ant clean
ant compile
# ejecutar desde NetBeans o con un target run si está configurado
```

Qué implementé para la entrega 1
- CRUD completo para `Comprador` en `src/Persistencia/CompradorData.java`:
  - `guardarComprador` (hashea la contraseña y guarda)
  - `buscarCompradorPorDni`
  - `listarCompradores`
  - `actualizarComprador` (si se pasa contraseña no nula se rehashea y actualiza)
  - `eliminarComprador`
- `Modelo/PasswordUtils.java`: utilitario PBKDF2 para hashear y verificar contraseñas.
- `Vistas/Test.java`: demo `main` que crea, guarda, busca, lista, actualiza y borra un comprador.

Checklist antes de entregar
- [ ] Importar `cinemacentro.sql` en tu MariaDB local.
- [ ] Añadir `mariadb-java-client.jar` a las librerías del proyecto.
- [ ] Ejecutar `Vistas.Test` desde NetBeans y verificar la salida en la consola.
- [ ] Revisar el contenido de la tabla `comprador` con `SELECT * FROM comprador;` si quieres comprobar los hashes.

Notas
- Las contraseñas se guardan con PBKDF2 (salt + hash) en la columna `password`. En las salidas por consola no mostramos contraseñas en texto plano.
- Si no quieres que la demo elimine los datos, edita `Vistas/Test.java` para comentar la llamada a `eliminarComprador`.

Si querés, puedo:
- Implementar DAOs para `Proyeccion` y `TicketCompra`.
- Añadir tests JUnit.
- Externalizar la configuración de BD a `config.properties`.

*** Fin README ***
