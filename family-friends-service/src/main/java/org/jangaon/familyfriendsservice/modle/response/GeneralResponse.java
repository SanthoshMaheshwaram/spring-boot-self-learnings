/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.modle.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse {

    private String message;
    private Boolean isSuccess;
    private Object responseObject;

    public GeneralResponse() {
    }

    public GeneralResponse(String message, Boolean isSuccess, Object responseObject) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.responseObject = responseObject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}
