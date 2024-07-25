using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo32
{
    class Tostada
    {
        private string ingredientes;

        public void AñadirIngrediente(string ingrediente)
        {
            ingredientes += " " + ingrediente;
        }
        public override string ToString()
        {
            return "Tostada con" + ingredientes;
        }
    }

    class Tostadora
    {
        
        public async Task PrepararTostadas(int numTostadas, Action<Tostada> callback)
        {
            for (int i = 0; i < numTostadas; i++)
            {
                Console.WriteLine("Tostadas: Comenzamos a preparar las tostadas");
                Console.WriteLine("Tostadas: Ponemos el pan a tostar");
                await Task.Delay(2000);
                Console.WriteLine("Tostadas: Echamos aceite");
                await Task.Delay(2000);
                Console.WriteLine("Tostadas: Echamos sal");
                await Task.Delay(2000);
                Tostada t = new Tostada();
                Console.WriteLine("Tostadas: Tostadas finalizadas");
                callback(t);
            }
        }
    }


    class Program
    {
        static async Task Main(string[] args)
        {

            Tostadora t = new Tostadora();
            Task tareaTostadora = t.PrepararTostadas(5, TostadaFinalizada);
            await tareaTostadora;
            Console.WriteLine("Tostadas terminadas");
            Console.ReadKey();

        }

        static void TostadaFinalizada(Tostada t)
        {
            t.AñadirIngrediente("mermelada");
            Console.WriteLine("Finalizado: " + t);
        }
    }

}
