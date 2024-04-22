package org.zerock.exam.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.exam.DTO.ProgramDTO;
import org.zerock.exam.service.TouristService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Cookie")
@Log4j2
public class CookieController extends HttpServlet {
    private TouristService touristService = TouristService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String title = req.getParameter("title").replace(" ", "");
            System.out.println(title);
//            ProgramDTO programDTO = touristService.get(title);
//            req.setAttribute("programTitle", title);

            Cookie saveCookie = findCookie(req.getCookies(), "saveTitle");
            String programStr = saveCookie.getValue();
            boolean exist = false;

            if (programStr != null && programStr.indexOf(title+"-") >= 0){
                exist = true;
            }

            log.info("exist : " + exist);

            if (!exist) {
                programStr += title + "-";
                System.out.println(programStr);
                saveCookie.setValue(programStr);
                saveCookie.setMaxAge(60*60*24*7);
                saveCookie.setPath("/");
                resp.addCookie(saveCookie);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/program");
    }

    private Cookie findCookie(Cookie[] cookies, String cookieName) {
        Cookie targetCookie = null;

        if (cookies != null && cookies.length > 0) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals(cookieName)) {
                    targetCookie = ck;
                    break;
                }
            }

        }
        if (targetCookie == null) {
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24*7);
        }
        return targetCookie;
    }

}

