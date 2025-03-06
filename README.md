
# 🎯 **Desafío: Implementación de Arquitectura Hexagonal y Patrón Abstract Factory en Java**  

📌 **Descripción**  
El objetivo de este proyecto es implementar una aplicación en Java utilizando la Arquitectura Hexagonal (también conocida como "Puertos y Adaptadores") junto con el patrón de diseño Abstract Factory. La aplicación gestiona clientes, permitiendo operaciones como la creación, consulta y persistencia de datos. La arquitectura garantiza la separación de preocupaciones, facilitando el mantenimiento, la escalabilidad y la independencia de la infraestructura.

🛠️ **Tareas**  

1. Implementar la Arquitectura Hexagonal para separar la lógica de negocio de la infraestructura.  
2. Utilizar el patrón Abstract Factory para gestionar diferentes tipos de conexiones a bases de datos.  
3. Crear las entidades, repositorios y casos de uso necesarios para gestionar clientes.  
4. Configurar la conexión a la base de datos mediante un archivo `config.properties`.  
5. Implementar pruebas unitarias para garantizar el correcto funcionamiento de la aplicación.  

🚀 **Estructura del Proyecto**  


📂 **Clases Principales**  

- **Dominio (Core):**  

  - `Client`: Entidad que representa a un cliente.  
  - `ClientRepository`: Interfaz que define los métodos para acceder a los datos de los clientes.  
- **Caso de Uso:**  
  - `ClientUseCase`: Implementa la lógica de negocio para gestionar clientes.  
- **Infraestructura:**  
  - `ClientRepositoryImpl`: Implementación concreta del repositorio para acceder a la base de datos.  
  - `ConnMySql`, `ConnectionDb`, `ConnectionFactory`: Clases para gestionar conexiones a bases de datos utilizando el patrón Abstract Factory.  
- **Configuración:**  
  - `HexaSingleton`: Clase de configuración para inicializar componentes.  
  - `config.properties`: Archivo de configuración para la conexión a la base de datos.  
- **Main:**  
  - `Main`: Punto de entrada de la aplicación.  

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

🛠️ **Uso**  

- La aplicación permite gestionar clientes mediante operaciones CRUD (Crear, Leer, Actualizar, Eliminar).  
- Se puede cambiar la base de datos modificando el archivo `config.properties` sin alterar la lógica de negocio.  

📋 **Ejemplo de Ejecución**  

```plaintext
1. Crear cliente:  
   Nombre: Juan Pérez  
   Email: juan@example.com  
   Cliente creado correctamente.  

2. Consultar cliente:  
   ID: 1  
   Nombre: Juan Pérez  
   Email: juan@example.com  
```  

📋 **Características**  

- Implementación de la Arquitectura Hexagonal para separar la lógica de negocio de la infraestructura.  
- Uso del patrón Abstract Factory para gestionar conexiones a bases de datos.  
- Configuración centralizada mediante `config.properties`.  
- Fácil mantenimiento y escalabilidad gracias a la modularidad.  

🚨 **Estado del Ejercicio**  
Culminado.  

👤 **Autor**  
Jhorman Jesús Castellanos Morales  
