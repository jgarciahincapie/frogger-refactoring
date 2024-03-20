
# Frogger test Debt

El proyecto Frogger, desarrollado como parte del curso de Programación Orientada a Objetos (POOB) del sexto semestre, busca recrear el clásico videojuego lanzado en 1981 por Sega/Gremlin y desarrollado por Konami. En esta versión, los jugadores asumen el papel de una rana que debe cruzar varias casillas en la parte superior de la pantalla, evitando ser atropellada, ahogada o devorada
### Prácticas de Testing Debt presentes en el proyecto:

### 1. **Falta de pruebas unitarias:**
- En ausencia de pruebas unitarias, el equipo de desarrollo puede enfrentarse a desafíos significativos al intentar identificar y solucionar problemas. Además, sin pruebas unitarias, los desarrolladores pueden sentirse menos seguros al realizar cambios en el código existente, lo que puede llevar a una menor velocidad de desarrollo y mayores posibilidades de introducir errores.

#### Razones para implementar pruebas unitarias:
- **Mejora la calidad del código:** Las pruebas unitarias actúan como una red de seguridad al detectar errores tempranos en el ciclo de desarrollo, lo que conduce a un código más robusto y menos propenso a errores.
- **Facilita el mantenimiento del código:** Con pruebas unitarias en su lugar, los desarrolladores pueden realizar cambios en el código con confianza, sabiendo que las pruebas les alertarán si algo se rompe.
- **Acelera el desarrollo:** A largo plazo, el tiempo invertido en escribir pruebas unitarias se traduce en un ciclo de desarrollo más rápido y menos tiempo dedicado a la depuración de errores.

### 2. **Cobertura insuficiente:**
- Actualmente, no existen suficientes pruebas para cubrir todas las funcionalidades del software, existe la posibilidad de que se introduzcan cambios que afecten áreas no probadas, lo que puede causar fallas en producción.

#### Razones para mejorar la cobertura de pruebas:
- **Reduce el riesgo de fallos inesperados:** Una cobertura de pruebas completa garantiza que todas las funcionalidades críticas sean probadas, lo que disminuye la posibilidad de que se produzcan errores en producción.
- **Aumenta la confianza en el código:** Una mayor cobertura de pruebas proporciona una mayor certeza de que el software funciona como se espera en una variedad de escenarios, lo que aumenta la confianza del equipo de desarrollo y los usuarios finales.
- **Facilita la detección de regresiones:** Con una cobertura de pruebas adecuada, es más fácil detectar si un cambio en el código causa un efecto no deseado en una funcionalidad existente.

### Ejemplo:
En el código proporcionado, no hay pruebas unitarias para la clase `ChampSelection`, lo que puede llevar a un aumento en la Testing Debt. Una posible solución sería implementar pruebas unitarias utilizando un framework como JUnit. Estas pruebas podrían cubrir diferentes escenarios de selección de personajes, verificando que la interfaz gráfica se actualice correctamente y que los eventos del mouse funcionen según lo esperado.
este seria un ejemplo de implementacion 
```import org.junit.Test;
import static org.junit.Assert.*;

public class ChampSelectionTest {

    @Test
    public void testChampSelectionInstance() {
        ChampSelection champSelection = new ChampSelection(new JFrame(), 1);
        assertNotNull(champSelection);
    }

    @Test
    public void testPlayerSelectionMode1() {
        JFrame frame = new JFrame();
        ChampSelection champSelection = new ChampSelection(frame, 1);
        champSelection.mode1();
        assertEquals(2, champSelection.getComponentCount());
        assertEquals(1, champSelection.getMode());
        assertEquals(0, champSelection.getSelectP1());
    }

    @Test
    public void testPlayerSelectionMode2() {
        JFrame frame = new JFrame();
        ChampSelection champSelection = new ChampSelection(frame, 2);
        champSelection.mode2();
        assertEquals(2, champSelection.getComponentCount());
        assertEquals(2, champSelection.getMode());
        assertEquals(0, champSelection.getSelectP1());
        assertEquals(0, champSelection.getSelectP2());
    }

    @Test
    public void testPlayButtonVisibility() {
        JFrame frame = new JFrame();
        ChampSelection champSelection = new ChampSelection(frame, 1);
        champSelection.mode1();
        Component[] components = champSelection.getComponents();
        JLabel playButton = null;
        for (Component component : components) {
            if (component instanceof JLabel) {
                if (((JLabel) component).getIcon() != null) {
                    playButton = (JLabel) component;
                    break;
                }
            }
        }
        assertNotNull(playButton);
        assertTrue(playButton.isVisible());
    }

    @Test
    public void testChangePlayerButtonFunctionality() {
        JFrame frame = new JFrame();
        ChampSelection champSelection = new ChampSelection(frame, 1);
        champSelection.mode1();
        int initialSelection = champSelection.getSelectP1();
        JButton changePlayerButton = (JButton) champSelection.getComponents()[1];
        changePlayerButton.doClick();
        assertEquals((initialSelection + 1) % 3, champSelection.getSelectP1());
    }

    @Test
    public void testModeSwitching() {
        JFrame frame = new JFrame();
        ChampSelection champSelection = new ChampSelection(frame, 1);
        champSelection.setMode(3);
        champSelection.mode3();
        assertEquals(3, champSelection.getMode());
        assertEquals(2, champSelection.getComponentCount());
    }
}
```
#### Razones para Implementar la Solución:
- **Mejora la robustez del código:** Las pruebas unitarias identificarán rápidamente cualquier cambio que rompa la funcionalidad existente en `ChampSelection`.
- **Facilita el mantenimiento:** Con pruebas unitarias, futuras modificaciones en el código pueden realizarse con mayor confianza, ya que cualquier cambio no deseado se detectará durante la ejecución de las pruebas.
- **Aumenta laconfianza del equipo:** Al tener pruebas unitarias sólidas en su lugar, el equipo de desarrollo gana confianza en la estabilidad y calidad del código. Esto puede mejorar la colaboración dentro del equipo y fomentar un entorno de desarrollo más positivo y productivo.

### Ideas para mejorar 
- **Implementación de pruebas unitarias**: Desarrollar pruebas unitarias para validar el funcionamiento de las unidades individuales de código.
- **Establecimiento de revisiones pares en los escenarios de prueba**: Introducir revisiones de código entre compañeros para evaluar y mejorar la calidad de los escenarios de prueba.
- **Mejora de la infraestructura para la ejecución de pruebas**: Actualizar y optimizar la infraestructura de pruebas para garantizar una ejecución eficiente y confiable de las pruebas.
- **Adopción de estándares de codificación**: Establecer y hacer cumplir estándares de codificación para mejorar la calidad y la consistencia del código.
- **Fomento de la evolución continua de las pruebas**: Mantener y actualizar regularmente las pruebas para reflejar los cambios en el código y los requisitos del negocio.