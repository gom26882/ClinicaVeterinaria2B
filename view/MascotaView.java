package view;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class MascotaView {

    public String pedirNombre(){
        return JOptionPane.showInputDialog("Ingrese el nombre de la mascota...");
    }

    public LocalDate PedirEdad(){
        return LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento de la mascota (YYYY-MM-DD)..."));
    }

    public String pedirTipoEspecie(){
        return JOptionPane.showInputDialog( "Ingrese la especie:\n" +
            "PERRO\n" +
            "GATO\n" +
            "HURON\n" +
            "CONEJO\n" +
            "HAMSTER\n" +
            "SERPIENTE");
    }

    public int mostrarMenu(){
        while (true) {
            String entrada = JOptionPane.showInputDialog(
                "CONTROL DE PESO\n\n" +
                "1. Agregar mascota\n" +
                "2. Nuevo control de peso\n" +
                "3. Historial de pesos\n" +
                "4. Consultar un control\n" +
                "5. Actualizar un control\n" +
                "6. Promedio\n" +
                "7. Peso mayor y menor\n" +
                "8. Controles disponibles\n" +
                "9. Salir\n\n" +
                "Seleccione una opción:"
            );

            try {
                int opcion = Integer.parseInt(entrada);
                return opcion;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"El menú solo acepta números");
            }

        }
    }



    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }  
}
