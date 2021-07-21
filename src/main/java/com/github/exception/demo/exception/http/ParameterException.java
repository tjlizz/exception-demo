
package com.github.exception.demo.exception.http;

public class ParameterException extends HttpException {
    public ParameterException(String code){
        this.code = code;
        this.httpStatusCode = 400;
    }
}
