import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from 'src/app/model/Task.model';
import { GenericResponse } from 'src/app/model/GenericResponse.model';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
     // 'Authorization': 'my-auth-token'
    })
  };

@Injectable()
export class AddTaskService{
   

    constructor(private http: HttpClient) { }
   
    public getContacts():Observable<any> {
        return this.http.get('http://localhost:4545/test');
        
    }
    createTask (taskObject: Task): Observable<GenericResponse> {
        return this.http
            .post<GenericResponse>('http://localhost:4545/createTask',taskObject, httpOptions);
    }


}