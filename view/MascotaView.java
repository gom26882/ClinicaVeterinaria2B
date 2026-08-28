package view;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class MascotaView {

    public String pedirNombre() {
        return JOptionPane.showInputDialog("Ingrese el nombre de la mascota...");
    }

    public LocalDate pedirEdad() {
        return LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento de la mascota (YYYY-MM-DD)..."));
    }
      

    public String pedirTipoEspecie(){
        String[] especies ={
            "PERRO",
            "GATO",
            "HURON",
            "CONEJO",
            "HAMSTER",
            "SERPIENTE"
        };

        String especieSeleccionada = (String) JOptionPane.showInputDialog(
            null,
            "Selecciona la especie:",
            "Tipo de especie",
            JOptionPane.QUESTION_MESSAGE,
            null,
            especies,
            especies[0]
        );

        return especieSeleccionada;
    }

    public int pedirIdMascota() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mascota:"));
    }

    public double pedirPesoControl() {
        return Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso en kg:"));
    }

    public int pedirNumeroControl(){
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de control"));
    }

    public int mostrarMenu() {
        while (true) {
            String entrada = JOptionPane.showInputDialog(
                "<html>" +
                "<h2>CONTROL DE PESO</h2>" +
                "1. Agregar mascota<br>" +
                "2. Nuevo control de peso<br>" +
                "3. Historial de pesos<br>" +
                "4. Consultar un control<br>" +
                "5. Actualizar un control<br>" +
                "6. Promedio<br>" +
                "7. Peso mayor y menor<br>" +
                "8. Controles disponibles<br>" +
                "9. Salir<br><br>" +
                "Seleccione una opción:" +
                "</html>"
            );

            try {
                int opcion = Integer.parseInt(entrada);
                return opcion;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"El menú solo acepta números");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }  
}