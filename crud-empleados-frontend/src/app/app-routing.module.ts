import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaEmpleadosComponent } from './components/lista-empleados/lista-empleados.component';
import { RegistrarEmpleadoComponent } from './components/registrar-empleado/registrar-empleado.component';
import { ActualizarEmpleadoComponent } from './components/actualizar-empleado/actualizar-empleado.component';
import { EmpleadoDetallesComponent } from './components/empleado-detalles/empleado-detalles.component';

const routes: Routes = [
  { path: 'empleados', component:ListaEmpleadosComponent},
  { path: '', redirectTo:'empleados', pathMatch:'full'},
  { path: 'registrar-empleado', component:RegistrarEmpleadoComponent },
  { path : 'actualizar-empleado/:id',component : ActualizarEmpleadoComponent},
  { path : 'empleado-detalles/:id',component : EmpleadoDetallesComponent},
  { path: '**', redirectTo: 'empleados', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
