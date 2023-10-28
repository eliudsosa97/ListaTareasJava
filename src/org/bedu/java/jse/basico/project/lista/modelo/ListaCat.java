package org.bedu.java.jse.basico.project.lista.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaCat implements Serializable {
    private String nombre;
    private final LocalDate fechaCreacion;

    private final List<Tarea> tareas = new ArrayList<>(); // Lista de tareas en una categoría

    // Inicializar la fecha de creación automaticamente al crear una categoría
    {
        fechaCreacion = LocalDate.now();
    }

    public ListaCat(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para agregar una tarea a una categoría
    public void agregarTarea( Tarea tarea) {
        tareas.add(tarea);
    }

    // Método para eliminar una tarea de una categoría
    public Tarea eliminaTarea(int indice){
        if(indice >= tareas.size()){
            System.out.println("La tarea seleccionada no se encuantra en la lista");
            return null;
        }

        return  tareas.remove(indice);
    }

    public List<Tarea> getTareas(){
        return tareas;
    }

    // Método para obtener el número de tareas en la categoría

    public int numeroTareas(){
        return tareas.size();
    }

    // Método para mostrar las tareas de la categoría
    public void muestrarTareas(){
        for (int i = 0; i < tareas.size(); i++){
            System.out.println((i + 1) + " - " + tareas.get(i).getNombre());
        }
    }



}
