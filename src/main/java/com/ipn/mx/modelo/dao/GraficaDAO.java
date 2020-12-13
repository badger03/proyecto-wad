/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.GraficaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevyn
 */
public class GraficaDAO {

    private static final String SQL_GRAFICAR = "select c.nombreCategoria as categoria, count(*) as productos from Producto p, Categoria c where p.idCategoria= c.idCategoria group by c.idCategoria";
 

    private Connection con;

    private void obtenerConexion() {
        String user = "kbiglixkqrjdwv";
        String pwd = "befb1ba10456ace47cb2f81582fbfc69549c989687f745df1b62daea3b8eb306"; //password
        String url = "jdbc:postgresql://ec2-3-218-123-191.compute-1.amazonaws.com:5432/dctvr0eudp9en0?sslmode=require";
        String driver = "org.postgresql.Driver";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   /*  private void obtenerConexion() {
        String user = "postgres";
        String pwd = "root"; //password
        String url = "jdbc:postgresql://localhost:5432/3CM9";
        String driver = "org.postgresql.Driver";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
  

    public List grafica() throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            ps = con.prepareStatement(SQL_GRAFICAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                GraficaDTO dto = new GraficaDTO();
                dto.setNombre(rs.getString("categoria"));
                dto.setCantidad(rs.getInt("productos"));
                lista.add(dto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lista;
    }

}
