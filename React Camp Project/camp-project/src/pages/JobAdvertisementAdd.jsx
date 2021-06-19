import React, { useEffect, useState } from "react";
import { useFormik } from "formik";
import * as Yup from "yup";
import { Button, Dropdown, Input, TextArea, Card, Form, Grid, Label, Icon } from "semantic-ui-react";
import CityService from "../services/cityService";
import JobService from "../services/jobService";
import JobAdvertisementService from "../services/jobAdvertisementService";
import WorkTimeService from "../services/workTimeService";
import WorkTypeService from "../services/workTypeService";
import { useHistory } from 'react-router'


export default function JobAdvertisementAdd() {
  const history = useHistory()

  let jobAdvertisementService = new JobAdvertisementService();
  const JobAdvertAddSchema = Yup.object().shape({
    lastApplyDate: Yup.date().nullable().required("Bu alanın doldurulması zorunludur"),
    jobDescription: Yup.string().required("Bu alanın doldurulması zorunludur"),
    jobId: Yup.string().required("Bu alanın doldurulması zorunludur"),
    workTimeId: Yup.string().required("Bu alanın doldurulması zorunludur"),
    workTypeId: Yup.string().required("Bu alanın doldurulması zorunludur"),
    numberOfPosition: Yup.string().required("Posizyon sayısı zorunludur").min(1, "Posizyon sayısı 1 den küçük olamaz"),
    cityId: Yup.string().required("Bu alanın doldurulması zorunludur"),
    minWage: Yup.number().min(0, "0 Dan az olamaz").required("Bu alan zorunludur"),
    maxWage: Yup.number().min(0, "0 Dan az olamaz").required("Bu alan zorunludur")
  });

  const formik = useFormik({
    initialValues: {
      jobDescription: '',
      jobId: '',
      workTimeId: '',
      workTypeId: '',
      numberOfPosition: '',
      cityId: '',
      minWage: '',
      maxWage: '',
      lastApplyDate: '',
    },
    validationSchema: JobAdvertAddSchema,
    onSubmit: (values) => {
      values.employerId = 1;
      jobAdvertisementService.addJobAdvertisement(values).then((result) => console.log(result.data.data));
      alert("Succesfully added Job advertisement please wait for activation by admin.")
    },
  });

  const [cities, setCities] = useState([]);
  const [jobPositions, setJobPositions] = useState([]);
  const [workTimes, setWorkTimes] = useState([]);
  const [workTypes, setWorkTypes] = useState([]);

  useEffect(() => {
    let cityService = new CityService();
    let jobService = new JobService();
    let workTimeService = new WorkTimeService();
    let workTypeService = new WorkTypeService();

    workTimeService.getWorkTime().then((result) => setWorkTimes(result.data.data));
    workTypeService.getWorkType().then((result) => setWorkTypes(result.data.data));
    cityService.getCities().then((result) => setCities(result.data.data));
    jobService.getJob().then((result) => setJobPositions(result.data.data));
  }, []);

  const workTimeOption = workTimes.map((workTime, index) => ({
    key: index,
    text: workTime.workTime,
    value: workTime.id,
  }));
  const workTypeOption = workTypes.map((workType, index) => ({
    key: index,
    text: workType.workType,
    value: workType.id,
  }));
  const cityOption = cities.map((city, index) => ({
    key: index,
    text: city.cityName,
    value: city.id,
  }));
  const jobPositionOption = jobPositions.map((jobPosition, index) => ({
    key: index,
    text: jobPosition.position,
    value: jobPosition.id,
  }));

  const handleChangeSemantic = (value, fieldName) => {
    formik.setFieldValue(fieldName, value);
  }

  return (
    <div>
      <Card fluid>
        <Card.Content header='Add Job Advertisement' />
        <Card.Content>
          <Form onSubmit={formik.handleSubmit}>
            <Form.Field style={{ marginBottom: "1rem" }}>
              <Grid stackable>
                <Grid.Column width={8}>
                  <Label><Icon name="computer"> Job Position</Icon></Label>
                  <Dropdown
                    style={{ width: "100%" }}

                    clearable
                    item
                    placeholder="İş pozisyonu"
                    search
                    selection
                    onChange={(event, data) =>
                      handleChangeSemantic(data.value, "jobId")
                    }
                    onBlur={formik.onBlur}
                    id="jobId"
                    value={formik.values.jobId}
                    options={jobPositionOption}
                  />
                  {formik.errors.jobId && formik.touched.jobId && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.jobId}
                    </div>
                  )}
                </Grid.Column>
                <Grid.Column width={8}>
                  <Label><Icon name="home"> City</Icon></Label>

                  <Dropdown
                    style={{ width: "100%" }}

                    clearable
                    item
                    placeholder="Şehir"
                    search
                    selection
                    onChange={(event, data) =>
                      handleChangeSemantic(data.value, "cityId")
                    }
                    onBlur={formik.onBlur}
                    id="cityId"
                    value={formik.values.cityId}
                    options={cityOption}
                  />
                  {formik.errors.cityId && formik.touched.cityId && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.cityId}
                    </div>
                  )}
                </Grid.Column>
              </Grid>
            </Form.Field>

            <Form.Field>
              <Grid stackable>
                <Grid.Column width={8}> 
                  <Label><Icon name="briefcase"></Icon>Work Type</Label>

                  <Dropdown
                    style={{ width: "100%" }}
                    clearable
                    item
                    placeholder="Çalışma yeri"
                    search
                    selection
                    onChange={(event, data) =>
                      handleChangeSemantic(data.value, "workTypeId")
                    }
                    onBlur={formik.onBlur}
                    id="workTypeId"
                    value={formik.values.workTypeOfJobs}
                    options={workTypeOption}
                  />
                  {formik.errors.workTypeId && formik.touched.workTypeId && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.workTypeId}
                    </div>
                  )}
                </Grid.Column>
                <Grid.Column width={8}>
                <Label><Icon name="clock outline"> Work Time </Icon></Label>

                  <Dropdown
                    style={{ width: "100%" }}
                    clearable
                    item
                    placeholder="Çalışma Süresi"
                    search
                    selection
                    onChange={(event, data) =>
                      handleChangeSemantic(data.value, "workTimeId")
                    }
                    onBlur={formik.onBlur}
                    id="workTimeId"
                    value={formik.values.workTimeId}
                    options={workTimeOption}
                  />
                  {formik.errors.workTimeId && formik.touched.workTimeId && (
                    <div className={"ui pointing red basic label"}>{formik.errors.workTimeId}</div>
                  )}
                </Grid.Column>
              </Grid>
            </Form.Field>

            <Form.Field>
              <Grid stackable>
                <Grid.Column width={8}>
                <Label><Icon name="lira sign"> Minimum Wage </Icon></Label>

                  <Input
                    style={{ width: "100%" }}
                    type="number"
                    placeholder="Maaş aralığı MİNİMUM"
                    value={formik.values.minWage}
                    name="minWage"
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                  >
                  </Input>
                  {formik.errors.minWage && formik.touched.minWage && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.minWage}
                    </div>
                  )}
                </Grid.Column>
                <Grid.Column width={8}>
                <Label><Icon name="lira sign"> Maximum Wage </Icon></Label>
                  <Input
                    style={{ width: "100%" }}
                    type="number"
                    placeholder="Maaş aralığı MAKSİMUM"
                    value={formik.values.maxWage}
                    name="maxWage"
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                  >
                  </Input>
                  {formik.errors.maxWage && formik.touched.maxWage && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.maxWage}
                    </div>
                  )}
                </Grid.Column>
              </Grid>
            </Form.Field>

            <Form.Field>
              <Grid stackable>
                <Grid.Column width={8}>
                <Label><Icon name="numbered list"> Number Of Position </Icon></Label>

                  <Input
                    style={{ width: "100%" }}
                    id="numberOfPosition"
                    name="numberOfPosition"
                    error={Boolean(formik.errors.numberOfPosition)}
                    onChange={formik.handleChange}
                    value={formik.values.numberOfPosition}
                    onBlur={formik.handleBlur}
                    type="number"
                    placeholder="Açık Posisyon sayısı"
                  />
                  {formik.errors.numberOfPosition && formik.touched.numberOfPosition && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.numberOfPosition}
                    </div>
                  )}
                </Grid.Column>
                <Grid.Column width={8}>
                <Label><Icon name="calendar check outline"> Last Apply Date</Icon></Label>

                  <Input
                    style={{ width: "100%" }}
                    type="date"
                    error={Boolean(formik.errors.lastApplyDate)}
                    onChange={(event, data) =>
                      handleChangeSemantic(data.value, "lastApplyDate")
                    }
                    value={formik.values.lastApplyDate}
                    onBlur={formik.handleBlur}
                    name="lastApplyDate"
                    placeholder="Son başvuru tarihi"
                  />
                  {formik.errors.lastApplyDate && formik.touched.lastApplyDate && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.lastApplyDate}
                    </div>
                  )}
                </Grid.Column>
              </Grid>
            </Form.Field>

            <Form.Field>
            <Label><Icon name="edit"> Description </Icon></Label>

              <TextArea
                placeholder="Açıklama"
                style={{ minHeight: 100 }}
                error={Boolean(formik.errors.jobDescription).toString()}
                value={formik.values.jobDescription}
                name="jobDescription"
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
              {formik.errors.jobDescription && formik.touched.jobDescription && (
                <div className={"ui pointing red basic label"}>
                  {formik.errors.jobDescription}
                </div>
              )}
            </Form.Field>
            <Button
              content="Ekle"
              labelPosition="right"
              icon="add"
              positive
              type="submit"
              style={{ marginLeft: "20px" }}
            />
          </Form>
        </Card.Content>
      </Card>
    </div>
  );

}
