import { Course } from '../../model/course';
import { ActivatedRoute } from '@angular/router';
import { CoursesService } from '../../services/courses.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-courses-form',
  templateUrl: './courses-form.component.html',
  styleUrls: ['./courses-form.component.scss']
})
export class CoursesFormComponent implements OnInit {

  form: FormGroup = this.formBuilder.group({
    id: [''],
    name: ['', [ Validators.required, Validators.minLength(2), Validators.maxLength(100) ]],
    category: ['', [ Validators.required ]]
  });

  private msg: string = ' ao criar o curso!!';

  public title: string = 'Adicionar curso';
  public buttonSubmit: string = 'Adicionar';

  constructor(private formBuilder: FormBuilder,
              private location: Location,
              private service: CoursesService,
              private snackBar: MatSnackBar,
              private route: ActivatedRoute)
  { }

  ngOnInit(): void {
    const course: Course = this.route.snapshot.data['course'];

    if (course.id) {
      this.msg = ' ao editar o curso!!';
      this.title = 'Editar curso';
      this.buttonSubmit = 'Editar';
    }

    this.form.setValue({
      id: course.id,
      name: course.name,
      category: course.category
    });
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe({
      next: () => { this.openSnackBar('Sucesso' + this.msg),
                    this.location.back()
                  },
      error: () => this.openSnackBar('Erro' + this.msg)
    });
  }

  onCancel() {
    this.location.back();
  }

  openSnackBar(msg: string) {
    this.snackBar.open(msg, 'ok', { duration: 5000 });
  }

  getErrorMessage(filedName: string) {
    const field = this.form.get(filedName);

    if (field?.hasError('required')) {
      return 'Campo obrigatório!'
    }

    if (field?.hasError('minlength')) {
      const requiredLength = field.errors ? field.errors['minlength']['requiredLength'] : 2;
      return `Campo deve ter pelo menos ${requiredLength} caracteres!`;
    }

    if (field?.hasError('maxlength')) {
      const requiredLength = field.errors ? field.errors['maxlength']['requiredLength'] : 2;
      return `Campo excedido com no máximo ${requiredLength} caracteres!`;
    }

    return 'Campo inválido!'
  }
}
