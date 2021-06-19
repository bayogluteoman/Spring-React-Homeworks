import axios from "axios"

export default class EducationService{
    getEducation(id){
        return axios.get("http://localhost:8080/api/educations/getAllByReverseSortGraduate?candidateId="+id)
    }
}