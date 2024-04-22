package org.zerock.exam.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
@Log4j2
public class LoginListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

        String sessionName = event.getName();
        Object obj = event.getValue();

        if (sessionName.equals("loginInfo")) {
            log.info("User logged in---------------");
            log.info(obj);
        }

    }

}
