/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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

    private static final String SQL_INSERT = "insert into Usuario (nombre,paterno,materno,email,nombreUsuario,claveUsuario,tipoUsuario) values (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update Usuario set nombre=?,paterno=?,materno=?,email=?,nombreUsuario=?,claveUsuario=?,tipoUsuario=? where idUsuario=?";
    private static final String SQL_DELETE = "delete from Usuario where idUsuario=?";
    private static final String SQL_SELECT = "select * from Usuario where idUsuario=?";
    private static final String SQL_SELECT_ALL = "select * from Usuario";
    private static String SQL_FIND_BY_USERNAME_AND_PASSWORD = "{call spLogin(?,?)}";
    private static final String SQL_READ_USUARIO = "SELECT * FROM Usuario WHERE nombreUsuario = ? AND claveUsuario = ?";
     int contador = 0;
    private Connection con;

   /*private void obtenerConexion() {
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
    }*/
     public Connection obtenerConexion() {
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
        return con;
    }
   /* public Connection obtenerConexion() {
        String user = "postgres";
        String pwd = "root"; //password
        String url = "jdbc:postgresql://localhost:5432/3CM9";
        String driverMySql = "org.postgresql.Driver";

        try {
            Class.forName(driverMySql);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }*/

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
            if(rs!=null){
                  rs.close();
              }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
     public int readUsuario(UsuarioDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = con.prepareCall(SQL_READ_USUARIO);
            cs.setString(1, dto.getEntidad().getNombreUsuario());
            cs.setString(2, dto.getEntidad().getClaveUsuario());
            rs = cs.executeQuery();

            while (rs.next()) {
                contador = contador + 1;
                dto.getEntidad().setNombreUsuario(rs.getString("nombreUsuario"));
                dto.getEntidad().setClaveUsuario(rs.getString("claveUsuario"));
            }
            if (contador == 1) {
                
                return 1;
                
            } else {
                
                return 0;
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
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
            dto.getEntidad().setIdUsuario(rs.getInt("idUsuario"));
            
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setMaterno(rs.getString("materno"));
            dto.getEntidad().setEmail(rs.getString("email"));
            dto.getEntidad().setNombreUsuario(rs.getString("nombreUsuario"));
            dto.getEntidad().setClaveUsuario(rs.getString("claveUsuario"));
            dto.getEntidad().setTipoUsuario(rs.getString("tipoUsuario"));//este cambiarlo
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setIdUsuario(1);
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
