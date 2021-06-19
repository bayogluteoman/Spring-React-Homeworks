import axios from 'axios';


export default class JobService{
    getJob(){
        return axios.get("http://localhost:8080/api/jobs/getall")
    }
}