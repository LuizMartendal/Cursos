import { Component, OnInit, OnDestroy } from '@angular/core';
import { EnviarValorService } from '../enviar-valor.service';

@Component({
  selector: 'app-poc-take',
  template: `
    <app-poc-base [nome]="nome"
      [valor]="valor" estilo="bg-info">
    </app-poc-base>
  `
})
export class PocTakeComponent implements OnInit, OnDestroy {

  nome = 'Componente com take';
  valor: string | undefined;
  valor$: any;

  constructor(private service: EnviarValorService) {}

  ngOnInit() {
    this.valor$ = this.service.getValor()
    this.valor$.subscribe((novoValor: any) => this.valor = novoValor)
  }

  ngOnDestroy() {
    console.log(`${this.nome} foi destruido`);
  }
}
