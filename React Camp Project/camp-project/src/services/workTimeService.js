import axios from 'axios';


export default class WorkTimeService{
    getWorkTime(){
        return axios.get("http://localhost:8080/api/workTime/getAll")
    }
}