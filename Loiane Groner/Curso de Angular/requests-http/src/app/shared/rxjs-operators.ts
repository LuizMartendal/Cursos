import { HttpEvent, HttpEventType, HttpResponse } from '@angular/common/http';
import { pipe } from "rxjs";
import { filter, map, tap } from 'rxjs/operators';

export function filterResponse<T>() {
  return pipe(
    filter((event: HttpEvent<T>) => event.type === HttpEventType.Response),
    map(res => (res: HttpResponse<T>) => res.body)
  );
}

export function uploadProgress<T>(cb: (progress: number) => void) {
  return tap((event: HttpEvent<T>) => {
    if (event.type === HttpEventType.UploadProgress) {
      let eventTotal : any;
      if (event.total != undefined){
        eventTotal = event.total;
      }
      cb(Math.round((event.loaded * 100) / eventTotal));
    }
  });
}
