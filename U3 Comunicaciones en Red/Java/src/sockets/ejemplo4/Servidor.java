package sockets.ejemplo4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static String ruta = "./Archivos/Servidor/";
    public static String fichero = "ArchivoServidor.jpg";
    public static String rutaFichero = ruta + fichero;

    public static void main(String[] args) {

        System.out.println("---SERVIDOR---");

        try (ServerSocket server = new ServerSocket(1234)) {

            System.out.println("Esperando conexión de un cliente...");

            try (Socket conexionCliente = server.accept()) {

                System.out.println("¡Cliente conectado!");

                // Obtenemos los flujos de entrada de fichero y salida del socket
                try (DataOutputStream dataOutputStream = new DataOutputStream(conexionCliente.getOutputStream());
                     FileInputStream fileInputStream = new FileInputStream(rutaFichero)) {

                    // En primer lugar enviamos al cliente el nombre del archivo que le vamos a enviar
                    dataOutputStream.writeUTF(fichero);
                    // A continuación, enviamos el tamaño del archivo
                    File file = new File(rutaFichero);
                    dataOutputStream.writeLong(file.length());
                    // Por último, enviamos el archivo
                    System.out.println("Enviando archivo " + fichero + " " + file.length() + " bytes");
                    byte[] buffer = new byte[4096]; // Buffer de 4KB
                    int bytesLeidos;
                    while ((bytesLeidos = fileInputStream.read(buffer)) != -1) {
                        dataOutputStream.write(buffer, 0, bytesLeidos);
                    }
                    dataOutputStream.flush();
                    System.out.println("Fichero enviado.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
