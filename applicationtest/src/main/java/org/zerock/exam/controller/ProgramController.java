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
import java.util.List;

@WebServlet(value = "/program")
@Log4j2
public class ProgramController extends HttpServlet {
    private TouristService touristService = TouristService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Program -------------- get");

        try {
            List<ProgramDTO> list = touristService.viewProgram();
            req.setAttribute("programs", list);
            req.getRequestDispatcher("program.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
