package org.bedu.java.jse.basico.project.lista;

public class PrincipalMain {
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        Lector lector = new Lector();
        Categorias categoria = new Categorias();
        byte opcionSeleccionada = 0;

        do {
            menu.mostrarMenu();
            opcionSeleccionada = lector.leerOpcion();

            System.out.printf("%n%nLa opción seleccionada es: %d%n", opcionSeleccionada);

            switch (opcionSeleccionada){
                case 1:
                    categoria.crearNuevaCat();
                    break;
                case 2:
                    categoria.verCategorias();
                    break;
                case 3:
                    categoria.verTareas();
                    break;
                case 4:
                    categoria.actualizarTareas();
                    break;
                case 5:
                    categoria.eliminarCategoria();
                    break;
                case 6:
                    categoria.guardarTareas();
                    System.out.println("Nos vemos pronto...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        }
        while (opcionSeleccionada != 6);
    }
}
