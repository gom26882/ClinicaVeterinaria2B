package model;
import constants.TipoEspecie;

public class Mascota {
    
    private String nombre;
    private int edad;
    private double[] control;
    private TipoEspecie tipoEspecie;

    public Mascota(String nombre, int edad, TipoEspecie tipoEspecie){
        this.nombre = nombre;
        this.edad = edad;
        this.tipoEspecie = tipoEspecie;
        this.control = new double[10];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreNuevo) {
        this.nombre = nombreNuevo;
    }

    public int getEdad(){
        return edad;
    }
}
