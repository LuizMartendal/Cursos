import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-poc-base',
  templateUrl: './poc-base.component.html',
  styleUrls: ['./poc-base.component.scss']
})
export class PocBaseComponent implements OnInit {

  @Input() nome: string | undefined;
  @Input() valor: string | undefined | null;
  @Input() estilo: string | undefined;

  constructor() { }

  ngOnInit() {
  }

}
