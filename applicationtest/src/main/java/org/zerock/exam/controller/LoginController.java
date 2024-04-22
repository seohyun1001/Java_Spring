package org.zerock.exam.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.exam.DTO.MemberDTO;
import org.zerock.exam.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
@Log4j2
public class LoginController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login Get---------------------------");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login Post---------------------------");
        HttpSession session = req.getSession();
        String loginInfo;
        String sessionId;

        String member_id = req.getParameter("member_id");
        String member_pw = req.getParameter("member_pw");


        try {
            memberService.login(member_id, member_pw);
            session.setAttribute("loginInfo", member_id);
            loginInfo = (String) session.getAttribute("loginInfo");
            sessionId = session.getId();
            log.info("login Info : " + loginInfo);
            log.info("sessionId : " + sessionId);
            resp.sendRedirect("/");
        } catch (Exception e) {

            resp.sendRedirect("/login?result=error");
        }


    }



}
