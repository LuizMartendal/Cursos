import { HttpClient } from '@angular/common/http';
import { Component, NgModule } from '@angular/core';
import { map } from 'rxjs';

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
  styleUrls: ['./template-form.component.css']
})
export class TemplateFormComponent {

  constructor(private http: HttpClient){

  }

  usuario: any = {
    nome: "",
    email: ""
  }

  onSubmit(form: any){
    console.log(form)

    this.http.post('https://httpbin.org/post', JSON.stringify(form.value)).pipe().subscribe(dados => console.log(dados));
  }

  consultaCep(cep: any, form: any){
    cep = cep.replace(/\D/g, '');

    if (cep != ""){

      var validacep = /^[0-9]{8}$/;

      if(validacep.test(cep)){
        this.http.get("//viacep.com.br/ws/"+ cep + "/json")
        .pipe()
        .subscribe((dados: any) => this.populaDadosForm(dados, form));
      }
    }
  }

  populaDadosForm(dados: any, form: any){
    form.setValue({
      nome: form.value.nome,
      email: form.value.email,
      endereco: {
        cep: dados.cep,
        numero: '',
        complemento: dados.complemento,
        rua: dados.logradouro,
        bairro: dados.bairro,
        cidade: dados.localidade,
        estado: dados.uf
      }
    });
  }
}
