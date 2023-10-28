package org.bedu.java.jse.basico.project.lista.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Tarea implements Serializable {

    private String nombre;
    private LocalDate fechaExpiracion;
    private LocalDate fechaCreacion;
    private boolean realizada;
    private LocalDate fechaRealizacion;

    {
        fechaCreacion = LocalDate.now();
    }

    // Constructor
    public Tarea(String nombre){
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Tarea tarea = (Tarea) obj; //Convertir el obj a la clase Tarea

        return nombre.equals(tarea.nombre); // Comparar a las tareas por su nombre
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    //Metodo para saber si está realizada la tarea
    public boolean fueRealizada(){
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    // Método para saber la fecha de en que fue realizada la tarea
    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion){
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }


}
