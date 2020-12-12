/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Producto;

/**
 *
 * @author kevyn
 */
public class ProductoDTO {
    private Producto entidad;
    public ProductoDTO() {
        entidad=new Producto();
    }
    public ProductoDTO(Producto entidad){
        this.entidad=entidad;
    }

    public Producto getEntidad() {
        return entidad;
    }

    public void setEntidad(Producto entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id producto: ").append(getEntidad().getIdProducto()).append("\n");
        sb.append("nombre producto: ").append(getEntidad().getNombreProducto()).append("\n");
        sb.append("descripcion producto: ").append(getEntidad().getDescripcionProducto()).append("\n");
        sb.append("precio producto: ").append(getEntidad().getPrecio()).append("\n");
        sb.append("existencia producto: ").append(getEntidad().getExistencia()).append("\n");
        sb.append("id categoria producto: ").append(getEntidad().getIdCategoria()).append("\n");
        return sb.toString();
    }

   
    public static void main(String[] args){
        ProductoDTO dto = new ProductoDTO();
        dto.getEntidad().setIdProducto(1);
        dto.getEntidad().setNombreProducto("fifa 20");
        dto.getEntidad().setDescripcionProducto("juego futbol");
        dto.getEntidad().setPrecio(1500);
        dto.getEntidad().setExistencia(10);
        dto.getEntidad().setIdCategoria(1);
       
        System.out.println(dto);
    }
}
