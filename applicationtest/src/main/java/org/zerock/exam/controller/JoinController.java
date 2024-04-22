package org.zerock.exam.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.exam.DTO.MemberDTO;
import org.zerock.exam.service.TouristService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "joinController", value = "/join")
@Log4j2
public class JoinController extends HttpServlet {
    private TouristService touristService = TouristService.INSTANCE;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("join get--------------");
        req.getRequestDispatcher("/join.jsp").forward(req, resp);
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO memberDTO = MemberDTO.builder()
                .member_id(req.getParameter("member_id"))
                .member_pw(req.getParameter("member_pw"))
                .name(req.getParameter("name"))
                .phone(req.getParameter("phone"))
                .Email1(req.getParameter("member_id"))
                .Email2(req.getParameter("Email2"))
                .gender(req.getParameter("gender"))
                .agree("on".equals(req.getParameter("agree"))) // 'agree' 변수 추가
                .build();




        log.info("join post--------------");
        log.info(memberDTO);
        try {
            touristService.join(memberDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/login");

    }

}

