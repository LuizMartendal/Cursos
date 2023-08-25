import { InicioComponent } from './inicio/inicio.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: InicioComponent },
  {
    path: "cursos",
    loadChildren: () => import("../cursos/cursos.module").then(m => m.CursosModule)
  },
  {
    path: "rxjs-poc",
    loadChildren: () => import("../unsubscribe-rxjs/unsubscribe-rxjs.module").then(m => m.UnsubscribeRxjsModule)
  },
  {
    path: "upload",
    loadChildren: () => import("../upload-file/upload-file.module").then(m => m.UploadFileModule)
  },
  {
    path: 'reactive-search',
    loadChildren: () => import("../reactive-search/reactive-search.module").then(m => m.ReactiveSearchModule)
  },
  {
    path: 'inicio',
    loadChildren: () => import("../inicio/inicio.module").then(m => m.InicioModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InicioRoutingModule { }
