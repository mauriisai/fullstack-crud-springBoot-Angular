import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { subscribeOn } from 'rxjs';
import { Empleado } from 'src/app/clase/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-registrar-empleado',
  templateUrl: './registrar-empleado.component.html',
  styleUrls: ['./registrar-empleado.component.css']
})
export class RegistrarEmpleadoComponent implements OnInit {
  
  empleado: Empleado = new Empleado();
  constructor(private empleadoServicio:EmpleadoService, private router:Router){}

  ngOnInit(): void {
  }

  guardarEmpleado(){
      this.empleadoServicio.registrarEmpleado(this.empleado).subscribe(dato => {
      console.log(dato);
      this.redirigirirAListaEmpleados(); 
    }, error => console.log(error));
  }

  redirigirirAListaEmpleados(){
    this.router.navigate(['/empleados']);
  }

}

