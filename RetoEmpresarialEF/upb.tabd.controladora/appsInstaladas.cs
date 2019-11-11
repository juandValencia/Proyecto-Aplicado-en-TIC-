using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BR = upb.tabd.broker;
using EN = upb.tabd.entidades;

namespace upb.tabd.controladora
{
   /* class appsInstaladas
    {
        private BR.RetoEmpresarialEntities db = new BR.RetoEmpresarialEntities();

        public List<EN.appsInstaladas> ConsultarApps(string NombreUsuario)
        {

            List<EN.appsInstaladas> listado = new List<EN.appsInstaladas>();


            try
            {
                var resultado = from f in db.Usuarios
                                join c in db.AppsxUsuarios on f.Id equals c.IdUsuario
                                join V in db.AppsrRecomends on c.IdAplicacion equals V.IdAplicacion
                                select new { V.Nombre };

                foreach (var item in resultado)
                {
                    EN.appsInstaladas appsInstaladas = new EN.appsInstaladas();


                    appsInstaladas.NombreApp = item.Nombre;

                    listado.Add(appsInstaladas);
                }

            }
            catch (Exception ex)
            {
                throw ex;
            }
            return listado;
        }

    }
    */
}
