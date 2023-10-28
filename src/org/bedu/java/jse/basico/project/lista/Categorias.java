package org.bedu.java.jse.basico.project.lista;

import org.bedu.java.jse.basico.project.lista.modelo.ListaCat;
import org.bedu.java.jse.basico.project.lista.modelo.Tarea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Categorias {
    private static final String NOMBRE_ARCHIVO = System.getProperty("user.home") + "/.tareas";
    private Lector lector = new Lector();
    private List<ListaCat> categorias = new ArrayList<>();
    private Menu menu = new Menu();
    private ControladorTareas tareas = new ControladorTareas();



    public Categorias() throws Exception {
        cargaTareas();
    }

    // Método para creear una nueva categoría
    public void crearNuevaCat(){
        System.out.println("Crear una nueva categoría de tareas");
        String nombre = lector.leerTexto();
        ListaCat categoria = new ListaCat(nombre);
        categorias.add(categoria);
    }

    //Método para ver las tareas dentro de una categoría
    public void verTareas(){
        System.out.println("Ver tareas por categoría");
        byte indice = validaIndice();
        if (indice == 0){
            return;
        }
        ListaCat categoria = categorias.get(indice -1);

        if (categoria.numeroTareas() == 0){
            System.out.println("Aún no hay tareas en esta categoría");

        }
        System.out.println("Categoría: " + categoria.getNombre());
        categoria.muestrarTareas();
    }

    // Método para ver las categorías existentes
    public void verCategorias() {
        System.out.println("Categorías: ");



        if (!validarExistenciaCat()){
            return;
        }

        for (int i = 0; i <categorias.size(); i++){
            System.out.printf("%d - %s%n", (i + 1), categorias.get(i).getNombre());
        }


    }

    // Método para actualizar las tareas
    public void actualizarTareas() {
        System.out.println("Actualizar tareas");
        byte indice = validaIndice();

        if (indice == 0) {
            return;
        }

        ListaCat categoriaActual = categorias.get(indice - 1);

        menu.mostrarSubMenu();
        byte opcionSeleccionada = lector.leerOpcion();

        switch (opcionSeleccionada) {
            case 1:
                Tarea nuevaTarea = tareas.nuevaTarea();
                categoriaActual.agregarTarea(nuevaTarea);
                break;
            case 2:
                Tarea tareaParaEliminarse = tareas.eliminaTarea(categoriaActual);
                if (tareaParaEliminarse != null) {
                    System.out.printf("Se eliminó la tarea %s%n", tareaParaEliminarse.getNombre());
                } else {
                    System.out.println("No se ha podido eliminar la tarea");
                }
                break;
            case 3:
                Tarea tareaParaFinalizar = tareas.tareaFinalizada(categoriaActual);
                if (tareaParaFinalizar != null) {
                    System.out.printf("La tarea %s se completó el %2$te de %2$tB de %2$tY%n", tareaParaFinalizar.getNombre(), tareaParaFinalizar.getFechaRealizacion());
                } else {
                    System.out.println("No se pudo finalizar la tarea");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("Opción no valida");

        }
    }

        // Método para eliminar una categoría

        public void eliminarCategoria() {
            System.out.println("Eliminar categoría");
            byte indice = validaIndice();
            if (indice == 0){
                return;
            }
            ListaCat categoriaEliminada = categorias.remove(indice -1);
            System.out.printf("Se eliminó la lista de tareas: %s%n", categoriaEliminada.getNombre());

        }

        // Método privado para verificar si existen categorias

        private boolean validarExistenciaCat(){
        if (categorias != null && !categorias.isEmpty()){
            return true;
        }
            System.out.println("Todavía no se han creado categorías");
        return false;
        }

        // Método privado para validar el indice seleccionado

        private byte validaIndice(){
        byte indice = 0;
        if (!validarExistenciaCat()){
            return indice;
        }

        System.out.println("Indique el número de indice");
        indice = lector.leerOpcion();

        if (indice > categorias.size() || indice < 0) {
            System.out.println("No existen categorías en la opción seleccionada");
            indice = 0;
        }
        return indice;
        }

    // Método para cargar tareas
    public void cargaTareas() throws Exception {
        if (new File(NOMBRE_ARCHIVO).exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO));
            categorias = (List<ListaCat>) ois.readObject();

        }
    }

    // Método para guardar tareas
    public void guardarTareas() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO));
        oos.writeObject(categorias);
    }


}
