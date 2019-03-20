import { Component, OnInit } from '@angular/core';
import { ViewTaskService } from 'src/app/view-task/view-task.service';
import { EditTaskService } from 'src/app/edit-task/edit-task.service';
import { EditTask } from 'src/app/model/UpdateTask.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {
  
  constructor(private editService : EditTaskService, 
      private viewService: ViewTaskService,
    private router:Router) { }  

  task:String;
  range:number;
  parentTask:String;
  startDate:String;
  endDate:String;

  taskIdFOrEdit:number;
  taskObj:EditTask;

  ngOnInit() { 
    this.taskIdFOrEdit = this.viewService.holdTaskIdForEdit(0, "get");
    console.log(this.taskIdFOrEdit);

    this.editService
      .getTaskById(this.taskIdFOrEdit).subscribe(e=>{
      console.log(e);
      
      if(e.status == "SUCCESS"){        
        this.taskIdFOrEdit  = e.taskVO.taskId;
        this.task = e.taskVO.task;
        this.range = e.taskVO.priority;
        this.parentTask = e.taskVO.parentTask;
        this.startDate = e.taskVO.startDate;
        this.endDate = e.taskVO.endDate;
      }else{
        alert("Unable to fetch Task.");
      }     
   });
  }

  updateTask(){
    this.taskObj=new EditTask(this.taskIdFOrEdit, this.task,this.range,this.parentTask, this.startDate,this.endDate);
    // console.log(this.taskObj);
    this.editService.updateTask(this.taskObj)    
    .subscribe(e=>{           
      //console.log(e);
      alert(e.msg);      
   });
  }

  cancel(){
    this.router.navigate(['/viewTask']);
  }
}