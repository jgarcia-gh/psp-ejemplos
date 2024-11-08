package sockets.ejemplo8;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        System.out.println("---CLIENTE---");

            try (// Conectamos conel servidor
                 Socket cliente = new Socket("localhost", 1234);
                 // Obtenemos flujos de entrada y salida
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                 OutputStream outputStream = cliente.getOutputStream();
                 PrintWriter printWriter = new PrintWriter(outputStream, true);
                 Scanner sc = new Scanner(System.in);) {

                // Leemos líneas y las mostramos hasta que recibimos fin
                String lineaRecibida  = "";
                String mensajeAEnviar = "";
                while(!mensajeAEnviar.equals("fin")){

                    // Enviamos mensaje
                    System.out.print("Escribe el mensaje a enviar: ");
                    mensajeAEnviar = sc.nextLine();
                    printWriter.println(mensajeAEnviar);

                    if(!mensajeAEnviar.equals("fin")){
                        // Recibimos mensaje
                        lineaRecibida = bufferedReader.readLine();
                        System.out.println("El mensaje recibido es: " + lineaRecibida);
                    }
                }
            }
    }
}