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

    public void iniciar(){
        int opcion; 

        do {

            opcion = view.mostrarMenu();
            switch(opcion){
                
                case 1:
                    agregarMascota();
                    break;
                case 2:
                    // 
                    break;
                case 3:
                    // historialPesos();
                    break;
                case 4:
                    // consultarControl();
                    break;
                case 5:
                    // actualizarControl();
                    break;
                case 6: 
                    // promedioPesos();
                    break;
                case 7:
                    // pesoMayorMenor();
                    break;
                case 8:
                    // controlesDisponibles();
                    break;
                case 9:
                    view.mostrarMensaje("saliendo... adiooos :)");
                    break;
                default:
                    view.mostrarMensaje("Porfavor use una opción válida");
                    break;
            }

        } while (opcion != 9);
    }


    public void agregarMascotaArray(Mascota mascota) {
        listaMascotas.add(mascota);
    }

    private void agregarMascota() {

    String nombre = view.pedirNombre();
    LocalDate edad = view.PedirEdad();
    String especieTexto = view.pedirTipoEspecie();

    TipoEspecie especie =
        TipoEspecie.valueOf(especieTexto.toUpperCase());

    Mascota mascota = new Mascota(nombre, edad, especie);

    agregarMascotaArray(mascota);

    view.mostrarMensaje("Mascota agregada correctamente.");

    for (Mascota m : listaMascotas) {
        System.out.println(
            "Nombre: " + m.getNombre() +
            " | Edad: " + m.getEdad() +
            " | Especie: " + m.getTipoEspecie()
        );
    }
}

    public Mascota buscarMascota(int id) {
        for (Mascota mascota : listaMascotas) {
			if (mascota.getId() == id) {
				return mascota;
			}
		}
		return null;
    }

    public void agregarControl(int id, double pesoControl) {

    }
}
