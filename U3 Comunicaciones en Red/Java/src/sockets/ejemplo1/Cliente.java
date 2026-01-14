package sockets.ejemplo1;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        System.out.println("---CLIENTE---");

        try (// Conectamos al servidor
             Socket cliente = new Socket("localhost", 1234);) {


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}