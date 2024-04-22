package com.bitc.java404.quiz1;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class quiz1DTO {

    private HeaderDTO header;
    private BodyDTO body;



    @XmlElement(name = "header")
    public HeaderDTO getHeader() {
        return header;
    }

    public void setHeader(HeaderDTO header) {
        this.header = header;
    }

    @XmlElement(name = "body")
    public BodyDTO getBody() {
        return body;
    }

    public void setBody(BodyDTO body) {
        this.body = body;
    }
}
