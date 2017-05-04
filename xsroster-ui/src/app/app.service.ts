import { Injectable, OnInit, ViewContainerRef, OnDestroy } from '@angular/core';
import { Http } from "@angular/http";
import { Observer, Observable, Subject, Subscription } from "rxjs";
import * as _ from "lodash";
import {ViewChildren, ViewChild} from "@angular/core/src/metadata/di";

@Injectable()
export class AppService implements OnInit, OnDestroy{
    private _global;
    subscription:Subscription;

    constructor(public $http:Http) {
        this.subscription = this.globalSet$.subscribe(obj => {
            console.log("globalset subscribe ",obj);
            this._global = obj;
            console.log("globalafterset",this._global);
        });
    }

    get global() {
        return this._global;
    }

    set global(value) {
        this._global = value;
    }

    // Observable string sources
    private setMessageSource = new Subject<string>();
    private setGlobalSource = new Subject<string>();

    // Observable string streams
    messageSet$ = this.setMessageSource.asObservable();
    globalSet$ = this.setGlobalSource.asObservable();

    // Service message commands
    setMessage(msg: any) {
        console.log("in set message",msg);
        this.setMessageSource.next(msg);
    }
    setGlobal(object: any) {
        // if(this._global){
        //
        //     let globalClone = _.cloneDeep(this._global);
        //     _.merge(globalClone, object);
        //     console.log("globalClone",globalClone);
        //     this.setGlobalSource.next(globalClone);
        // }else{
            this.setGlobalSource.next(object);
        // }
    }


    ngOnInit(): void {
        console.log("in appservice on init before hhtp");
    }
    // getUserObservable():Observable<User>{
    //     return Observable.create(()=>{
    //         return this._user;
    //     })
    // }
    // setMessag(show, msg){
    //     this.messaging.showMessageBlock = show;
    //     this.messaging.msg = msg;
    // }

/*    confirm(confirmparameters){
        this.config.viewContainerRef = this.viewContainerRef;
        this.dialogRef = this.dialog.open(ConfirmComponent, this.config);
        this.dialogRef.componentInstance.parameters = confirmparameters;
        return this.dialogRef;
    }*/
    ngOnDestroy() {
        // prevent memory leak when component destroyed
        this.subscription.unsubscribe();
    }
    param(filter){
        let filterMaped = Object.keys(filter).map((key)=>{
            if(filter[key]){
                return encodeURIComponent(key) + '=' + encodeURIComponent(filter[key]);
            }
        })
        let filterCleared = _.compact(filterMaped);
        return filterCleared.join("&");
    }
}
