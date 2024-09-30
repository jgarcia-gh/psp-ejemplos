package sockets.ejemplo7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        System.out.println("---SERVIDOR---");

        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Esperando conexión de un cliente...");
            while(true) { // Poner un while(true) no es la mejor práctica, pero se ha hecho así con el objeto de simplificar el código
                try (Socket conexionCliente = server.accept()) {
                    System.out.println("¡Cliente conectado!");

                    // Obtener los flujos de entrada usando try-with-resources
                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexionCliente.getInputStream()));) {

                        // Leemos líneas y las mostramos hasta que recibimos fin
                        String lineaRecibida  = "";
                        while(!lineaRecibida.equals("fin")){
                            lineaRecibida = bufferedReader.readLine();
                            if(!lineaRecibida.equals("fin")){
                                System.out.println("El mensaje recibido es: " + lineaRecibida);
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}