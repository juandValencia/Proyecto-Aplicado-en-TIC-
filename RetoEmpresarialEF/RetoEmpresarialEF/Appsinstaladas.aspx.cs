﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using CT = upb.tabd.controladora;
using EN = upb.tabd.entidades;

namespace RetoEmpresarialEF
{
    public partial class Appsinstaladas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnConsultar_Click(object sender, EventArgs e)
        {
            CT.usuario controladora = new CT.usuario();
            CT.usuario controladora2 = new CT.usuario();

            List<EN.AppsRecomendadas> listado = controladora.ConsultarApps(txtCorreoUsuario.Text);
            gdvApps.DataSource = listado;
            gdvApps.DataBind();

            List<EN.AppsRecomendadas> listado2 = controladora2.ConsultarAppsNoInstaladas(txtCorreoUsuario.Text);
            gdvNoapps.DataSource = listado2;
            gdvNoapps.DataBind();


        }

    }
    }
