package sockets.ejemplo7;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        System.out.println("---CLIENTE---");

        try (// Conectamos al servidor
             Socket cliente = new Socket("localhost", 1234);

             // Obtenemos el flujo de salida
             OutputStream outputStream = cliente.getOutputStream();
             PrintWriter printWriter = new PrintWriter(outputStream, true);) {

            // Enviamos datos al servidor
            String mensaje = "";
            while(!mensaje.equals("fin")){
                Scanner sc = new Scanner(System.in);
                System.out.print("Escribe el mensaje a enviar: ");
                mensaje = sc.nextLine();
                printWriter.println(mensaje);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}