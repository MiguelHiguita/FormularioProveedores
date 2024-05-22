package com.example.backproveedores.servicios;

import com.example.backproveedores.helpers.ValidarProveedor;
import com.example.backproveedores.modelos.Proveedor;
import com.example.backproveedores.repositorios.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServicio {
    @Autowired
    ValidarProveedor validarProveedor;
    @Autowired
    ProveedorRepositorio proveedorRepositorio;

    public Proveedor guardarProveedor(Proveedor datosProveedor) throws Exception{
        try{
            if (validarProveedor.validarNombre(datosProveedor.getNombre())==false){
                throw new Exception("Verifique el nombre ingresado");
            }
            if (validarProveedor.validarDocumento(datosProveedor.getDocumento())==false){
                throw new Exception("Verifique el documento ingresado");
            }
            if (validarProveedor.validarRepresentante(datosProveedor.getRepresentante())==false){
                throw new Exception("Verifique el nombre ingresado");
            }
            if (validarProveedor.validarTelefono(datosProveedor.getTelefono())==false){
                throw new Exception("Verifique el teléfono ingresado");
            }
            if (validarProveedor.validarEmail(datosProveedor.getEmail())==false){
                throw new Exception("Verifique el email ingresado");
            }
            if (validarProveedor.validarDireccion(datosProveedor.getDireccion())==false){
                throw new Exception("Verifique la dirección ingresada");
            }
            if (validarProveedor.validarPersoneria(datosProveedor.getPersoneria())==false){
                throw new Exception("Verifique la personería ingresada");
            }
            if (validarProveedor.validarPais(datosProveedor.getPais())==false){
                throw new Exception("Verifique el país ingresado");
            }
            if (validarProveedor.validarCiudad(datosProveedor.getCiudad())==false){
                throw new Exception("Verifique la Ciudad ingresada");
            }
            if (validarProveedor.validarDepartamento(datosProveedor.getDepartamento())==false){
                throw new Exception("Verifique el departamento ingresado");
            }
            return proveedorRepositorio.save(datosProveedor);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Proveedor buscarProveedorPorId(Integer idProveedor) throws Exception{
        try {
            if (proveedorRepositorio.findById(idProveedor).isPresent()){
                return proveedorRepositorio.findById(idProveedor).get();
            }else{
                throw new Exception("Proveedor no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Proveedor> buscarTodosLosProveedores() throws Exception{
        try{
            return proveedorRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
