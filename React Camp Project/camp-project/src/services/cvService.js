import axios from "axios"

export default class CvService{
    getCv(id){
        return axios.get("http://localhost:8080/api/cv/getByCandidateId?candidateId="+id)
    }
}