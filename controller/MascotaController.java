package controller;

import model.Mascota;
import java.util.ArrayList;
import java.time.LocalDate;
import constants.TipoEspecie;
import view.MascotaView;

public class MascotaController {

    private ArrayList<Mascota> listaMascotas;
    private MascotaView view;

    public MascotaController(MascotaView view) {
        this.view = view;
        listaMascotas = new ArrayList<>();
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = view.mostrarMenu();
            switch(opcion) {
                case 1:
                    agregarMascota();
                    break;
                case 2:
                    agregarControl(); 
                    break;
                case 3:
                    historialPesos(); 
                    break;
                case 4:
                    consultarControl();
                    break;
                case 5:
                    actualizarControl();
                    break;
                case 6:
                    promedioPesos();
                    break;
                case 7:
                    pesoMayorMenor();
                    break;
                case 8:
                    controlesDisponibles(); 
                    break;
                case 9:
                    view.mostrarMensaje("Saliendo... adiooos :)");
                    break;
                default:
                    view.mostrarMensaje("Por favor use una opción válida");
                    break;
            }
        } while (opcion != 9);
    }

    private void agregarMascota() {
        String nombre = view.pedirNombre();
        LocalDate edad = view.pedirEdad();
        TipoEspecie especie = TipoEspecie.valueOf(view.pedirTipoEspecie().toUpperCase());

        Mascota mascota = new Mascota(nombre, edad, especie);
        listaMascotas.add(mascota);

        view.mostrarMensaje("Mascota agregada correctamente. ID: " + mascota.getId());
    }


    private void agregarControl() {
        if (listaMascotas.isEmpty()) {
            view.mostrarMensaje("Debe registrar una mascota primero.");
            return;
        }

        Mascota mascota = buscarMascota(view.pedirIdMascota());
        if (mascota == null) {
            view.mostrarMensaje("Mascota no encontrada.");
            return;
        }

        double peso = view.pedirPesoControl();
        
        if (peso <= 0) {
            view.mostrarMensaje("Error: El peso debe ser mayor a 0.");
            return;
        }

        boolean agregado = mascota.setControl(peso);
        
        if (agregado) {
            view.mostrarMensaje("Control registrado con éxito.");
        } else {
            view.mostrarMensaje("Error: No hay espacio disponible. Se alcanzó el límite de 10 controles."); // Valida espacio disponible[cite: 2]
        }
    }

    private void historialPesos() {
        if (listaMascotas.isEmpty()) return;

        Mascota mascota = buscarMascota(view.pedirIdMascota());
        if (mascota == null) return;

        int registrados = mascota.getCantidadControles();
        if (registrados == 0) {
            view.mostrarMensaje("No hay controles registrados para esta mascota.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(" HISTORIAL DE PESOS:\n").append(mascota.getNombre());
        
        double[] controles = mascota.getControl();
        
        for (int i = 0; i < registrados; i++) {
            sb.append("Control #").append(i + 1).append(": ").append(controles[i]).append(" kg\n");
        }
        
        view.mostrarMensaje(sb.toString());
    }

    private void controlesDisponibles() {
        if (listaMascotas.isEmpty()) return;

        Mascota mascota = buscarMascota(view.pedirIdMascota());
        if (mascota == null) return;

        int realizados = mascota.getCantidadControles();
        int permitidos = mascota.getControl().length;
        int disponibles = permitidos - realizados;

        String mensaje = "ESTADO DE CONTROLES - " + mascota.getNombre() + "\n\n" +
                         "Controles realizados: " + realizados + "\n" +
                         "Controles disponibles: " + disponibles + " de " + permitidos;
                         
        view.mostrarMensaje(mensaje);
    }

    public Mascota buscarMascota(int id) {
        for (Mascota mascota : listaMascotas) {
            if (mascota.getId() == id) {
                return mascota;
            }
        }
        return null;
    }

    private void consultarControl(){
        if(listaMascotas.isEmpty()){
            view.mostrarMensaje("Debe registrar una mascota de primero");
            return;
        }

        Mascota mascota = buscarMascota(view.pedirIdMascota());

        if (mascota == null){
            view.mostrarMensaje("No se encontró la mascota");
            return;
        }

        int numeroControl = view.pedirNumeroControl();
        double peso = mascota.getPesoBy(numeroControl);

        if ( peso == -1){
            view.mostrarMensaje("El control ingresado no existe");
            return;
        }

        view.mostrarMensaje(
            "Control #" + numeroControl + "\nPeso: " + peso + " kg"
        );
    }

    private void actualizarControl(){
        if(listaMascotas.isEmpty()){
            view.mostrarMensaje("Debe registrar una mascota de primero");
            return;
        }

        Mascota mascota = buscarMascota(view.pedirIdMascota());

        if( mascota == null){
            view.mostrarMensaje("No se encontró la mascota");
            return;
        }

        int numeroControl = view.pedirNumeroControl();
        double nuevoPeso = view.pedirNumeroControl();

        boolean pesoActualizado = mascota.updatePeso(numeroControl, nuevoPeso);

        if(pesoActualizado == true ){
            view.mostrarMensaje(
            "Control #" + numeroControl +
                " actualizado correctamente.\n" +
                "Nuevo peso: " + nuevoPeso + " kg"
            );
        } else{
            view.mostrarMensaje("No es posible actualizar el control \n" +
                "Porfavor verifique el número de control y el peso"
            );   
        }
    }

    private void promedioPesos(){
        if(listaMascotas.isEmpty()){
            view.mostrarMensaje("Debe registrar una mascota de primero");
            return;
        }

        Mascota mascota = buscarMascota(view.pedirIdMascota());

        if( mascota == null){
            view.mostrarMensaje("No se encontró la mascota");
            return;
        }

        double promedioPesos = mascota.calcularPromedio();

        if(promedioPesos == -1 ){
            view.mostrarMensaje("La mascota no tiene controles");
            return;
        } else {
            view.mostrarMensaje("Promedio: " + promedioPesos + " kg");
        }
    }

    private void pesoMayorMenor(){
        if(listaMascotas.isEmpty()){
            view.mostrarMensaje("Debe registrar una mascota de primero");
            return;
        }

        Mascota mascota = buscarMascota(view.pedirIdMascota());

        if( mascota == null){
            view.mostrarMensaje("No se encontró la mascota");
            return;
        }

        double pesoMayor = mascota.getPesoMayor();
        double pesoMenor = mascota.getPesoMenor();

        if(pesoMayor == -1 ){
            view.mostrarMensaje("La mascota no tiene controles");
            return;
        } else {
            view.mostrarMensaje(
                "Peso mayor: " + pesoMayor + " kg\n" +
                "Peso menor: " + pesoMenor + " kg"
            );
        }
    }
}