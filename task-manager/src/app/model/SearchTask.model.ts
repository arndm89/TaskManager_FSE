export class SearchTask{

    constructor(public task:String,
        public parentTask:String,
        public priorityFrom:number,
        public priorityTo:number,        
        public startDate:String,
        public endDate:String){}

}