import { CursoResolverGuard } from './guards/curso-resolver.guard';
import { CursosFormComponent } from './cursos-form/cursos-form.component';
import { CursosListaComponent } from '../cursos/cursos-lista/cursos-lista.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: "", component: CursosListaComponent},
  {
    path: "novo",
    component: CursosFormComponent,
    resolve: {
      curso: CursoResolverGuard
    }
  },
  {
    path: "editar/:id",
    component: CursosFormComponent,
    resolve: {
      curso: CursoResolverGuard
    }
  }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class CursosRoutingModule { }
