export class EditTask{

    constructor(private taskId: number,
        private task:String,
        private range:number,
        private parentTask:String,
        private startDate:String,
        private endDate:String){}
 
}