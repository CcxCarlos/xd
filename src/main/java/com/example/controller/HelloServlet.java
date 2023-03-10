package com.example.controller;

import java.io.*;
import java.math.BigDecimal;

import com.example.DataAccess.ClientsDao;
import com.example.DataAccess.ClientsDaoImpl;
import com.example.DataAccess.ComptesDao;
import com.example.DataAccess.ComptesDaoImpl;
import com.example.Model.Clients;
import com.example.Model.Comptes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*nombre, dni, email, pais, cuenta, ingres*/
        ClientsDaoImpl clientsDao = new ClientsDaoImpl();
        ComptesDaoImpl comptesDao = new ComptesDaoImpl();

        Clients client = new Clients( request.getParameter("dni"), request.getParameter("nom"), request.getParameter("email"),
                request.getParameter("pais"));
        Comptes compte = new Comptes(request.getParameter("cuenta"),  new BigDecimal(request.getParameter("ingresI")));

        boolean clientExitst = clientsDao.objectExists(client);
        boolean compteExists = comptesDao.objectExists(compte);

        StringBuilder msg = new StringBuilder();
        if (!clientExitst && !compteExists){
            clientsDao.addObject(client);
            comptesDao.addObject(compte);
            msg.append("Cuenta y client creados");
        }else if(clientExitst && !compteExists){
            comptesDao.addObject(compte);
            msg.append("Cuenta creada en el cliente x");
        }else {
            msg.append("No se ha podido crear el cliente porque la cuenta ya existe");
        }

        request.setAttribute("mensaje", msg.toString());
        System.out.println(request.getRequestURI());
        RequestDispatcher dispatcher = request.getRequestDispatcher(request.getRequestURI());

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

/*

        PrintWriter out = response.getWriter();
        out.println ("<HTML>");
        out.println ("<BODY>");
        out.println ("<H1>Marques de Vi suggerides</H1>");
        out.println ("<H2>Tipus: " + clientsDao.getClientsByNombre("XD")+ "</H2>");
        out.println ("</BODY>");
        out.println ("</HTML>");*/

    }
}