using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo31
{
    class Program
    {
        static async Task Main(string[] args)
        {
            Task tCafe = PrepararCafe();
            Task tTostadas = PrepararTostadas();

            await tCafe;
            await tTostadas;

            Console.WriteLine("Desayuno finalizado");
            Console.ReadKey();
        }

        static async Task PrepararTostadas()
        {
            Console.WriteLine("Tostadas: Comenzamos a preparar las tostadas");
            Console.WriteLine("Tostadas: Ponemos el pan a tostar");
            await Task.Delay(2000);
            Console.WriteLine("Tostadas: Echamos aceite");
            await Task.Delay(2000);
            Console.WriteLine("Tostadas: Echamos sal");
            await Task.Delay(2000);
            Console.WriteLine("Tostadas: Tostadas finalizadas");
        }
        static async Task PrepararCafe()
        {
            Console.WriteLine("Café: Comenzamos a preparar el café");
            Console.WriteLine("Café: Ponemos la cafetera");
            await Task.Delay(2000);
            Console.WriteLine("Café: Servimos el café en la taza");
            await Task.Delay(2000);
            Console.WriteLine("Café: Echamos la leche");
            await Task.Delay(2000);
            Console.WriteLine("Café: Café finalizado");

        }
    }
}
