import { HttpClient } from '@angular/common/http';
import { map, Observable, tap, filter, debounceTime, distinctUntilChanged, switchMap } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-lib-search',
  templateUrl: './lib-search.component.html',
  styleUrls: ['./lib-search.component.scss']
})

export class LibSearchComponent implements OnInit{
  queryField = new FormControl();

  readonly SEARCH_URL = 'https://api.cdnjs.com/libraries';
  results$: Observable<any> | undefined;
  total: any;
  FIELDS = '?fields=name,description,version,homepage&search=';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.results$ = this.queryField.valueChanges
    .pipe(
      map(value => value.trim()),
      filter(value => value.lenght > 1),
      debounceTime(200),
      distinctUntilChanged(),
      switchMap(value => this.http.get(this.SEARCH_URL, {
        params: {
          search: value,
          fields: this.FIELDS
        }
      })),
      tap((res: any) => this.total = res.total),
      map((res: any) => res.results)
    )
  }

  onSearch(){
    let value = this.queryField.value;

    if (value && value.trim() !== '') {
      value = value.trim();
    }

    this.results$ = this.http.get(this.SEARCH_URL + '?fields=name,description,version,homepage&search=' + value)
    .pipe(
      tap((res: any) => this.total = res.total),
      map((res: any) => res.results)
    )
  }
}
