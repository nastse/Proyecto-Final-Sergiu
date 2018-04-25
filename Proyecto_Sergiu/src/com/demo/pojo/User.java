package com.demo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

//Mapeo hacia la Tabla Usuario de mi BDDA
@Entity
@Table(name="usuario")
public class User {

	
	@Id
	//@OneToMany(mappedBy="review")
	@GeneratedValue //PARA DECIR QUE ES AUTOINCREMENTADO
	@Column(name="id_usuario")
	private int id_usuario;
	
	@NotBlank(message="El email no puede estar vacio")
	@Email(message="Email incorrecto")
	@Column(name="email")
	private String email;
	
	@Size(min=5)
	@Column(name="password")
	private String password;
	
	@Size(min=5)
	@Column(name="repassword")
	private String repassword;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="peso")
	private int peso;
	
	@Column(name="altura")
	private int altura;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="tipo_usuario")
	private int tipo_usuario;
	
	@Column(name="estado")
	private int estado;
	
	@Column(name="creado")
	private Date creado;
	
	@Column(name="imagen")
	private String imagen;
	

	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getCreado() {
		return creado;
	}
	public void setCreado(Date creado) {
		this.creado = creado;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
	
	
}
