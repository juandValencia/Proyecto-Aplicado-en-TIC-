using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using CT = upb.tabd.controladora;
using EN = upb.tabd.entidades;
using System.Windows;



namespace RetoEmpresarialEF
{
    public partial class login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnIngresar_Click(object sender, EventArgs e)
        {

            string correo1 = txtcorreo.Text;
            string contraseña1 = txtcontraseña.Text;

            CT.usuario controladora = new CT.usuario();
            EN.usuario entidad = new EN.usuario();

            //bool confirmacion = controladora.loguearse(correo1, contraseña1);
            //lblConfirmacioningreso.Text = confirmacion;

            bool confirmacion=controladora.loguearse(correo1, contraseña1);

            if (confirmacion)
            {
                lblConfirmacioningreso.Text = "se logueo";
                lblConfirmacioningreso.CssClass = "alert-sucess";                
                Response.Redirect("Appsinstaladas.aspx");

            }
            else
            {
                lblConfirmacioningreso.Text = "error en la autentificacion";
                lblConfirmacioningreso.CssClass = "alert-danger";

            }
            


        }
    }
}