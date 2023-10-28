package org.bedu.java.jse.basico.project.lista;

import java.util.Scanner;

public class Lector {

    private Scanner scanner = new Scanner(System.in);

    public byte leerOpcion() {
        System.out.print("Opción: ");
        return scanner.nextByte();
    }

    public String leerTexto(){
        System.out.print("Texto: ");
        return scanner.nextLine();
    }
}
