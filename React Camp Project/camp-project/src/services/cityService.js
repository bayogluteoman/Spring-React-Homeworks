import axios from 'axios'

export default class cityService{
    getCities(){
        return axios.get("http://localhost:8080/api/cities/getAll")

    }
}