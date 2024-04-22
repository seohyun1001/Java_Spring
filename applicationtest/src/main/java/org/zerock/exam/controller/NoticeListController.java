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
import java.util.List;

@WebServlet(value = "/noticeList")
@Log4j2
public class NoticeListController extends HttpServlet {
    private TouristService touristService = TouristService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Notice List---------------------- get");


        try {
            List<NoticeDTO> list = touristService.viewList();
            req.setAttribute("list", list);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getRequestDispatcher("/notice_list.jsp").forward(req, resp);
    }


}


