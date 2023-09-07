package com.gestion.crudGestionEmpleado.controlador;

import com.gestion.crudGestionEmpleado.excepcion.ResourceNotFoundException;
import com.gestion.crudGestionEmpleado.modelo.Empleado;
import com.gestion.crudGestionEmpleado.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepositorio repositorio;

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados() {
        return repositorio.findAll();
    }

    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return repositorio.save(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = repositorio.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Empleado no existente"));
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleadoPorId(@PathVariable Long id, @RequestBody Empleado detalleEmpleado) {
        Empleado empleado = repositorio.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Empleado no existente"));

        empleado.setNombre(detalleEmpleado.getNombre());
        empleado.setApellido(detalleEmpleado.getApellido());
        empleado.setEmail(detalleEmpleado.getEmail());
        Empleado empleadoActualizado = repositorio.save(empleado);

        return ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        repositorio.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}