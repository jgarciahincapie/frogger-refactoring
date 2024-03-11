# Proyecto frogger

## Contexto
Frogger es clásico de los videojuegos, que sigue siendo popular y del que pueden encontrarse muchas versiones en Internet.​ conta de una rana que quiere llegar al final de un camino con obstáculos.

### Malas practicas identificadas

-**Clase Excesivamente Larga:** La clase `ChampSelection` tiene una gran cantidad de métodos y lógica relacionada con múltiples modos de juego. Esto puede dificultar el mantenimiento y la comprensión del código a medida que crece.

-**Código Duplicado:** Hay repeticiones de código en los métodos `mode1()`, `mode2()`, `mode3()` y `mode4()`. La lógica para agregar los botones de juego y cambiar de jugador es casi idéntica en cada uno de estos métodos.

-**Violación del Principio de Responsabilidad Única:** La clase `ChampSelection` parece tener múltiples responsabilidades, incluida la creación de la interfaz de usuario y la lógica para cambiar de jugador y comenzar el juego. Esto puede hacer que la clase sea difícil de entender y modificar.

-**Métodos Largos**: Los métodos `mode1()`, `mode2()`, `mode3()` y `mode4()` contienen una cantidad significativa de código, lo que dificulta la comprensión y el mantenimiento.

-**Acoplamiento Fuerte**: La clase `ChampSelection` está altamente acoplada a `GameGUI` y `Assets`, lo que puede hacer que sea difícil de probar y modificar.

-**Manejo de Excepciones**: En lugar de simplemente mostrar un mensaje y salir del programa en caso de error al cargar las imágenes, podríamos manejar las excepciones de manera más elegante, por ejemplo, registrándolas o permitiendo que el programa continúe funcionando con imágenes predeterminadas.

-**Uso de Recursos Relativos**: Sería beneficioso utilizar rutas de archivo relativas en lugar de rutas de archivo absolutas para que el programa sea más portable y no dependa de la estructura de directorios del sistema de archivos.

-**No hay ningún tipo de pruebas:** el código no tiene pruebas de ningún tipo.


### Técnicas de Refactoring:

- **Dividir la Clase:** Separar la lógica de la interfaz de usuario de la lógica de negocio puede ayudar a mejorar la legibilidad y la modularidad del código.

- **Eliminar Código Duplicado:** Extraer la lógica común a métodos separados puede reducir la duplicación y hacer que el código sea más fácil de mantener.

- **Reducir la Complejidad de los Métodos:** Dividir los métodos largos en métodos más pequeños y específicos puede mejorar la comprensión del código.

- **Reducir el Acoplamiento:** Utilizar la inyección de dependencias y el patrón de diseño Observer para reducir el acoplamiento entre las clases.