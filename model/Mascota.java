package model;
import java.time.LocalDate;
import constants.TipoEspecie;

public class Mascota {
    
    private String nombre;
    private LocalDate edad;
    private double[] control;
    private TipoEspecie tipoEspecie;

    public Mascota(String nombre, LocalDate edad, TipoEspecie tipoEspecie){
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

    public LocalDate getEdad(){
        return edad;
    }

    public void setEdad(LocalDate edadNueva) {
        this.edad = edadNueva;
    }

    public TipoEspecie getTipTipoEspecie() {
        return tipoEspecie;
    }
}
