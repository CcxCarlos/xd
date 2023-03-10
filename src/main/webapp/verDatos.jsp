<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Datos</title>
    <style>
        *{
            text-align: center;
        }
        body{
            /*background-image: url("images/backgound.jpg");*/
        }
        div{
            display: block;
            background-color: rgba(255,248,220, 0.7 );
            height: auto;
            width: 800px;
            margin: 10% auto;
            padding: 30px;
            border: 3px double;
            border-radius: 10px;
        }
        img{
            height: 280px;
            width: 280px;
        }
    </style>
</head>
<body>
    <div>
        <H1>Clients</H1>
        <H3>${color}</H3>
        <p>${marques}</p>
        <br>
        <%--<img src="images/vino-${color}.png">--%>
    </div>

</body>
</html>