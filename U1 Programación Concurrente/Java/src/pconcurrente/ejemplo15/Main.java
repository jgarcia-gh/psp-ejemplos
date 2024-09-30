package pconcurrente.ejemplo15;

/*
En este ejemplo sí que existe memoria compartida. Se comparte el objeto Contador entre diferentes hilos y por eso el contador alcanza 500.
Aparentemente funciona bien, pero podemos comprobar que no es así si modificamos el bucle for de Contador para que cuente hasta 100000 en vez de 100
 */
public class Main {
    public static void main(String[] args) {
        Contador c = new Contador();
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(c);
            t.setName("Hilo " + i);
            t.start();
        }
    }
}

