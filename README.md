
# Miniproyecto_1

## Descripción

Este proyecto es una simulación básica de un sistema militar en el que se pueden gestionar diferentes rangos de soldados, asignarles misiones y reportar su estado. Los soldados se dividen en distintos rangos (`Soldado Raso`, `Teniente`, `Capitán`, `Coronel`) y cada uno cuenta con diferentes características y acciones específicas.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
Miniproyecto_1/src
├── App.java                    # Clase principal que ejecuta el programa
└── militar
    ├── operaciones
    │   └── OperacionesMilitares.java   # Interfaz para operaciones básicas militares
    ├── rangos
    │   └── Rango.java                 # Clase abstracta que representa el rango de un soldado
    └── soldados
        ├── Capitan.java               # Clase que representa un Capitán
        ├── Coronel.java               # Clase que representa un Coronel
        ├── SoldadoRaso.java           # Clase que representa un Soldado Raso
        ├── Teniente.java              # Clase que representa un Teniente
        └── soldado.java               # Clase base para representar a cualquier soldado
```

## Clases Principales

### 1. App.java

La clase principal del proyecto. Crea instancias de diferentes tipos de soldados (`Soldado Raso`, `Teniente`, `Capitán`, `Coronel`), les asigna misiones y reporta el estado de cada uno usando polimorfismo y downcasting.

- **Método `main`**: Inicializa los objetos de soldados y les asigna misiones.
- **Método `reportarEstadoSoldado`**: Muestra el estado de cada soldado y utiliza downcasting para invocar métodos específicos según el tipo de soldado.

### 2. OperacionesMilitares.java (Interfaz)

Define métodos generales que cada soldado puede implementar:
- **asignarMision**: Asigna una misión al soldado.
- **reportarEstado**: Reporta el estado actual del soldado.

### 3. Rango.java (Clase Abstracta)

Clase abstracta que hereda de `soldado` y representa los rangos de los soldados. Define:
- **Método abstracto `realizarAccion`**: Método que cada rango sobreescribe para realizar acciones específicas.
- **prepararseParaMision**: Método común que se puede sobrescribir en las subclases para realizar preparativos antes de una misión.

### 4. Clases de Soldados (SoldadoRaso, Teniente, Capitan, Coronel)

Cada clase representa un rango específico y extiende `Rango`, implementando también `OperacionesMilitares`.

- **SoldadoRaso**: Tiene el nivel más bajo y se limita a seguir órdenes.
- **Teniente**: Encargado de supervisar una unidad. Tiene acceso a un atributo `unidad`.
- **Capitan**: Coordina misiones con un equipo de soldados a su mando.
- **Coronel**: Responsable de implementar estrategias de alto nivel.

Cada clase implementa los métodos de `OperacionesMilitares` y sobreescribe `realizarAccion` y `reportarEstado` para personalizar el comportamiento según el rango.

### 5. soldado.java

Clase base que contiene información básica de un soldado:
- **nombre**: Nombre del soldado.
- **id**: Identificador único.
- **rango**: Rango del soldado, que puede ser sobrescrito.
- **contadorSoldados**: Lleva un conteo de los soldados creados.

Incluye el método `mostrarInformacion` para mostrar la información básica del soldado.

## Ejecución del Proyecto

1. **Compilación**:
   - Asegúrate de que tu entorno de desarrollo esté configurado para compilar y ejecutar Java.
   - Navega hasta el directorio `src` y compila el proyecto ejecutando:
     ```bash
     javac App.java
     ```

2. **Ejecución**:
   - Una vez compilado, ejecuta el programa con:
     ```bash
     java App
     ```

El programa mostrará la asignación de misiones para cada soldado y el estado de cada uno en la consola.

## Funcionalidades Principales

- **Polimorfismo y Downcasting**: La clase `App` demuestra el uso de polimorfismo al llamar a métodos en objetos de tipo `Rango`, que luego son "downcasteados" a sus tipos específicos (`Capitan`, `Teniente`, etc.) para acceder a métodos y atributos específicos.
- **Interfaz de Operaciones Militares**: Define métodos comunes para los soldados, estandarizando la asignación de misiones y el reporte de estado.
- **Herencia y Abstracción**: `Rango` es una clase abstracta que otras clases específicas de soldados extienden, implementando comportamiento personalizado en función de su rango.

## Posibles Mejoras

- **Añadir otros rangos** como `General` para ampliar la jerarquía.
- **Integrar manejo de excepciones** para situaciones de errores en la asignación de misiones o en la creación de soldados.
- **Persistencia de Datos**: Implementar almacenamiento de datos para guardar las misiones asignadas y el estado de los soldados en una base de datos o archivo.

## Autores

 1.  Andrés Felipe Castrillón Martínez
    
2.  Bryan Steven Panesso avila
    
3.  Natalia Martínez Castañeda
