import React, { useState ,useEffect} from "react";
import { useParams } from "react-router";
import { Button, Card } from 'semantic-ui-react'
import JobAdvertisementService from "../services/jobAdvertisementService";

export default function ProductDetails() {
  let { id } = useParams();

  const [jobAdvertisement, setJobAdvertisement] = useState({});

  useEffect(()=>{
    let jobAdvertisementService = new JobAdvertisementService()
    jobAdvertisementService.getByJodAdvertisementId(id).then(result=>setJobAdvertisement(result.data.data))
  },[])


  return (
    <div>
      <Card.Group>
        <Card fluid>
          <Card.Content>
        
            <Card.Header>{jobAdvertisement.employer?.companyName}</Card.Header>
            <Card.Meta>{jobAdvertisement.city?.cityName}</Card.Meta>
            <Card.Description>
              Publish Date:{jobAdvertisement.publishDate}<br></br>
             
              Company Name:{jobAdvertisement.employer?.companyName}<br></br>
              Web page : {jobAdvertisement.employer?.webPage}<br></br>
              Telephone number :{jobAdvertisement.employer?.telephoneNumber}<br></br>
              E-mail :{jobAdvertisement.employer?.email}<br></br><br></br>
              Job name:{jobAdvertisement.job?.name}<br></br>
              Job Position:{jobAdvertisement.job?.position}<br></br>
              Job Description : {jobAdvertisement.jobDescription}<br></br>
              City name :{jobAdvertisement.city?.cityName}<br></br>
              Wage:{jobAdvertisement.minWage}-{jobAdvertisement.maxWage}<br></br>
              Number of Position:{jobAdvertisement.numberOfPosition}<br></br>
              Last Apply Date:{jobAdvertisement.lastApplyDate}<br></br>
            </Card.Description>
          </Card.Content>
          <Card.Content extra>
            <div className="ui two buttons">
              <Button basic color="green">
                Approve
              </Button>

            </div>
          </Card.Content>
        </Card>
      </Card.Group>
    </div>
  );
}