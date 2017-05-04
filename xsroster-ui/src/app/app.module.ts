import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, FormGroup, FormGroupName, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule }   from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AppComponent } from './app.component';
import { MaterialModule, MdDialogConfig } from "@angular/material";
import { SlimLoadingBarModule } from "ng2-slim-loading-bar";
import { AppService } from "./app.service";


@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule.forRoot(),
    SlimLoadingBarModule.forRoot(),
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: '',
        redirectTo: '/studies',
        pathMatch: 'full'
      },
      {
        path: 'monitoring',
        redirectTo: '/monitoring/queues',
        pathMatch: 'full'
      },
      { 
        path: '**', 
        component: PageNotFoundComponent 
      }
    ],
    { useHash: true })
  ],
  entryComponents:[],
  providers: [
    AppService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
