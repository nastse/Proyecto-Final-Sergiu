package com.demo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="review")
public class Products {

	@Column(name="id_rev")
	@Id
	@GeneratedValue //PARA DECIR QUE ES AUTOINCREMENTADO
	private int id_rev;
	
	@Column(name="imagen")
	private String imagen;
	
	//@ManyToOne
	//@JoinColumn(name="id_usser")
	@Column(name="id_user")
	private int id_user;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="talla")
	private String talla;
	
	@Column(name="peso")
	private int peso;
	
	@Column(name="altura")
	private int altura;
	
	@Column(name="temp_max")
	private int temp_max;
	
	@Column(name="temp_min")
	private int temp_min;
	
	@Column(name="ajuste")
	private int ajuste;
	
	@Column(name="creado")
	private Date creado;
	
	@Column(name="estado")
	private int estado;

	public int getId_rev() {
		return id_rev;
	}

	
	public void setId_rev(int id_rev) {
		this.id_rev = id_rev;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(int temp_max) {
		this.temp_max = temp_max;
	}

	public int getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(int temp_min) {
		this.temp_min = temp_min;
	}

	public int getAjuste() {
		return ajuste;
	}

	public void setAjuste(int ajuste) {
		this.ajuste = ajuste;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	

}
