package org.zerock.exam.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.exam.DAO.MemberDAO;
import org.zerock.exam.DAO.NoticeDAO;
import org.zerock.exam.DAO.ProgramDAO;
import org.zerock.exam.DTO.MemberDTO;
import org.zerock.exam.DTO.NoticeDTO;
import org.zerock.exam.DTO.ProgramDTO;

import java.util.List;

@Log4j2
public enum TouristService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;
    private NoticeDAO noticeDao = new NoticeDAO();
    private ProgramDAO programDao = new ProgramDAO();

    TouristService() {
        memberDAO = new MemberDAO();
        modelMapper = new ModelMapper();
    }

    public void join(MemberDTO memberDTO) throws Exception{
        memberDAO.joinNewMember(memberDTO);
    }

    public void writeList(NoticeDTO noticeDTO) throws Exception{
        noticeDao.writeNewNotice(noticeDTO);
    }

    public List<NoticeDTO> viewList() throws Exception{
        List<NoticeDTO> list = noticeDao.selectNotice();
        return list;
    }

    public NoticeDTO viewOne(int no) throws Exception{
        return noticeDao.selectOne(no);
    }

    public void delete(int no) throws Exception{
        noticeDao.deleteNotice(no);
    }

    public List<ProgramDTO> viewProgram() throws Exception{
        List<ProgramDTO> programList = programDao.selectProgram();
        return programList;
    }

    public ProgramDTO get(String title) throws Exception{
        ProgramDTO programDTO = programDao.selectTitle(title);
        return programDTO;
    }



}
