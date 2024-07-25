using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo32
{
    class Program
    {
        static async Task Main(string[] args)
        {

            // Calculamos la suma de la secuencia fibonacci
            Task<long> t = FibonacciAsync(40);


            // Mostramos los números del 1 al 10
            Console.WriteLine("Mostrando números del 1 al 10:");
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(i);
                await Task.Delay(2000);
            }

            long l = await t;

            Console.WriteLine("El resultado de la suma de la secuencia de Fibonacci es: " + l);
            Console.ReadKey();
        }

        static long Fibonacci(int n)
        {
            if (n <= 1)
                return n;
            else
                return Fibonacci(n - 1) + Fibonacci(n - 2);
        }

        static async Task<long> FibonacciAsync(int n)
        {
            long l = await Task.Run(()=>{
                                return Fibonacci(n);
                            });
            return l;
        }
    }
}
