<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<head>
    <title>JSP - Hello World</title>
</head>
<body onload="mostrarMensaje()">
<table style="width:90%">
    <input type="hidden" name="see_clients" value="0">
    <form class="form" action="SelectCompte.do" method="post">

        <tr>
            <th style="width: 20%">  <label for="nom">Nombre Cliente:</label></th>
            <td>  <input type="text" id="nom" name="nom" value=""></td>
        </tr>


        <tr>
            <th style="width: 20%">  <label for="dni">ID, DNI</label></th>
            <td>  <input type="text" id="dni" name="dni" value=""></td>
        </tr>


        <tr>
            <th style="width: 20%">  <label for="email">Email</label></th>
            <td>  <input type="text" id="email" name="email" value=""></td>
        </tr>

        <tr>
            <th style="width: 20%">  <label for="pais">Pais</label></th>
            <td>  <input type="text" id="pais" name="pais" value=""></td>
        </tr>

        <tr>
            <th style="width: 20%">  <label for="cuenta">Cuenta</label></th>
            <td>  <input type="text" id="cuenta" name="cuenta" value=""></td>
        </tr>

        <tr>
            <th style="width: 20%">  <label for="ingresI">ingreso inicial(€)</label></th>
            <td>  <input type="text" id="ingresI" name="ingresI" value=""></td>
        </tr>

        <tr>
            <th colspan="2">  <button class="submit" type="submit" value="Submit" name="create">Create</button></th>
        </tr>
    </form>
    <form class="form" action="buscarusuarios" method="post">
        <tr>
            <th colspan="2">  <button class="submit" type="submit" value="Submit" name="mostrarusuarios">Mostrar client i les seves comptes</button></th>
        </tr>
    </form>
</table>
<script>
    const form = document.getElementsByClassName("form");

    form.addEventListener('submit', function (event) {
        if (isEmpty(form)) alert("Por favor, complete todos los campos");
    });
    function isEmpty(form) {
        const inputs = form.querySelectorAll("input");
        for (let i = 0; i < inputs.length; i++) {
            if (inputs[i].value.trim() === "") {
                return true;
            }
        }
        return false;
    }
    function mostrarMensaje() {
        var mensaje = "${mensaje}";
        if (mensaje !== "") {
            alert(mensaje);
        }
    }

</script>

</body>
</html>