package com.party.playlist.battle.resthttp;

public class ResponseHandler {

    public static String response(String responseMessage, String statusCode, String statusMessage) {

        return "HTTP/1.1 " + statusCode + " " + statusMessage + "\r\n"
                + "Content-Type: text/html\r\n"
                + "Accept-Ranges: bytes \r\n"
                + "Server: Csabi \r\n"
                + "Status: " + statusCode + " \r\n"
                + "Content-Lenght: 61 \r\n\r\n" + responseMessage;
    }
}
