package com.restassured.automation.models;

public class ValidationsData {

    private final String validationGetName, validationGetLastName, validationGetToken, validationPostJob,
            validationPatchName, validationPutJob, validationGetId;

    public ValidationsData(){
        this.validationGetName = "Janet";
        this.validationGetLastName = "Weaver";
        this.validationGetToken = "QpwL5tke4Pnpja7X4";
        this.validationPostJob = "Senior Test Automation";
        this.validationPatchName = "Daniel";
        this.validationPutJob = "engineer";
        this.validationGetId = "2";
    }

    public String getValidationGetName() {
        return validationGetName;
    }

    public String getValidationGetLastName() {
        return validationGetLastName;
    }

    public String getValidationGetToken() {
        return validationGetToken;
    }

    public String getValidationPostJob() {
        return validationPostJob;
    }

    public String getValidationPatchName() {
        return validationPatchName;
    }

    public String getValidationPutJob() {
        return validationPutJob;
    }

    public String getValidationGetId() {
        return validationGetId;
    }

}
