package sockets.ejemplo3;

import java.io.*;
import java.net.Socket;

public class Cliente {

    public static String rutaFichero = "./Archivos/Cliente/ArchivoCliente.jpg";

    public static void main(String[] args) {

        System.out.println("---CLIENTE---");

        // Conectamos con el servidor y creamos los flujos de entrada y salida del socket
        try (Socket cliente = new Socket("localhost", 1234);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(cliente.getInputStream());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(cliente.getOutputStream())) {

            // Recibimos archivo del servidor
            System.out.println("Esperamos archivo del servidor...");
            try (FileOutputStream fileOutputStream = new FileOutputStream("./Archivos/Cliente/RecibidoDelServidor.jpg")) {
                byte[] buffer = new byte[4096]; // Buffer de 4KB
                int bytesLeidos;
                while ((bytesLeidos = bufferedInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesLeidos);
                }
                fileOutputStream.flush();
                System.out.println("Archivo recibido y guardado en ./Archivos/Cliente/RecibidoDelServidor.jpg");
            }

            // Enviamos un archivo al servidor
            System.out.println("Envío del archivo al servidor...");
            try (FileInputStream fileInputStream = new FileInputStream(rutaFichero)) {
                byte[] buffer = new byte[4096]; // Buffer de 4KB
                int bytesLeidos;
                while ((bytesLeidos = fileInputStream.read(buffer)) != -1) {
                    bufferedOutputStream.write(buffer, 0, bytesLeidos);
                }
                bufferedOutputStream.flush();
                cliente.shutdownOutput();
                System.out.println("Fichero enviado.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
