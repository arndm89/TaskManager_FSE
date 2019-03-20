import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from 'src/app/model/Task.model';
import { GenericResponse } from 'src/app/model/GenericResponse.model';
import { SearchTask } from 'src/app/model/SearchTask.model';
import { EditTask } from 'src/app/model/UpdateTask.model';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

@Injectable()
export class EditTaskService{
   
    constructor(private http: HttpClient) { }
    params:HttpParams;
    taskId:number;

    getTaskById (taskId: number): Observable<any> {
        return this.http.get<any>('http://localhost:4545/getTaskById',
            {
                params:{
                    "taskId": ''+taskId
            }
        });
    }

    updateTask (taskObject: EditTask): Observable<GenericResponse> {
        return this.http
            .put<GenericResponse>('http://localhost:4545/updateTask',taskObject, httpOptions);
    }
}