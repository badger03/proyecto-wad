package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
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
public class CategoriaDAO {

    private static final String SQL_INSERT = "insert into Categoria (nombreCategoria, descripcionCategoria) values(?,?)";
    private static final String SQL_UPDATE = "update Categoria set nombreCategoria=?, descripcionCategoria=? where idCategoria=?";
    private static final String SQL_DELETE = "delete from Categoria where idCategoria=?";
    private static final String SQL_SELECT = "select * from Categoria where idCategoria=?";
    private static final String SQL_SELECT_ALL = "select * from Categoria";
    private Connection con;

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
     /*public Connection obtenerConexion() {
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

    public void create(CategoriaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_INSERT);
            cs.setString(1, dto.getEntidad().getNombreCategoria());
            cs.setString(2, dto.getEntidad().getDescripcionCategoria());
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
     public void update(CategoriaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_UPDATE);
            cs.setString(1, dto.getEntidad().getNombreCategoria());
            cs.setString(2, dto.getEntidad().getDescripcionCategoria());
            cs.setInt(3, dto.getEntidad().getIdCategoria());
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
      public void delete(CategoriaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdCategoria());
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
      public CategoriaDTO read(CategoriaDTO dto) throws SQLException{
          obtenerConexion();
          CallableStatement cs = null;
          ResultSet rs = null;
          try{
              cs=con.prepareCall(SQL_SELECT);
              cs.setInt(1, dto.getEntidad().getIdCategoria());
              rs = cs.executeQuery();
              List resultados = obtenerResultados(rs);
              if(resultados.size()> 0 ){
                  return (CategoriaDTO)resultados.get(0);
              }else{
                  return null;
              }
          }finally{
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
       public List readAll() throws SQLException{
          obtenerConexion();
          CallableStatement cs = null;
          ResultSet rs = null;
          try{
              cs=con.prepareCall(SQL_SELECT_ALL);
              
              rs = cs.executeQuery();
              List resultados = obtenerResultados(rs);
              if(resultados.size()> 0 ){
                  return resultados;
              }else{
                  return null;
              }
          }finally{
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

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while(rs.next()){
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcionCategoria"));
            resultados.add(dto);
        }
        
        return resultados;
    }
}
