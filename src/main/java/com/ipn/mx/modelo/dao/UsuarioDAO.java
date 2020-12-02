/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author kevyn
 */
public class UsuarioDAO {

    private static final String SQL_INSERT = "{call spInsertarUsuario(?,?,?,?,?,?,?)}";
    private static final String SQL_UPDATE = "{call spActualizarUsuario(?,?,?,?,?,?,?)}";
    private static final String SQL_DELETE = "{call spBorrarUsuario(?)}";
    private static final String SQL_SELECT = "{call spVerUsuario(?)}";
    private static final String SQL_SELECT_ALL = "{call spSeleccionarUsuario()}";
    private static String SQL_FIND_BY_USERNAME_AND_PASSWORD = "{call spLogin(?,?)}";
    private Connection con;

    private void obtenerConexion() {
        Context ic;
        Context ec;
        String recursoDataSource = "jdbc/3cm9";
        try {
            ic = new InitialContext();
            ec = (Context) ic.lookup("java:comp/env");
            DataSource ds = (DataSource) ec.lookup(recursoDataSource);
            con = ds.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(UsuarioDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_INSERT);
            cs.setString(1, dto.getEntidad().getNombre());
            cs.setString(2, dto.getEntidad().getPaterno());
            cs.setString(3, dto.getEntidad().getMaterno());
            cs.setString(4, dto.getEntidad().getEmail());
            cs.setString(5, dto.getEntidad().getNombreUsuario());
            cs.setString(6, dto.getEntidad().getClaveUsuario());
            cs.setString(7, dto.getEntidad().getTipoUsuario());

            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void update(UsuarioDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_UPDATE);
            cs.setString(1, dto.getEntidad().getNombre());
            cs.setString(2, dto.getEntidad().getPaterno());
            cs.setString(3, dto.getEntidad().getMaterno());
            cs.setString(4, dto.getEntidad().getEmail());
            cs.setString(5, dto.getEntidad().getNombreUsuario());
            cs.setString(6, dto.getEntidad().getClaveUsuario());
            cs.setString(7, dto.getEntidad().getTipoUsuario());
            cs.setLong(8, dto.getEntidad().getIdUsuario());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void delete(UsuarioDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_DELETE);
            cs.setLong(1, dto.getEntidad().getIdUsuario());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public UsuarioDTO read(UsuarioDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = con.prepareCall(SQL_SELECT);
            cs.setLong(1, dto.getEntidad().getIdUsuario());
            rs = cs.executeQuery();
            List lista = obtenerResultados(rs);
            if (lista.size() > 0) {
                return (UsuarioDTO) lista.get(0);
            } else {
                return null;
            }
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List readAll() throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = con.prepareCall(SQL_SELECT_ALL);

            rs = cs.executeQuery();
            List lista = obtenerResultados(rs);
            if (lista.size() > 0) {
                return lista;
            } else {
                return null;
            }
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setIdUsuario(rs.getLong("idUsuario"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setMaterno(rs.getString("materno"));
            dto.getEntidad().setEmail(rs.getString("email"));
            dto.getEntidad().setNombreUsuario(rs.getString("nombreUsuario"));
            dto.getEntidad().setTipoUsuario(rs.getString("tipoUsuario"));//este cambiarlo
        }
        return resultados;
    }

    public static void main(String[] args) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setIdUsuario(1L);
        dto.getEntidad().setNombre("Bruno");
        dto.getEntidad().setPaterno("Diaz");
        dto.getEntidad().setMaterno("Batman");
        dto.getEntidad().setEmail("Batman@gmail.com");
        dto.getEntidad().setNombreUsuario("Batman");
        dto.getEntidad().setClaveUsuario("Batman");
        dto.getEntidad().setTipoUsuario("admin");
        System.out.println(dto.toString());
    }
}
