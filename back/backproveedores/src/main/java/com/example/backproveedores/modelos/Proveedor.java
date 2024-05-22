package com.example.backproveedores.modelos;

import jakarta.persistence.*;

@Entity
@Table(name="proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;

    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;
    @Column(name = "documento", nullable = false, length = 11)
    private String documento;
    @Column(name = "representante", nullable = false, length = 40)
    private String representante;
    @Column(name = "telefono", nullable= false, length = 10)
    private String telefono;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "direccion", nullable = false, length = 40)
    private String direccion;
    @Column(name = "personeria", nullable = false, length = 10)
    private String personeria;
    @Column(name = "pais", nullable = false, length = 30)
    private String pais;
    @Column(name = "ciudad", nullable = false, length = 30)
    private String ciudad;
    @Column(name = "departamento", nullable = false,length = 30)
    private String departamento;


    public Proveedor(Integer id_proveedor, String nombre, String documento, String representante, String telefono, String email, String direccion, String personeria, String pais, String ciudad, String departamento) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.documento = documento;
        this.representante = representante;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.personeria = personeria;
        this.pais = pais;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPersoneria() {
        return personeria;
    }

    public void setPersoneria(String personeria) {
        this.personeria = personeria;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
