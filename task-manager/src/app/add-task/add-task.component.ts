import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import {NgForm} from '@angular/forms';
import { Task } from 'src/app/model/Task.model';
import { AddTaskService } from 'src/app/add-task/add-task.service';
import { GenericResponse } from 'src/app/model/GenericResponse.model';


@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  constructor(private addService:AddTaskService) { }


  taskObj:Task;
//AddTaskService  
  task:String;
  range:number = 0;
  parentTask:String;
  startDate:String;
  endDate:String;

  myvar:String;
  res:GenericResponse;
  errorMsg:String;

createTask(){
  this.taskObj=new Task(this.task,this.range,this.parentTask, this.startDate,this.endDate);
      console.log(this.taskObj);
  this.addService.createTask(this.taskObj)    
  .subscribe(e=>{
    this.res = e;     
    console.log(this.res);
    alert(this.res.msg);
    this.errorMsg=this.res.errorMsg;
 });


  /*this.addService.getContacts().subscribe(e=>{
    this.myvar = e;console.log(this.myvar);
  });*/

}

reset(){
  this.task="";
  this.range=0;
  this.parentTask="";
  this.startDate="";
  this.endDate="";
}





  

  onSubmit(f: NgForm) {
    console.log(f.value);  // { first: '', last: '' }
    console.log(f.valid);  // false
  }


  ngOnInit() {}

}
