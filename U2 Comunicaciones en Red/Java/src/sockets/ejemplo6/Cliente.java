package sockets.ejemplo6;

import java.io.*;
import java.net.Socket;
import com.google.gson.Gson;

public class Cliente {
    public static void main(String[] args) {

        System.out.println("---CLIENTE---");

        try (// Conectamos al servidor
             Socket cliente = new Socket("localhost", 1234);

             // Obtenemos los flujos de entrada y salida
             InputStream inputStream = cliente.getInputStream();
             // Obtenemos los flujos de datos
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            // Recibimos datos del servidor
            System.out.println("Esperando datos del servidor...");
            String lineaRecibida = bufferedReader.readLine();
            System.out.println("El mensaje recibido es: " + lineaRecibida);
            Gson gson = new Gson();
            Perro p = gson.fromJson(lineaRecibida, Perro.class);
            System.out.println("JSON recibido y convertido a objeto: " + p);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}