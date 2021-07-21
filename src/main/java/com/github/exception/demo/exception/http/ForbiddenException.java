
package com.github.exception.demo.exception.http;


public class ForbiddenException extends HttpException {
    public ForbiddenException(String code) {
        this.code = code;
        this.httpStatusCode = 403;
    }
}
