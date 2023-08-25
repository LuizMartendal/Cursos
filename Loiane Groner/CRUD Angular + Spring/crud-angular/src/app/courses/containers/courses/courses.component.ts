import { ConfirmationDialogComponent } from './../../../shared/components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from '../../../shared/components/error-dialog/error-dialog.component';
import { CoursesService } from '../../services/courses.service';
import { Course } from '../../model/course';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { catchError, Observable, of, take } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit, OnDestroy{
  courses$: Observable<Course[]> | null = null;
  displayedColumns = ['name', 'category', 'actions'];
  errorDialogComponent: any;

  constructor(
    private coursesService: CoursesService,
    private router: Router,
    private route: ActivatedRoute,
    public dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {
    this.refresh();
  }

  ngOnDestroy(): void {

  }

  ngOnInit(): void {

  }

  refresh() {
    this.courses$ = this.coursesService.list().pipe(
      catchError((error) => {
        this.openDialog('Erro ao carregar cursos!');
        return of([]);
      })
    );
  }

  openDialog(msgError: string): void {
    this.dialog.open(ErrorDialogComponent, {
      data: msgError,
    });
  }

  onAdd() {
    this.router.navigate(['new-course'], { relativeTo: this.route });
  }

  onEdit(course: Course) {
    this.router.navigate(['edit-course/' + course.id], {
      relativeTo: this.route,
    });
  }

  onDelete(course: Course) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem certeza que deseja excluir o curso?'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.coursesService.delete(course).pipe(take(1)).subscribe({
          next: () => {
            this.openSnackBar('Curso excluído com sucesso!!');
            this.refresh();
          },
          error: () => {
            this.openSnackBar('Erro ao excluir curso!!');
          },
        });
      }
    });
  }

  openSnackBar(msg: string) {
    this.snackBar.open(msg, 'ok', { duration: 5000 });
  }
}
