package sockets.ejemplo8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {
        System.out.println("---SERVIDOR---");

        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Esperando conexión de un cliente...");
            while(true) { // Poner un while(true) no es la mejor práctica, pero se ha hecho así con el objeto de simplificar el código
                try (Socket conexionCliente = server.accept()) {
                    System.out.println("¡Cliente conectado!");
                    Scanner sc = new Scanner(System.in);
                    // Obtener los flujos de entrada y salida usando try-with-resources
                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexionCliente.getInputStream()));
                         OutputStream outputStream = conexionCliente.getOutputStream();
                         PrintWriter printWriter = new PrintWriter(outputStream, true);) {

                        // Leemos líneas y las mostramos hasta que recibimos fin
                        String lineaRecibida  = "";
                        String mensajeAEnviar = "";
                        while(!lineaRecibida.equals("fin")){
                            // Recibimos mensaje
                            lineaRecibida = bufferedReader.readLine();
                            if(!lineaRecibida.equals("fin")){
                                System.out.println("El mensaje recibido es: " + lineaRecibida);

                                // Enviamos mensaje
                                System.out.print("Escribe el mensaje a enviar: ");
                                mensajeAEnviar = sc.nextLine();
                                printWriter.println(mensajeAEnviar);
                            }
                        }
                        System.out.println("¡Cliente desconectado!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}