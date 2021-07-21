
package com.github.exception.demo.exception.http;


public class ServerErrorException extends HttpException {
    public ServerErrorException(String code) {
        this.code = code;
        this.httpStatusCode = 500;
    }
}
