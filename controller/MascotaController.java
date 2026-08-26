package controller;
import model.Mascota;
import java.util.ArrayList;

public class MascotaController {
    private ArrayList<Mascota> listaMascotas;

    public MascotaController() {
        listaMascotas = new ArrayList<>(); 
    }

    public void agregarMascota(Mascota mascota) {
        listaMascotas.add(mascota);
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
