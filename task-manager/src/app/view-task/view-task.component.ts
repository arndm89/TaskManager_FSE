import { Component, OnInit } from '@angular/core';
import { SearchTask } from 'src/app/model/SearchTask.model';
import { ViewTaskService } from 'src/app/view-task/view-task.service';
import { concat } from 'rxjs/operators';
import { Router } from '@angular/router';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {

  constructor(private viewService:ViewTaskService, private router: Router) { }

  task: String;
  parentTask: String;
  priorityFrom: number;
  priorityTo: number;
  startDate: String
  endDate: String;


  searchTask:SearchTask;
  searchTaskArray:SearchTask[];
  searchTableShow:boolean;
  searchTableFooterBoolean:boolean;
  urlSearch:String;
  params:HttpParams;

  ngOnInit() {
    this.searchTableShow = false;
  }
  search(){
    this.searchTableShow = true;
    this.task = this.task===undefined?"":this.task;
    this.parentTask = this.parentTask===undefined?"":this.parentTask;
    this.priorityFrom = this.priorityFrom===undefined?0:this.priorityFrom;
    this.priorityTo = this.priorityTo===undefined?0:this.priorityTo;
    this.startDate = this.startDate===undefined?null:this.startDate;
    this.endDate = this.endDate===undefined?null:this.endDate;

    this.searchTask = new SearchTask(this.task, this.parentTask,
      this.priorityFrom,this.priorityTo, 
      this.startDate, this.endDate);
      if(this.validateAllInputs(this.searchTask)){
        this.viewService.searchTask(this.searchTask)    
        .subscribe(e=>{
          this.searchTableFooterBoolean = e.searchVO.searchCount==0?true:false;
          this.searchTaskArray = e.searchVO.searchList;
         // console.log(this.searchTableFooterBoolean);
          //console.log(this.searchTaskArray);
       });
      } else {
        this.searchTaskArray = null;
        this.searchTableFooterBoolean = false;
        this.searchTableShow = false;
      }
    
  }

  editTask(taskId,task){
    this.viewService.holdTaskIdForEdit(taskId, "set");
    this.router.navigate(['/editTask',{"taskId" : taskId}]);   
  }

  deleteTask(taskId){
    this.viewService.deleteTask(taskId)    
    .subscribe(e=>{
     // console.log(e);
      if(e.status=="SUCCESS"){
        this.search();
      }
   });
  }

  validateAllInputs(searchTask : SearchTask){

    if(searchTask.task == "" 
        && searchTask.parentTask == ""
        && searchTask.priorityFrom == 0
        && searchTask.priorityTo == 0 
        && searchTask.startDate == null 
        && searchTask.endDate == null){
          return false;
    }
    return true;
  }

  numberOnly(event): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;
  }
}
