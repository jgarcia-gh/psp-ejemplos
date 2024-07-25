using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo30
{
    class Program
    {
        static void Main(string[] args)
        {
            PrepararCafe();
            Console.WriteLine("Vamos con las tostadas");
            PrepararTostadas();
            Console.WriteLine("Desayuno finalizado");
            Console.ReadKey();
        }

        static async void PrepararTostadas()
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
        static async void PrepararCafe()
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
