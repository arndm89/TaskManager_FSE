import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule, Route } from '@angular/router';
import { AddTaskComponent } from './add-task/add-task.component';
import { ViewTaskComponent } from './view-task/view-task.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AddTaskService } from 'src/app/add-task/add-task.service';
import { ViewTaskService } from 'src/app/view-task/view-task.service';
import { EditTaskComponent } from './edit-task/edit-task.component';
import { EditTaskService } from 'src/app/edit-task/edit-task.service';

const routes: Route[] = [

  { path: 'addTask', component: AddTaskComponent},
  { path: 'viewTask', component: ViewTaskComponent},
  { path: 'editTask', component: EditTaskComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    AddTaskComponent,
    ViewTaskComponent,
    EditTaskComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes), 
    FormsModule,
    HttpClientModule
  ],
  providers: [HttpClientModule, HttpClient, 
    AddTaskService,ViewTaskService,EditTaskService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
