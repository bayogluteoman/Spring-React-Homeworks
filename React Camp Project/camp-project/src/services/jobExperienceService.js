import axios from "axios"

export default class JobExperienceService{
    getJobExperince(id){
        return axios.get("http://localhost:8080/api/jobExperiences/getAllByReverseSortJobExperience?candidateId="+id)
    }
}