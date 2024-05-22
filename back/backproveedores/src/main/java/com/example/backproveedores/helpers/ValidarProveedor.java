package com.example.backproveedores.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidarProveedor {

    private ValidarPatron validarPatron=new ValidarPatron();

    public boolean validarNombre(String nombre)throws Exception{
        String regex = "^[a-zA-ZÀ-ÿ'´`]{1,40}( [a-zA-ZÀ-ÿ'´`]{1,40})*$";
        if (this.validarPatron.validarPatron(nombre,regex)==false){
            throw new Exception("Verifica el nombre ingresado");
        }
        return true;
    }
    public boolean validarDocumento(String documento)throws Exception{
        String regex = "^\\d{6,10}$";
        if (this.validarPatron.validarPatron(documento,regex)==false){
            throw new Exception("Verifica el documento ingresado");
        }
        return true;
    }
    public boolean validarRepresentante(String representante)throws Exception{
        String regex = "^[a-zA-ZÀ-ÿ'´`]{1,40}( [a-zA-ZÀ-ÿ'´`]{1,40})*$";
        if (this.validarPatron.validarPatron(representante,regex)==false){
            throw new Exception("Verifica el nombre ingresado");
        }
        return true;
    }
    public boolean validarTelefono(String telefono)throws Exception{
        String regex = "^\\d{10}$";
        if (this.validarPatron.validarPatron(telefono,regex)==false){
            throw new Exception("Verifica el telefono ingresado");
        }
        return true;
    }
    public boolean validarEmail(String email)throws Exception{
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (this.validarPatron.validarPatron(email,regex)==false){
            throw new Exception("Verifica el email ingresado");
        }
        return true;
    }
    public boolean validarDireccion(String direccion)throws Exception{
        String regex = "^[a-zA-Z0-9\\s#-.áéíóúÁÉÍÓÚ]+$";
        if (this.validarPatron.validarPatron(direccion,regex)==false){
            throw new Exception("Verifica la dirección ingresada");
        }
        return true;
    }
    public boolean validarPersoneria(String personeria)throws Exception{
        String regex = "^(Natural|Juridica)$";
        if (this.validarPatron.validarPatron(personeria,regex)==false){
            throw new Exception("Verifica la personería ingresado");
        }
        return true;
    }
    public boolean validarPais(String pais)throws Exception{
        String regex = "^[a-zA-ZÀ-ÿ'´`]{1,40}( [a-zA-ZÀ-ÿ'´`]{1,40})*$";
        if (this.validarPatron.validarPatron(pais,regex)==false){
            throw new Exception("Verifica el país ingresado");
        }
        return true;
    }
    public boolean validarCiudad(String ciudad)throws Exception{
        String regex = "^[a-zA-ZÀ-ÿ'´`]{1,40}( [a-zA-ZÀ-ÿ'´`]{1,40})*$";
        if (this.validarPatron.validarPatron(ciudad,regex)==false){
            throw new Exception("Verifica la ciudad ingresada");
        }
        return true;
    }
    public boolean validarDepartamento(String departamento)throws Exception{
        String regex = "^[a-zA-ZÀ-ÿ'´`]{1,40}( [a-zA-ZÀ-ÿ'´`]{1,40})*$";
        if (this.validarPatron.validarPatron(departamento,regex)==false){
            throw new Exception("Verifica el departamento ingresado");
        }
        return true;
    }


}
