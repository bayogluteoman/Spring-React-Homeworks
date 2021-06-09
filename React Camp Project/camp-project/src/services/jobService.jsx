import axios from 'axios'

export default class jobService {
    getJobs(){
        return axios.get("http://localhost:8080/api/jobAdvertisement/getall")
    }
}
