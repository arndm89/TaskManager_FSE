import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from 'src/app/model/Task.model';
import { GenericResponse } from 'src/app/model/GenericResponse.model';
import { SearchTask } from 'src/app/model/SearchTask.model';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
     // 'Authorization': 'my-auth-token'
    })
  };

@Injectable()
export class ViewTaskService{
   
    constructor(private http: HttpClient) { }
    urlSearch:String;
    params:HttpParams;
    taskId:number;

    holdTaskIdForEdit(taskId : number, choice:String): number{
        if(choice == "set")
            this.taskId = taskId;
        return this.taskId;
    }

    searchTask (taskObject: SearchTask): Observable<any> {
        return this.http.get<any>('http://localhost:4545/searchTask',
            {params:{
                "task":<string> taskObject.task,
                "parentTask":<string> taskObject.parentTask,
                "priorityFrom": ''+taskObject.priorityFrom,
                "priorityTo": ''+taskObject.priorityTo,
                "startDate":<string> taskObject.startDate,
                "endDate":<string> taskObject.endDate

            }});
    }

    deleteTask (taskId: number): Observable<any> {
        return this.http
            .delete<any>('http://localhost:4545/deleteTask/'+taskId+'');
    }
}