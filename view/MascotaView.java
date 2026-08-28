package view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MascotaView {

    public String pedirNombre() {

        while (true) {

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota..." );

            if (nombre == null) {
                return null;
            }

            if (!nombre.trim().isEmpty() && !nombre.matches("\\d+")) {
                return nombre;
            }

            JOptionPane.showMessageDialog(null,"Ingrese un nombre válido" );
        }
    }


    public LocalDate pedirEdad() {

        while (true) {

            String entrada = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento de la mascota (YYYY-MM-DD)...");

            if (entrada == null) {
                return null;
            }

            try {
                return LocalDate.parse(entrada);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Fecha inválida.\nUse el formato YYYY-MM-DD"
                );
            }
        }
    }


    public String pedirTipoEspecie() {

        String[] especies = {
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

        while (true) {

            String entrada = JOptionPane.showInputDialog("Ingrese el ID de la mascota:");

            try {
                int id = Integer.parseInt(entrada);

                if (id > 0) {
                    return id;
                }

                JOptionPane.showMessageDialog(null, "El ID debe ser mayor que 0" );

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog( null, "Ingrese un ID válido" );
            }
        }
    }


    public double pedirPesoControl() {

        while (true) {

            String entrada = JOptionPane.showInputDialog("Ingrese el peso en kg:");

            try {

                double peso = Double.parseDouble(entrada);

                if (peso > 0) {
                    return peso;
                }

                JOptionPane.showMessageDialog(   null, "El peso debe ser mayor que 0" );

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(  null, "Ingrese un peso válido");
            }
        }
    }


    public int pedirNumeroControl() {

        while (true) {

            String entrada = JOptionPane.showInputDialog("Ingrese el número de control:"  );

            try {

                int numeroControl = Integer.parseInt(entrada);

                if (numeroControl > 0) {
                    return numeroControl;
                }

                JOptionPane.showMessageDialog(null, "El número de control debe ser mayor que 0" );

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Ingrese un número de control válido" );
            }
        }
    }


    public int mostrarMenu() {

        UIManager.put("OptionPane.cancelButtonText", "Salir");
        UIManager.put("OptionPane.okButtonText", "Aceptar");

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

            if (entrada == null) {
                return 9;
            }

            try {

                int opcion = Integer.parseInt(entrada);

                if (opcion >= 1 && opcion <= 9) {
                    return opcion;
                }

                JOptionPane.showMessageDialog(null,"Ingrese una opción entre 1 y 9");

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null,"El menú solo acepta números");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje);
    }
}