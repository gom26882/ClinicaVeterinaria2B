# ClinicaVeterinaria2B

# Análisis

### 1. ¿Qué propiedades y métodos tendrá cada clase?

La clase `Mascota` tendrá las propiedade:
    `nombre`, 
    `tipoEspecie`, 
    `edad`,
    `peso[]`.

Los métodos de la clase son: 
    `addPeso()`, 
    `getPesoBy()`, 
    `updatePeso()`, 
    `calcularPromedio()`, 
    `getPesoMayor()`, 
    `getPesoMenor()`, 
    `getCantidadControles()`, 
    `getControlesDisponibles()`
getters/setters de atributos

### 2. ¿Qué tipo deben tener las propiedades y métodos de cada clase?

- `nombre`: `String`
- `tipoEspecie`: `tipoEspecie`
- `edad`: `int`
- `peso[]`: `double[]`


### 3. ¿Cuál de las propiedades identificadas debe implementarse utilizando un arreglo? ¿Qué tipo de datos almacenará?

el arreglo `control[]` sera de tipo `double` con 10 espacios, guardará el pso en kilogramos durante los controles realizados para la mascota.


```java
private double[] control = new double[10];
```

### 4. ¿Cuáles deben ser los modificadores de visibilidad de los miembros en cada clase?

atributos `private`
métodos `public`


### 5. ¿Qué parámetros serán requeridos por los métodos en sus clases?

- `addPeso(double peso)`
    - `peso`
- `getPesoBy(int numeroControl)`
    -`numeroControl`
- `updatePeso(int numeroControl, double nuevoPeso)`
    -`numeroControl, nuevoPeso`
- `Mascota(String nombre, tipoEspecie especie, int edad)`
    -`nombre, tipoEspecie, edad`

los métodos restantes no usaran parámetros 

### 6. ¿Cómo proveerá de valores iniciales a sus objetos? ¿Qué valores iniciales les asignará?

Los datos iniciales de la mascota se tendrán por medio del constructor. Esos datos se habrán pedido previamente utilizando `scanner`. El peso tendrá una capacidad de 10 posiciones, se iniciará sin controles registrados


### 7. ¿Cómo determinará cuál es la siguiente posición disponible dentro del arreglo?

El control de peso se inciará desde `0`, se recorrerá el arreglo con un ciclo para encontrar la siguiente posición, seguido se realizará una validación que validará que la siguiente posición este vacía


### 8. ¿Cómo recorrerá únicamente las posiciones del arreglo que contienen controles de peso registrados

Se recorrerá el cada posición del arreglo utilizando un foreach y una validación que solo permita avanzar si la posición en el arreglo es diferente a null, si la validación se da (si existe algo almacenado), pasará a la siguietne posición hasta encontrar una posición sin valor en la que pueda guardar un nuevo control de peso.
