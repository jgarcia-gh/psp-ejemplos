package sockets.ejemplo3;

import java.io.*;
import java.net.Socket;

public class Cliente {

    public static String ruta = "./Archivos/Cliente/";

    public static void main(String[] args) {

        System.out.println("---CLIENTE---");

        // Conectamos con el servidor y creamos flujo de entrada del socket
        try (Socket cliente = new Socket("localhost", 1234);
             DataInputStream dataInputStream = new DataInputStream(cliente.getInputStream());) {

            // Recibimos el nombre del archivo
            String nombreArchivo = dataInputStream.readUTF();
            // Recibimos tamaño del archivo
            long tamañoArchivo = dataInputStream.readLong();
            // Recibimos el archivo
            System.out.println("Recibiendo archivo " + nombreArchivo + " " + tamañoArchivo + " bytes");

            try (FileOutputStream fileOutputStream = new FileOutputStream("./Archivos/Cliente/" + nombreArchivo)) {
                byte[] buffer = new byte[4096]; // Buffer de 4KB
                int bytesLeidos;
                int bytesTotales = 0;

                // Leemos del flujo de entrada si el número total de bytes es inferior a la cantidad de bytes esperados
                while (bytesTotales < tamañoArchivo && (bytesLeidos = dataInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesLeidos);
                    bytesTotales+= bytesLeidos;
                }

                fileOutputStream.flush();
                System.out.println("Archivo recibido");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
