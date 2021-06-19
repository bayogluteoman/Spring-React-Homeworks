import axios from "axios"

export default class JobPositionService{
    getCandidate(){
        return axios.get("http://localhost:8080/api/jobPosition/getall")
    }
}