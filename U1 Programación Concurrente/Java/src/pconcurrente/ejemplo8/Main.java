package pconcurrente.ejemplo8;

/*
Este ejemplo nos sirve para demostrar que desde una expresión lambda podemos:
- Acceder (leer y modificar) atributos de la clase contenedora: En este caso la clase contenedora es la clase Main.
Por eso, desde la clase anónima es posible leer y modificar el atributo contador.
- Llamar a métodos de la clase contenedora: Desde la clase anónima podemos llamar al método IncrementaContador.
- Leer variables locales del método que contiene la clase anónima: Desde la clase anónima podemos leer el valor de
la variable texto. Pero OJO! solo leer su valor. Si intentamos modificar su valor se producirá un error de compilación.

Es decir, lo mismo que con las clases anónimas (ejemplo 6).
 */

public class Main {
    public static int contador = 1;
    public static void main(String[] args) {
        String texto = "elefante(s) se balanceaban ...";
        Thread t = new Thread(() -> {
                while(contador <= 5){
                    System.out.println(contador + " " + texto);
                    IncrementaContador();
                }
        });
        t.start();
    }
    public static void IncrementaContador(){
        contador++;
    }
}
