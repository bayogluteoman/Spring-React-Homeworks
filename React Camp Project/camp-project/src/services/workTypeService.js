import axios from 'axios';


export default class WorkTypeService{
    getWorkType(){
        return axios.get("http://localhost:8080/workType/getAll")
    }
}