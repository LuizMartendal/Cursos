import { Subscription } from 'rxjs';
import { UploadFileService } from './../upload-file.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { EventType } from '@angular/router';
import { HttpEventType } from '@angular/common/http';
import { filterResponse, uploadProgress } from 'src/app/shared/rxjs-operators';

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.scss']
})

export class UploadFileComponent implements OnInit, OnDestroy{

  inscricao: Subscription[] = [];
  progress = 0;
  constructor(private service: UploadFileService) {}

  ngOnDestroy(): void {
    this.inscricao.forEach(s => s.unsubscribe());
  }

  ngOnInit(): void {

  }

  files: Set<File> | undefined;

  onChange(event: any) {
    console.log(event);

    const selectedFiles = <FileList>event.srcElement.files;
    //const fileName = selectedFiles[0].name;
    let input = document.getElementById('fileLabel');

    const fileNames = [];
    this.files = new Set();
    for (let i = 0; i<selectedFiles.length; i++){
      fileNames.push(selectedFiles[i].name);
      this.files.add(selectedFiles[i]);
    }
    if(input?.innerHTML != null) {
      input.innerHTML = "Arquivos selecionados: " + fileNames.join(', ');
    }

    this.progress = 0;
  }

  onUpload() {
    if (this.files && this.files.size > 0) {
      this.inscricao.push(this.service.upload(this.files, '/api/upload')
      .pipe(
        uploadProgress((progress: number) => {
          console.log(progress);
          this.progress = progress;
        }),
        filterResponse()
      )
      .subscribe(response =>  console.log('Upload concluído!')));

      //.subscribe((event: any) => {
      //  console.log(event);
      //  if (event.type === HttpEventType.Response){
      //    console.log('Upload concluído!');
      //  }else if (event.type === HttpEventType.UploadProgress){
      //    const percentDone = Math.round((event.loaded * 100) / event.total);
      //    this.progress = percentDone;
      //  }
      //}));
    }
  }

  onDownloadExcel(){
    this.service.download('/api/downloadExcel')
    .subscribe((res: any) => {
      this.service.handleFile(res, 'report.xlsx');
    });
  }

  onDownloadPDF(){
    this.service.download('/api/downloadPDF')
    .subscribe((res: any) => {
      this.service.handleFile(res, 'report.pdf')
    })
  }
}
