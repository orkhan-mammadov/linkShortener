package com.ls.urlshortener.contoller.request;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlRequestDTO {
    @NotEmpty(message = "URL cannot be empty")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "Invalid URL format")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void validateURL() {
        try {
            new URL(url);
        }catch (MalformedURLException e){
            throw new RuntimeException("Invalid URL format");
        }
    }
}
