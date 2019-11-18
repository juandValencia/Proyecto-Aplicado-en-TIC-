using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace upb.tabd.entidades
{
    [Serializable]
    public class usuario
    {
        public double id { get; set; }
        public string nombre { get; set; }
        public double correo { get; set; }
        public double contraseña { get; set; }
        public double celular { get; set; }
    }


    [Serializable]
    public class AppsRecomendadas
    {
        public double id { get; set; }
        public string NombreAppRecomendada { get; set; }
        public string direccion { get; set; }

    }

    [Serializable]
    public class appsInstaladas
    {
        public usuario usuario { get; set; }
        public double id { get; set; }
       // public string NombreApp { get; set; }
        public string direccion { get; set; }
        public AppsRecomendadas recomendadas { get; set; }
        
    }
}
