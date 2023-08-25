import { ActivatedRoute } from '@angular/router';
import { AlertModalService } from './../../shared/alert-modal.service';
import { CursosService } from './../cursos.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common'
import { take } from 'rxjs';

@Component({
  selector: 'app-cursos-form',
  templateUrl: './cursos-form.component.html',
  styleUrls: ['./cursos-form.component.scss']
})
export class CursosFormComponent implements OnInit{

  form: any;
  submitted: boolean = false;

  constructor(private fb: FormBuilder,
              private service: CursosService,
              private alertService: AlertModalService,
              private localtion: Location,
              private route: ActivatedRoute
  ){ }

  ngOnInit(): void {
    /*this.route.params.subscribe(
      (params: any) => {
        const id = params['id'];
        const curso$ = this.service.loadById(id);
        curso$.subscribe(curso => {
          this.updateForm(curso)
        })
      }
    )*/

    const curso = this.route.snapshot.data['curso'];

    this.form = this.fb.group({
      id: [curso.id],
      nome: [curso.nome, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]]
    })


  }
  /*
  updateForm(curso: any){
    this.form.patchValue({
      id: curso.id,
      nome: curso.nome,
    });
  }*/

  onSubmit(){
    this.submitted = true;
    if (this.form.valid) {

      let msgSuccess = 'Curso atualizado com sucesso!';
      let msgError = 'Erro ao atualizar curso!';
      if (!this.form.value.id) {
        msgSuccess = 'Curso criado com sucesso!';
        msgError = 'Erro ao criar curso!';
      }

      this.service.save(this.form.value).subscribe(
        (success: any) => {
          this.alertService.showAlertSuccess(msgSuccess),
          this.localtion.back();
        },
        (error: any) => {
          this.alertService.showAlertDanger("Erro ao atualizar curso, tente novamente.");
        }
      )

      /*if (this.form.value.id) {
        this.service.update(this.form.value).subscribe(
          success => {
            this.alertService.showAlertSuccess("Curso atualizado com sucesso"),
            this.localtion.back();
          },
          error => this.alertService.showAlertDanger("Erro ao atualizar curso, tente novamente.")
        );
      } else {
        this.service.create(this.form.value).subscribe(
        success => {
          this.alertService.showAlertSuccess("Curso criado com sucesso"),
          this.localtion.back();
        },
        error => this.alertService.showAlertDanger("Erro ao criar curso, tente novament.")
        );
      }*/
    }
  }

  onCancel(){
    this.submitted = false;
    this.form.reset();
    this.localtion.back();
  }

  hasError(field: string){
    return this.form.get(field).erros;
  }
}
