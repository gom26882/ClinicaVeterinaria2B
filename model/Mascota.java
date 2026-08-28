package model;

import java.time.LocalDate;
import constants.TipoEspecie;

public class Mascota {
    
    private static int contador = 0; 
    private int id;
    private String nombre;
    private LocalDate edad;
    private double[] control;
    private TipoEspecie tipoEspecie;
    private int cantidadControles; // Controla la posición actual en el arreglo

    public Mascota(String nombre, LocalDate edad, TipoEspecie tipoEspecie) {
        contador++;
        this.id = contador;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoEspecie = tipoEspecie;
        this.control = new double[10];
        this.cantidadControles = 0;
    }

    public boolean setControl(double peso) {
        if (this.cantidadControles < this.control.length) {
            this.control[this.cantidadControles] = peso;
            this.cantidadControles++;
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreNuevo) {
        this.nombre = nombreNuevo;
    }

    public LocalDate getEdad() {
        return edad;
    }

    public void setEdad(LocalDate edadNueva) {
        this.edad = edadNueva;
    }

    public TipoEspecie getTipoEspecie() {
        return tipoEspecie;
    }

    public double[] getControl() {
        return control;
    }
    
    public int getCantidadControles() {
        return cantidadControles;
    }
}