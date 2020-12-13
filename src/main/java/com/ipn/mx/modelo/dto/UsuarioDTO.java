/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Usuario;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author kevyn
 */

public class UsuarioDTO{
    private Usuario entidad;

    public UsuarioDTO() {
        entidad = new Usuario();
    }
     public UsuarioDTO(Usuario entidad){
        this.entidad=entidad;
    }

    public Usuario getEntidad() {
        return entidad;
    }

    public void setEntidad(Usuario entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("clave user: ").append(getEntidad().getIdUsuario()).append("\n");
        sb.append("nombre: ").append(getEntidad().getNombre()).append("\n");
        sb.append("paterno: ").append(getEntidad().getPaterno()).append("\n");
        sb.append("materno: ").append(getEntidad().getMaterno()).append("\n");
        sb.append("email: ").append(getEntidad().getEmail()).append("\n");
        sb.append("nombre user: ").append(getEntidad().getNombreUsuario()).append("\n");
        sb.append("clave user: ").append(getEntidad().getClaveUsuario()).append("\n");
        sb.append("tipo user: ").append(getEntidad().getTipoUsuario()).append("\n");
        
        return sb.toString();
    }
    public static void main(String[] args) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setIdUsuario(1);
        dto.getEntidad().setNombre("kev");
        dto.getEntidad().setPaterno("cam");
        dto.getEntidad().setMaterno("sot");
        dto.getEntidad().setEmail("kevyn@gmail.com");
        dto.getEntidad().setNombreUsuario("user");
        dto.getEntidad().setClaveUsuario("clav");
        dto.getEntidad().setTipoUsuario("a");
        System.out.println(dto);
    }
    
}
