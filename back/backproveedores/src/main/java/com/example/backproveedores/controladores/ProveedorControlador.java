package com.example.backproveedores.controladores;

import com.example.backproveedores.modelos.Proveedor;
import com.example.backproveedores.servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/proveedor")
public class ProveedorControlador {

    @Autowired
    ProveedorServicio proveedorServicio;

    @PostMapping
    public ResponseEntity<?> guardarProveedor(@RequestBody Proveedor datosProveedor){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedorServicio.guardarProveedor(datosProveedor));
        }catch (Exception error){
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarProveedores(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedorServicio.buscarTodosLosProveedores());
        }catch (Exception error){
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarProveedorPorId(@PathVariable Integer id) throws Exception {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedorServicio.buscarProveedorPorId(id));
        }catch (Exception error){
            Map<String,Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }
}
