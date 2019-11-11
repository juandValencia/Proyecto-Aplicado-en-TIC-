using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BR = upb.tabd.broker;
using EN = upb.tabd.entidades;

namespace upb.tabd.controladora
{
    public class usuario
    {
        private BR.RetoEmpresarialEntities db = new BR.RetoEmpresarialEntities();

        public bool loguearse(string correo, string contraseña)
        {
             bool termino = false;

            string resultado1;
             try
             {

                 var resultado = (from r in db.admins
                                                  where r.usuario == correo && r.contraseña == contraseña
                                                  select r.usuario).First();


                resultado1 = resultado.ToString();

                 //Console.WriteLine(resultado1);

                 if (string.IsNullOrEmpty(resultado1))
                 {
                     termino = false;
                 }
                 else
                 {
                     termino = true;
                 }


             }
             catch (Exception ex)
             {
                termino = false;

             }
            /* var resultado = (from r in db.Usuarios
                             where r.Correo == correo && r.Contraseña == contraseña
                             select r.Correo).First();


             resultado1 = bool.Parse(resultado);



             */
            return termino;
        }
        public List<EN.AppsRecomendadas> ConsultarApps(string NombreUsuario)
        {

            List<EN.AppsRecomendadas> listado = new List<EN.AppsRecomendadas>();


            try
            {
                var resultado = from f in db.Usuarios
                                join c in db.AppsxUsuarios on f.Id equals c.IdUsuario
                                join V in db.AppsrRecomends on c.IdAplicacion equals V.IdAplicacion
                                where f.Correo==NombreUsuario
                                select new { V.Nombre };
                                

                foreach (var item in resultado)
                {
                    EN.AppsRecomendadas appsrecomendadas = new EN.AppsRecomendadas();

                   
                    appsrecomendadas.NombreAppRecomendada = item.Nombre;

                    listado.Add(appsrecomendadas);
                }

            }
            catch (Exception ex)
            {
                throw ex;
            }
            return listado;
        }
        public List<EN.AppsRecomendadas> ConsultarAppsNoInstaladas(string NombreUsuario)
        {

            List<EN.AppsRecomendadas> listado = new List<EN.AppsRecomendadas>();
            List<EN.AppsRecomendadas> listado2 = new List<EN.AppsRecomendadas>();
            EN.AppsRecomendadas appsrecomendadas = new EN.AppsRecomendadas();
            EN.AppsRecomendadas appsrecomendadas2 = new EN.AppsRecomendadas();


            try
            {
                var resultado1 = from f in db.AppsrRecomends                          
                               // where f.Correo == NombreUsuario
                                select new { f.Nombre };


                foreach (var item in resultado1)
                {
                    


                    appsrecomendadas2.NombreAppRecomendada = item.Nombre;

                    listado2.Add(appsrecomendadas);
                   
                }
                /*
                var resultado2 = from f in db.Usuarios
                                join c in db.AppsxUsuarios on f.Id equals c.IdUsuario
                                join V in db.AppsrRecomends on c.IdAplicacion equals V.IdAplicacion
                                 where f.Correo == NombreUsuario
                                select new { V.Nombre };


                foreach (var item in resultado2)
                {
                    


                    appsrecomendadas2.NombreAppRecomendada = item.Nombre;

                    listado2.Add(appsrecomendadas2);

                }
                */
                //listado.Except(listado2);

            }
            catch (Exception ex)
            {
                throw ex;
            }
            return listado2;
        }






    }
    





}
