import { Component, OnInit, OnDestroy } from '@angular/core';
import { EnviarValorService } from '../enviar-valor.service';
import { tap, takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { __values } from 'tslib';

@Component({
  selector: 'app-poc-take-until',
  template: `
    <app-poc-base [nome]="nome"
      [valor]="valor" estilo="bg-primary">
    </app-poc-base>
  `
})
export class PocTakeUntilComponent implements OnInit, OnDestroy {

  nome = 'Componente com takeUntil';
  valor: string | undefined;

  unsub$ = new Subject();

  constructor(private service: EnviarValorService) {}

  ngOnInit() {
    this.service.getValor()
      .pipe(tap(v => console.log(this.nome, v)),
      takeUntil(this.unsub$))
      .subscribe((novoValor: string | undefined) => this.valor = novoValor);
  }

  ngOnDestroy() {
    this.unsub$.next((m: any) => console.log(m));
    this.unsub$.complete();
    console.log(`${this.nome} foi destruido`);
  }
}
