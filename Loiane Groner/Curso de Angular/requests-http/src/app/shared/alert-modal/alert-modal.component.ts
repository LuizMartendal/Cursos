import { Component, Input } from '@angular/core';
import { BsModalService, BsModalRef} from 'ngx-bootstrap/modal'
@Component({
  selector: 'app-alert-modal',
  templateUrl: './alert-modal.component.html',
  styleUrls: ['./alert-modal.component.scss']
})
export class AlertModalComponent {

  @Input() message: string | undefined;
  @Input() type: string | undefined;

  constructor(public bsModalRef: BsModalRef){

  }

  onClose(){
    this.bsModalRef.hide();
  }
}
