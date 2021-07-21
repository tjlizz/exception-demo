
package com.github.exception.demo.exception.http;

public class UnAuthenticatedException extends HttpException{
    public UnAuthenticatedException(String code){
        this.code = code;
        this.httpStatusCode = 401;
    }
}
