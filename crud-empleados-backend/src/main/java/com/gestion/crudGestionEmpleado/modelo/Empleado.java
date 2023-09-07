package com.gestion.crudGestionEmpleado.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nombre", length =60, nullable = false)
    String nombre;


    @Column(name = "apellido", length =60, nullable = false)
    String apellido;


    @Column(name = "email", length =60, nullable = false, unique = true)
    String email;

}

