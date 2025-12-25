package org.example.shopyearb.Response;

public class BasicResponse {
    private boolean successes;
    private Integer errorCode;


    public BasicResponse(boolean successes, Integer errorCode) {
        this.successes = successes;
        this.errorCode = errorCode;
    }

    public boolean isSuccesses() {
        return successes;
    }

    public void setSuccesses(boolean successes) {
        this.successes = successes;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
