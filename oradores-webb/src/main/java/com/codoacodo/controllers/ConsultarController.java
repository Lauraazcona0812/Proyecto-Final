package com.codoacodo.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.dao.Conexion;
import static com.codoacodo.dao.Conexion.getConexion;
import com.codoacodo.model.Orador;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/api/ConsultarController")
public class ConsultarController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		//validaciones!!!
		
		String sql = "SELECT * FROM PRODUCTO WHERE ID = " + id;
		
            try {
                //conexion OK
                Connection conn = getConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarController.class.getName()).log(Level.SEVERE, null, ex);
            }
		try {
			//statement 
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {//�hay datos?
				// rs > sacando los datos
                                Long//<editor-fold defaultstate="collapsed" desc="comment">
                                        idOrador = rs.getLong(1);
//</editor-fold>
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fechaAlta = rs.getTimestamp(6);
				
				//campos crear un objeto????
       Orador nuevoOrador = new Orador(null, nombre, apellido, mail, tema, null);
				
				//ir a otra pagina y ademas pasarle datos
				
        resp.sendRedirect(req.getContextPath() + "/api/ListadoController");
			}
			
			getServletContext().getRequestDispatcher("/detalle.jsp").forward(req, resp);
			
			//cierre de conexion
			con.close();
		}catch (IOException | SQLException | ServletException e) {
		}
	}
}

