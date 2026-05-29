package com.example.demo.dto;

import java.time.LocalDate;

public class VehiculoDTO {

	private String serie;
	private String descripcion;
	private LocalDate fechacompra;
	private Integer marcarId;
	
	public String getSerie() {
		return serie;
	}
	
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public LocalDate getFechacompra() {
		return fechacompra;
	}
	
	public void setFechacompra(LocalDate fechacompra) {
		this.fechacompra = fechacompra;
	}
	
	public Integer getMarcarId() {
		return marcarId;
	}
	
	public void setMarcarId(Integer marcarId) {
		this.marcarId = marcarId;
	}
	
}
