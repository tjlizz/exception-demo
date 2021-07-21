
package com.github.exception.demo.exception.http;

public class HttpException extends RuntimeException {
    protected String code;

    public String getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    protected Integer httpStatusCode = 500;
}
