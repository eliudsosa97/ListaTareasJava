package org.bedu.java.jse.basico.project.lista;

import org.bedu.java.jse.basico.project.lista.modelo.ListaCat;
import org.bedu.java.jse.basico.project.lista.modelo.Tarea;

import java.time.LocalDate;

public class ControladorTareas {

    private final Lector lector = new Lector();

    // Método para crear una nueva tarea
    public Tarea nuevaTarea(){
        System.out.println("\nNueva tarea");
        System.out.println("Titulo ");
        String tituloTarea = lector.leerTexto();

        return new Tarea(tituloTarea);
    }

    // Método para eliminar una tarea

    public Tarea eliminaTarea(ListaCat listaTareas) {
        System.out.println("Eliminar tarea ");

        System.out.println("¿Qué numero de tarea quieres eliminar?");
        byte indice = lector.leerOpcion();

        if (indice > listaTareas.numeroTareas()) {
            System.out.println("La tarea que quieres eliminar no existe");
            return null;
        }

        return listaTareas.eliminaTarea(indice -1);
    }

    // Método para marcar una tarea como finalizada

    public Tarea tareaFinalizada(ListaCat listaTareas) {
        System.out.println("Finalizar tarea");

        System.out.println("¿Qué tarea ha finalizado?");
        byte indice = lector.leerOpcion();

        if (indice > listaTareas.numeroTareas()) {
            System.out.println("La tarea que quieres finalizar no existe");
            return null;
        }

        Tarea tarea = listaTareas.getTareas().get(indice -1);
        tarea.setFechaRealizacion(LocalDate.now());
        tarea.setRealizada(true);

        return tarea;
    }

}
