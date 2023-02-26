package vn.edu.hcmuaf.fit.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageParameterUntil {
    private String message;
    private String alert;
    private String link;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public MessageParameterUntil(String message, String alert, String link, HttpServletRequest request, HttpServletResponse response) {
        this.message = message;
        this.alert = alert;
        this.link = link;
        this.request = request;
        this.response = response;
    }

    public MessageParameterUntil() {
    }

    public void send() throws ServletException, IOException {
        request.setAttribute("message", this.message);
        request.setAttribute("alert", this.alert);
        request.getRequestDispatcher(this.link).forward(request, response);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
