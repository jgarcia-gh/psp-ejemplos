using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo31a
{
    class Program
    {
        static async Task Main(string[] args)
        {
            // Calculamos la suma de la secuencia fibonacci
            long resultado = Fibonacci(40);
            Console.WriteLine("El resultado de la suma de la secuencia de Fibonacci es: " + resultado);


            // Mostramos los números del 1 al 10
            Console.WriteLine("Mostrando números del 1 al 10:");
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(i);
                await Task.Delay(2000);
            }
        }

        static long Fibonacci(int n)
        {
            if (n <= 1)
                return n;
            else
                return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
