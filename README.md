# 🎯 **Desafío: Implementación de Arquitectura Hexagonal y Patrón Factory en Java**  

📌 **Descripción**  
Este proyecto implementa una aplicación en Java utilizando la **Arquitectura Hexagonal** (Puertos y Adaptadores) para gestionar clientes y productos. La arquitectura garantiza la separación de preocupaciones, facilitando el mantenimiento, la escalabilidad y la independencia de la infraestructura. Además, se utiliza el patrón **Abstract Factory** para gestionar conexiones a bases de datos.

🛠️ **Tareas**  

1. Implementar la Arquitectura Hexagonal para separar la lógica de negocio de la infraestructura.  
2. Utilizar el patrón Abstract Factory para gestionar conexiones a bases de datos.  
3. Crear entidades, repositorios y casos de uso para gestionar clientes y productos.  
4. Implementar un menú CRUD interactivo para clientes y productos.  
5. Configurar la conexión a la base de datos mediante un archivo `config.properties`.  

🚀 Estructura del Proyecto

📂 Clases Principales

🔧 Dominio (Core)

Client 🧑‍💼: Entidad que representa a un cliente.

Product 📦: Entidad que representa a un producto.

ClientRepository 📄: Interfaz para acceder a los datos de clientes.

ProductRepository 📄: Interfaz para acceder a los datos de productos.

🛠️ Caso de Uso

ClientUseCase 🧑‍💻: Implementa la lógica de negocio para gestionar clientes.

ProductUseCase 🧑‍💻: Implementa la lógica de negocio para gestionar productos.

🖥️ Infraestructura

ClientRepositoryImpl 🗄️: Implementación concreta del repositorio de clientes.

ProductRepositoryImpl 🗄️: Implementación concreta del repositorio de productos.

ConnMySql 🔌: Clase para gestionar conexiones a MySQL.

ConnectionFactory 🏭: Clase para gestionar conexiones a bases de datos (patrón Abstract Factory).

📋 Menú

ClientMenu 📝: Menú interactivo para gestionar clientes.

ProductMenu 📝: Menú interactivo para gestionar productos.

⚙️ Configuración

HexaSingleton 🔄: Clase de configuración para inicializar componentes.

config.properties ⚙️: Archivo de configuración para la conexión a la base de datos.

🚪 Main

Main 🏁: Punto de inicio de la aplicación.

🎨 Diagrama Visual de la Estructura

```plaintext
📦 miapp
┣ 📂 src/main/java
┃ ┣ 📂 com.miapp
┃ ┃ ┣ 📂 application/usecase
┃ ┃ ┃ ┣ 📄 ClientUseCase.java
┃ ┃ ┃ ┗ 📄 ProductUseCase.java
┃ ┃ ┣ 📂 domain
┃ ┃ ┃ ┣ 📂 entity
┃ ┃ ┃ ┃ ┣ 📄 Client.java
┃ ┃ ┃ ┃ ┗ 📄 Product.java
┃ ┃ ┃ ┗ 📂 repository
┃ ┃ ┃   ┣ 📄 ClientRepository.java
┃ ┃ ┃   ┗ 📄 ProductRepository.java
┃ ┃ ┣ 📂 infrastructure
┃ ┃ ┃ ┣ 📂 database
┃ ┃ ┃ ┃ ┣ 📄 ConnMySql.java
┃ ┃ ┃ ┃ ┗ 📄 ConnectionFactory.java
┃ ┃ ┃ ┗ 📂 persistence
┃ ┃ ┃   ┣ 📄 ClientRepositoryImpl.java
┃ ┃ ┃   ┗ 📄 ProductRepositoryImpl.java
┃ ┃ ┣ 📂 menu
┃ ┃ ┃ ┣ 📄 ClientMenu.java
┃ ┃ ┃ ┗ 📄 ProductMenu.java
┃ ┃ ┗ 📄 Main.java
┃ ┗ 📂 resources
┃   ┗ 📄 config.properties
┗ 📄 README.md
```

🚀 **Instalación y Configuración**  
📋 **Requisitos Previos**  

- Java Development Kit (JDK) 17 o superior.  
- Maven instalado para la gestión de dependencias.  
- MySQL o cualquier otra base de datos compatible.  

📥 **Clonar Repositorio**  

```bash
git clone https://github.com/Jhormancastella/miapp.git
```

🛠️ **Compilar y Ejecutar**  

1. Abre una terminal en la carpeta del proyecto.  

2. Compila el proyecto con Maven:  

   ```bash
   mvn clean install
   ```  

3. Ejecuta la aplicación:  

   ```bash
   java -cp target/miapp.jar com.miapp.Main
   ```  

**Si no tienes Maven instalado:**

> **⚠️ Importante:**  
> Para que la aplicación funcione correctamente, debes asegurarte de tener las herramientas y dependencias necesarias instaladas. A continuación, se detallan los requisitos y pasos a seguir:  
>
> **Notas adicionales:**  
>
> - Si encuentras errores durante la compilación, verifica que todas las dependencias estén correctamente configuradas en el archivo `pom.xml`.  
> - Si no tienes Maven instalado, puedes compilar manualmente con `javac` (ver sección 3 de la guía anterior).  
> - Asegúrate de que el archivo JAR (`miapp.jar`) se haya generado correctamente en la carpeta `target`.  
>
## **Ejecutar en Visual Studio Code:**  
>
> Si prefieres trabajar en **Visual Studio Code**, sigue estos pasos:  
>
> 1. Abre la carpeta del proyecto en VS Code.  
> 2. Asegúrate de tener instaladas las extensiones necesarias:  
>    - **Extension Pack for Java** (para soporte de Java).  
>    - **Maven for Java** (para integración con Maven).  
> 3. Abre la terminal integrada en VS Code (`Ctrl +` ñ `) y ejecuta el main:  
> **¡Listo!** La aplicación debería estar en funcionamiento. Si encuentras algún problema, no dudes en revisar la documentación o contactar al equipo de soporte. 😊

🛠️ **Uso**

- La aplicación permite gestionar clientes y productos mediante operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
- Se puede cambiar la base de datos modificando el archivo `config.properties` sin alterar la lógica de negocio.  

> **⚠️ Importante:**  
> Para que la aplicación funcione correctamente, la base de datos debe tener la estructura adecuada. Asegúrate de que existan las siguientes tablas:  
>
> - **Tabla `Client`:**  
>   - `id` (clave primaria)  
>   - `name` (nombre del cliente)  
>   - `email` (correo electrónico del cliente)  
> - **Tabla `Product`:**  
>   - `id` (clave primaria)  
>   - `name` (nombre del producto)  
>   - `stock` (cantidad en stock)  
> Si las tablas no están configuradas correctamente, la aplicación no funcionará como se espera.

📋 **Ejemplo de Ejecución**  

```plaintext
==============================
        Menú Principal        
==============================
1. Gestionar Clientes
2. Gestionar Productos
3. Listar Clientes
4. Listar Productos
0. Salir
Ingrese su opción: 1

---- Gestión de Clientes ----
1. Registrar Cliente
2. Actualizar Cliente
3. Eliminar Cliente
0. Volver al Menú Principal
Ingrese su opción: 1

Ingrese el nombre del cliente: Juan Pérez
Ingrese el email del cliente: juan@example.com
Cliente registrado correctamente.

---- Gestión de Clientes ----
1. Registrar Cliente
2. Actualizar Cliente
3. Eliminar Cliente
0. Volver al Menú Principal
Ingrese su opción: 0

==============================
        Menú Principal        
==============================
1. Gestionar Clientes
2. Gestionar Productos
3. Listar Clientes
4. Listar Productos
0. Salir
Ingrese su opción: 2

---- Gestión de Productos ----
1. Registrar Producto
2. Actualizar Producto
3. Eliminar Producto
0. Volver al Menú Principal
Ingrese su opción: 1

Ingrese el nombre del producto: Laptop
Ingrese el stock del producto: 10
Producto registrado correctamente.

---- Gestión de Productos ----
1. Registrar Producto
2. Actualizar Producto
3. Eliminar Producto
0. Volver al Menú Principal
Ingrese su opción: 0

==============================
        Menú Principal        
==============================
1. Gestionar Clientes
2. Gestionar Productos
3. Listar Clientes
4. Listar Productos
0. Salir
Ingrese su opción: 3

--- Listado de Clientes ---
ID: 1, Nombre: Juan Pérez, Email: juan@example.com

==============================
        Menú Principal        
==============================
1. Gestionar Clientes
2. Gestionar Productos
3. Listar Clientes
4. Listar Productos
0. Salir
Ingrese su opción: 4

--- Listado de Productos ---
ID: 1, Nombre: Laptop, Stock: 10

==============================
        Menú Principal        
==============================
1. Gestionar Clientes
2. Gestionar Productos
3. Listar Clientes
4. Listar Productos
0. Salir
Ingrese su opción: 0
Saliendo del programa...
```  

📋 **Características**  

- Implementación de la Arquitectura Hexagonal para separar la lógica de negocio de la infraestructura.
- Uso del patrón Abstract Factory para gestionar conexiones a bases de datos.  
- Configuración centralizada mediante `config.properties`.  
- Menús interactivos para gestionar clientes y productos.  
- Fácil mantenimiento y escalabilidad gracias a la modularidad.  

🚨 **Estado del Ejercicio**  
Culminado.  

👤 **Autor**  
Jhorman Jesús Castellanos Morales  
