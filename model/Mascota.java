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

    public boolean setControl(double peso) {
        if (peso <= 0) {
            return false;
        }

        if (this.cantidadControles < this.control.length) {
            this.control[this.cantidadControles] = peso;
            this.cantidadControles++;
            return true;
        }
        return false;
    }
    
    public double[] getControl() {
        return control;
    }

    public double getPesoBy(int numeroControl) {
        if (numeroControl < 1 || numeroControl > cantidadControles) {
            return -1;
        }
        return control[numeroControl - 1];
    }

    public boolean updatePeso(int numeroControl, double nuevoPeso){
        if (numeroControl < 1 || numeroControl > cantidadControles){
            return false;
        }
        if( nuevoPeso <= 0){
            return false;
        }
        control[numeroControl - 1] = nuevoPeso;
        return true;
    }
    public int getCantidadControles() {
        return cantidadControles;
    }

    public double calcularPromedio(){
        if (cantidadControles == 0){
            return -1;
        }

        double sumaPesos = 0.0;

        for (int i = 0; i < cantidadControles; i++){
            sumaPesos += control[i];
        }

        return (sumaPesos / cantidadControles);
    }

    public double getPesoMayor(){
        if (cantidadControles == 0){
            return -1;
        }

        double mayor = control[0];

        for (int i = 1; i < cantidadControles; i++){
            if ( control[i] > mayor){
                mayor = control[i];
            }
        }
        return mayor;
    }

    public double getPesoMenor(){
        if (cantidadControles == 0){
            return -1;
        }

        double menor = control[0];

        for (int i = 1; i < cantidadControles; i++){
            if ( control[i] < menor){
                menor = control[i];
            }
        }
        return menor;
    }
}