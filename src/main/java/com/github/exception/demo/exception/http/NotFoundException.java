
package com.github.exception.demo.exception.http;

public class NotFoundException extends HttpException {
    public NotFoundException(String code){
        this.httpStatusCode = 404;
        this.code = code;
    }
}
