package model;
import java.time.LocalDate;
import constants.TipoEspecie;

public class Mascota {
    
    private int contador = 0;
    private int id = 0;
    private String nombre;
    private LocalDate edad;
    private double[] control;
    private TipoEspecie tipoEspecie;

    public Mascota(String nombre, LocalDate edad, TipoEspecie tipoEspecie){
        contador++;
        this.id = contador;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoEspecie = tipoEspecie;
        this.control = new double[10];
        id = id+1; 
    }

    public int getId(){
        return id;
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

    public TipoEspecie getTipoEspecie() {
        return tipoEspecie;
    }
}
