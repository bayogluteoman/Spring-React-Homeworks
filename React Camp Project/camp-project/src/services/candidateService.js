import axios from "axios"

export default class CandidateService{
    getCandidate(){
        return axios.get("http://localhost:8080/api/candidates/getall")
    }
}