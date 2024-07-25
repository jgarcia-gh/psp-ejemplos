using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo29
{
    class Program
    {
        static void Main(string[] args)
        {
            PrepararCafe();
            PrepararTostadasAsync();
            Console.ReadKey();
        }

        static void PrepararTostadasAsync()
        {
            Console.WriteLine("Tostadas: Comenzamos a preparar las tostadas");
            Console.WriteLine("Tostadas: Ponemos el pan a tostar");
            Task.Delay(2000);
            Console.WriteLine("Tostadas: Echamos aceite");
            Task.Delay(2000);
            Console.WriteLine("Tostadas: Echamos sal");
            Task.Delay(2000);
            Console.WriteLine("Tostadas: Tostadas finalizadas");
        }
        static void PrepararCafe()
        {
            Console.WriteLine("Café: Comenzamos a preparar el café");
            Console.WriteLine("Café: Ponemos la cafetera");
            Task.Delay(2000);
            Console.WriteLine("Café: Servimos el café en la taza");
            Task.Delay(2000);
            Console.WriteLine("Café: Echamos la leche");
            Task.Delay(2000);
            Console.WriteLine("Café: Café finalizado");

        }
    }
}
