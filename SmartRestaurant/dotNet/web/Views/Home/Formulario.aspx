<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Formulario.aspx.cs" Inherits="MVC_GerenciadoDeConteudo.Views.Home.Formulario" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        </div>
        <asp:TextBox ID="txtMessage" runat="server" Text="Nome"></asp:TextBox>
        <p>
        <asp:TextBox ID="TextBox1" runat="server" Text="Email"></asp:TextBox>
        </p>
        <p>
        <asp:TextBox ID="TextBox2" runat="server" Text="Assunto"></asp:TextBox>
        </p>
        <p>
        <asp:TextBox ID="TextBox3" runat="server" Text="Corpo do Email" Height="87px" Width="322px"></asp:TextBox>

        </p>

        <asp:Button ID="btnEnviar" runat="server" Text="Enviar Email" />




    </form>
</body>
</html>
