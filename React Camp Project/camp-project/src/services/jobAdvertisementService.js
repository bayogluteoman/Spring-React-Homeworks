import axios from "axios"

export default class JobAdvertisementService{
    getJobAdvertisement(){
        return axios.get("http://localhost:8080/api/jobadvertisements/getAll")
    }

    getByJodAdvertisementId(id){
        return axios.get("http://localhost:8080/api/jobadvertisements/getByJobAdvertisementId?jobAdvertisementId="+id)
    }
    addJobAdvertisement(JobAdvertisement){
        return axios.post("http://localhost:8080/api/jobadvertisements/add",JobAdvertisement)
    }

    getNotActivated(){
        return axios.get("http://localhost:8080/api/jobadvertisements/getAllNotActivated")
    }

    activate(id){
        return axios.put("http://localhost:8080/api/jobadvertisements/activate?activationStatus=true&id="+id)
    }
}