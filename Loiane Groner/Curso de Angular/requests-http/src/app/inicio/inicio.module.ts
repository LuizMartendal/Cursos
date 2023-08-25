import { UploadFileComponent } from './../upload-file/upload-file/upload-file.component';
import { UnsubscribePocComponent } from './../unsubscribe-rxjs/unsubscribe-poc/unsubscribe-poc.component';
import { AlertModalComponent } from './../shared/alert-modal/alert-modal.component';
import { LibSearchComponent } from './../reactive-search/lib-search/lib-search.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InicioRoutingModule } from './inicio-routing.module';
import { InicioComponent } from './inicio/inicio.component';


@NgModule({
  declarations: [
    InicioComponent
  ],
  imports: [
    CommonModule,
    InicioRoutingModule
  ]
})
export class InicioModule { }
