import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Empleado } from 'src/app/clase/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-empleado-detalles',
  templateUrl: './empleado-detalles.component.html',
  styleUrls: ['./empleado-detalles.component.css']
})
export class EmpleadoDetallesComponent implements OnInit {
  id: number;
  empleado:Empleado;

  constructor(private route:ActivatedRoute,private empleadoServicio:EmpleadoService){ }
  
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.empleado=new Empleado();
    this.empleadoServicio.obtenerEmpleadoPorId(this.id).subscribe(dato => {
      this.empleado=dato;
    });
  }
  
}
