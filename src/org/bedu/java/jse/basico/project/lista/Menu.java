package org.bedu.java.jse.basico.project.lista;

public class Menu {
    //Método para mostrar el menú principal

    public void mostrarMenu() {
        System.out.println("\n==SELECCIONA UNA OPCIÓN==\n");
        System.out.println("1. Crear nueva categoría de tareas");
        System.out.println("2. Ver categorías");
        System.out.println("3. Ver tareas por categoría");
        System.out.println("4. Actualizar o eliminar tareas por categoría");
        System.out.println("5. Eliminar categoría");
        System.out.println("6. Salir y guardar");
    }

    //Método para mostrar menu secundario

    public void mostrarSubMenu() {
        System.out.println("\n==SELECCIONA UNA OPCIÓN PARA REALIZAR EN ESTA CATEGORÍA==\n");
        System.out.println("1. Agregar nueva tarea");
        System.out.println("2. Eliminar tarea");
        System.out.println("3. Marcar tarea como realizada");
        System.out.println("4. Regresar");
    }
}
