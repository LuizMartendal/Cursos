import { CourseResolver } from './guards/course.resolver';
import { CoursesFormComponent } from './containers/courses-form/courses-form.component';
import { CoursesComponent } from './containers/courses/courses.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: CoursesComponent
  },
  {
    path: 'new-course',
    component: CoursesFormComponent,
    resolve: { course: CourseResolver }
  },
  {
    path: 'edit-course/:id',
    component: CoursesFormComponent,
    resolve: { course: CourseResolver }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoursesRoutingModule { }
