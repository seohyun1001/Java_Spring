package org.zerock.exam.controller;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.zerock.exam.DTO.NoticeDTO;
import org.zerock.exam.service.TouristService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/noticeView")
@Log4j2
public class NoticeViewController extends HttpServlet  {
    private TouristService touristService = TouristService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Notice View---------------------- get");
        try {

            int no = Integer.parseInt(req.getParameter("no"));
            NoticeDTO noticeDTO = touristService.viewOne(no);

            req.setAttribute("view", noticeDTO);

            req.getRequestDispatcher("/notice_view.jsp").forward(req, resp);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int no = Integer.parseInt(req.getParameter("no"));
        log.info("no : " + no);
        try {
            touristService.delete(no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/noticeList");
    }
}
