package org.zerock.exam.service;

import org.modelmapper.ModelMapper;
import org.zerock.exam.DAO.MemberDAO;
import org.zerock.exam.DTO.MemberDTO;
import org.zerock.exam.domain.MemberVO;
import org.zerock.exam.util.MapperUtil;

public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public MemberDTO login(String member_id, String member_pw) throws Exception {
        MemberVO vo = dao.getWithPassword(member_id, member_pw);

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }
}
