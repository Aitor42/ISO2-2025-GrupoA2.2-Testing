# ISO2-2025-GrupoA2.2-Testing

## Command Line 
Este componente se distribuye como una librería Java (`.jar`).

## Características
* **Lectura Tipada:** Conversión automática a `Integer`, `Double` y `LocalDate`.
* **Control de Errores:** Captura excepciones de formato y solicita el dato nuevamente.
* **Modularidad:** Funciona como una librería externa (`.jar`) desacoplada de la lógica de negocio.

---
### Instalación 
- Opción A: Uso manual (Sin gestor de dependencias)
1. Descarga el archivo `CommandLine.jar` de la sección de *Releases*.
2. Añade el `.jar` al **Classpath** de tu proyecto.
   * En línea de comandos:
     ```bash
     javac -cp lib/CommandLine.jar MiApp.java
     java -cp .:lib/CommandLine.jar MiApp
     ```
   * En IDE (IntelliJ/Eclipse): Añadir a "Libraries" o "Build Path".

- Opción B: Maven (Si se publica en repositorio)
Si el componente estuviera alojado en un repositorio Maven local o remoto, añade la dependencia en tu `pom.xml`:

```xml
<dependency>
    <groupId>com.tu-organizacion</groupId>
    <artifactId>CommandLine</artifactId>
    <version>1.0.0</version>
</dependency>
```
---
### USO
### 1. Importaciones Necesarias
Para utilizar el componente en tu aplicación, debes importar las siguientes clases del `.jar`:

```java
// Servicio principal
import service.InputService;

// Parsers necesarios

// Excepción controlada
import exception.InputException;
```

### 2. Parser Disponibles
| Clase | Tipo | Constructor | Uso |
| :--- | :--- | :--- | :--- |
| IntegerParser | Integer | `new IntegerParser()` | Enteros |
| DoubleParser | Double | `new DoubleParser()` | Decimales |
| DateParser | Date | `new DateParser()` | Fechas (ej: "dd/MM/yyyy") |

### 3. Ejemplo de uso

Métodos principales: 
- readString(prompt:String), obtiene un string además de imprimir por pantalla.
- readWithParser(prompt:String, parser:Parser, maxRetries:integer)
- close()

```java
public class MainApp {
    public static void main(String[] args) {
        InputService input = new InputService();

        try {
            System.out.println("--- Formulario de Registro ---");

            // 1. Leer String simple
            String nombre = input.readString("Nombre: ");

            // 2. Leer Entero (con 3 intentos de corrección)
            int edad = input.readWithParser(
                "Edad: ", 
                new IntegerParser(), 
                3
            );

            // 3. Leer Fecha con formato personalizado
            var fechaNacimiento = input.readWithParser(
                "Fecha (dd/MM/yyyy): ", 
                new DateParser("dd/MM/yyyy"), 
                3
            );

            System.out.println("Registro completado: " + nombre);

        } catch (InputException e) {
            System.err.println("Error crítico en la entrada: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}
```
