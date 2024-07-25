using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo33
{
    class Program
    {
        static void Main(string[] args)
        {
            // Definimos el callback
            Action<string> callback = (result) =>
            {
                Console.WriteLine($"Callback recibido con resultado: {result}");
            };

            // Llamar al método asíncrono y pasar el callback
            EjecutarTarea(callback);

            // Esperar entrada del usuario para mantener la consola abierta
            Console.ReadLine();
        }

        static void EjecutarTarea(Action<string> callback)
        {
            Task.Run(() =>
            {
                // Esta espera simula una operación costosa
                Task.Delay(2000).Wait();
                string result = "Operación completada";
                // Llamar al callback con el resultado
                callback(result);
            });
        }
    }

}
