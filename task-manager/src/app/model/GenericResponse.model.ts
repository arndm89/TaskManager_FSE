export class GenericResponse{  [x: string]: any;

    
    constructor(public status:String,
        public msg:String,
        public errorMsg:String){}
}