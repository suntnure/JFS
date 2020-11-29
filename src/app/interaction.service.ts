import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InteractionService {
public id:any;
private _SelectedEditid=new BehaviorSubject(this.id);
 Editid$=this._SelectedEditid.asObservable();
  constructor() { }

  sendEditid(ID:number){
     this._SelectedEditid.next(ID);
  }
}
