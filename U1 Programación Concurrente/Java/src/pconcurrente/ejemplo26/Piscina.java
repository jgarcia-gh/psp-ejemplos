package pconcurrente.ejemplo26;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Piscina {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition puedeNadar = lock.newCondition();
    private final Condition puedeSaltar = lock.newCondition();

    private boolean turnoDeSaltos = false; // false = turno de natación, true = turno de saltos

    public void nadar(String nombre) throws InterruptedException {
        lock.lock();
        try {
            while (turnoDeSaltos) {
                System.out.println(nombre + " espera a que termine el turno de saltos...");
                puedeNadar.await();
            }
            System.out.println(nombre + " está nadando tranquilamente.");
        } finally {
            lock.unlock();
        }
    }

    public void saltar(String nombre) throws InterruptedException {
        lock.lock();
        try {
            while (!turnoDeSaltos) {
                System.out.println(nombre + " espera a que termine el turno de natación...");
                puedeSaltar.await();
            }
            System.out.println(nombre + " salta desde el trampolín. ¡Splash!");
        } finally {
            lock.unlock();
        }
    }

    public void cambiarTurno() {
        lock.lock();
        try {
            turnoDeSaltos = !turnoDeSaltos;
            if (turnoDeSaltos) {
                System.out.println("El socorrista anuncia: ¡Turno de SALTOS!");
                puedeSaltar.signalAll();
            } else {
                System.out.println("El socorrista anuncia: ¡Turno de NATACIÓN!");
                puedeNadar.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}