import { AlertModalService } from './../../shared/alert-modal.service';
import { AlertModalComponent } from './../../shared/alert-modal/alert-modal.component';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { CursosService } from './../cursos.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { catchError, Observable, of, Subject } from 'rxjs';
import { Curso } from '../curso';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cursos-lista',
  templateUrl: './cursos-lista.component.html',
  styleUrls: ['./cursos-lista.component.scss'],
  preserveWhitespaces: true
})
export class CursosListaComponent implements OnInit{

  @ViewChild('deleteModal') deleteModal: any;

  //bsModalRef: BsModalRef | undefined;
  deleteModalRef: BsModalRef | undefined;
  cursoSelecionado: Curso | undefined;
  cursos$: Observable<Curso[]> | undefined;
  error$ = new Subject<boolean>();

  constructor(private service: CursosService,
              private modalService: BsModalService,
              private alertService: AlertModalService,
              private router: Router,
              private route: ActivatedRoute
  ){ }

  ngOnInit(): void {
    this.onRefresh();
  }

  onRefresh(){
    this.cursos$ = this.service.list()
    .pipe(
      catchError(error => {
        console.log(error);
        this.handleError();
        //this.error$.next(true)
        return of();
      })
    );
  }

  handleError(){
    this.alertService.showAlertDanger("Erro ao carregar cursos. Tente novamente mais tarde...");
  }

  onEdit(id: any){
    this.router.navigate(['editar', id], {relativeTo: this.route})
  }

  onDelete (curso: any) {
    this.cursoSelecionado = curso;
    this.deleteModalRef = this.modalService.show(this.deleteModal, {class: 'modal-sm'})
  }

  onConfirmDelete () {
    this.service.remove(this.cursoSelecionado?.id)
    .subscribe(
      success => this.alertService.showAlertSuccess("Curso removido com sucesso!"),
      error => this.alertService.showAlertDanger("Erro ao remover curso!")
    );
    this.deleteModalRef?.hide();
    this.onRefresh();
  }

  onDeclineDelete () {
    this.deleteModalRef?.hide();
  }
}
