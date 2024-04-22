package org.zerock.exam.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.exam.DTO.NoticeDTO;
import org.zerock.exam.service.TouristService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/noticeAdd")
@Log4j2
public class NoticeAddController extends HttpServlet {

    private TouristService touristService = TouristService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {log.info("Notice Add---------------------- get");
        req.getRequestDispatcher("/notice_add.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoticeDTO noticeDTO = NoticeDTO.builder()
                .title(req.getParameter("title"))
                .content(req.getParameter("contents"))
                .build();

        log.info("Notice Add---------------------- post");
        log.info(noticeDTO);
        try {
            touristService.writeList(noticeDTO);
        } catch (Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect("/noticeList");
    }
}
