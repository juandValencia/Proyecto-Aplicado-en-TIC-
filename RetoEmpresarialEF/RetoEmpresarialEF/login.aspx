<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="RetoEmpresarialEF.login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
     
    <title>Login</title>
    <link href="resources/css/estilos.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</head>
<body>
    
        <div class="container">
            <img src="resources/img/logo.png" class="avatar" alt="Avatar Image" />            
            <h1>Iniciar Sesión</h1>                

            <form runat ="server">
                <asp:Label ID="lblcorreo" runat="server" Text="ingrese el correo"></asp:Label>
                <asp:TextBox ID="txtcorreo" runat="server" CssClass="form-control"></asp:TextBox>
                <asp:Label ID="Labelcontraseña" runat="server" Text="ingrese su contraseña"></asp:Label>
                <asp:TextBox ID="txtcontraseña" runat="server" CssClass="form-control" TextMode="Password"></asp:TextBox>
                <asp:Button ID="btnIngresar" runat="server" Text="Ingresar" CssClass=" btn btn-primary" OnClick="btnIngresar_Click" />


            </form>
            </div>
             <asp:Label ID="lblConfirmacioningreso" runat="server"  ></asp:Label>
            <div class="form-group">
        </div>
    
</body>
</html>
