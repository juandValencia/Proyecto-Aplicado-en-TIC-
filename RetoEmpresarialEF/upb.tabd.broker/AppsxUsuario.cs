//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace upb.tabd.broker
{
    using System;
    using System.Collections.Generic;
    
    public partial class AppsxUsuario
    {
        public int IdAplicacion { get; set; }
        public int IdUsuario { get; set; }
        public string Nombre { get; set; }
    
        public virtual AppsrRecomend AppsrRecomend { get; set; }
        public virtual Usuario Usuario { get; set; }
    }
}
