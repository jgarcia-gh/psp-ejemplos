package sockets.ejemplo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static String rutaFichero = "./Archivos/Servidor/ArchivoServidor.jpg";

    public static void main(String[] args) {

        System.out.println("---SERVIDOR---");

        // Iniciamos el servidor
        try (ServerSocket server = new ServerSocket(1234)) {

            System.out.println("Esperando conexión de un cliente...");

            try (Socket conexionCliente = server.accept()) {

                System.out.println("¡Cliente conectado!");

                // Obtenemos los flujos de entrada y salida del socket; también obtenemos flujo de entrada del fichero
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(conexionCliente.getInputStream());
                     BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(conexionCliente.getOutputStream());
                     FileInputStream fileInputStream = new FileInputStream(rutaFichero)) {

                    // Enviamos un archivo al cliente
                    System.out.println("Envío del archivo al cliente...");
                    byte[] buffer = new byte[4096]; // Buffer de 4KB
                    int bytesLeidos;
                    while ((bytesLeidos = fileInputStream.read(buffer)) != -1) {
                        bufferedOutputStream.write(buffer, 0, bytesLeidos);
                    }
                    bufferedOutputStream.flush();
                    /*
                        Esta llamada al método shutdownOutput() en el servidor después de enviar el archivo notifica al cliente que no se enviarán más datos.
                        Esto hace que el read en el cliente eventualmente devuelva -1, lo que evita el bloqueo.
                     */
                    conexionCliente.shutdownOutput();
                    System.out.println("Fichero enviado.");

                    // Recibimos archivo del cliente
                    System.out.println("Esperamos archivo del cliente...");
                    try (FileOutputStream fileOutputStream = new FileOutputStream("./Archivos/Servidor/RecibidoDelCliente.jpg")) {
                        while ((bytesLeidos = bufferedInputStream.read(buffer)) != -1) {
                            fileOutputStream.write(buffer, 0, bytesLeidos);
                        }
                        fileOutputStream.flush();
                    }
                    System.out.println("Archivo recibido y guardado en ./Archivos/Servidor/RecibidoDelCliente.jpg");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
