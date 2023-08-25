import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UnsubscribeRxjsRoutingModule } from './unsubscribe-rxjs-routing.module';
import { PocUnsubComponent } from './componentes/poc-unsub.component';
import { PocTakeUntilComponent } from './componentes/poc-take-until.component';
import { PocTakeComponent } from './componentes/poc-take.component';
import { PocComponent } from './componentes/poc.component';
import { PocBaseComponent } from './poc-base/poc-base.component';
import { PocAsyncComponent } from './componentes/poc-async.component';
import { UnsubscribePocComponent } from './unsubscribe-poc/unsubscribe-poc.component';

@NgModule({
  declarations: [
    UnsubscribePocComponent,
    PocAsyncComponent,
    PocBaseComponent,
    PocComponent,
    PocTakeComponent,
    PocTakeUntilComponent,
    PocUnsubComponent
  ],
  imports: [
    CommonModule,
    UnsubscribeRxjsRoutingModule
  ]
})
export class UnsubscribeRxjsModule { }
