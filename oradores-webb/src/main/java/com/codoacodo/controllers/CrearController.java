package com.codoacodo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.dao.OradorDAO;

/*HERENCIA*/
//Create Controller es hijo de :
@WebServlet("/api/CrearController")
public class CrearController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener datos del formulario
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String mail = req.getParameter("mail");
        String tema = req.getParameter("tema");

        // Crear un nuevo objeto Orador
        Orador nuevoOrador = new Orador(null, nombre, apellido, mail, tema, null);

        // Crear una instancia de OradorDAO
        OradorDAO dao = new OradorDAO();

        // Llamar al método crearOrador
        dao.crearOrador(nuevoOrador);

        resp(resp, req);
    }

    private void resp(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        // Redirigir a la página de listado después de la inserción
        resp.sendRedirect(req.getContextPath() + "/api/ListadoController");
    }
}

