package org.zerock.exam.DAO;

import lombok.Cleanup;
import org.zerock.exam.DTO.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    public void joinNewMember(MemberDTO dto) throws Exception {

        String sqlJoinMember = "insert into member (member_id, member_pw, name, phone, Email1, Email2, gender, agree) values (?, ?, ?, ?, ?, ?, ?, ?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sqlJoinMember);


        pstmt.setString(1, dto.getMember_id());
        pstmt.setString(2, dto.getMember_pw());
        pstmt.setString(3, dto.getName());
        pstmt.setString(4, dto.getPhone());
        pstmt.setString(5, dto.getEmail1());
        pstmt.setString(6, dto.getEmail2());
        pstmt.setString(7, dto.getGender());
        pstmt.setBoolean(8, dto.isAgree());

        pstmt.executeUpdate();

    }



    public MemberDTO getWithPassword(String member_id, String member_pw) throws Exception {

        String slqLogin = "select * from member where member_id = ? and member_pw = ?";

        MemberDTO dto = null;

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(slqLogin);
        pstmt.setString(1, member_id);
        pstmt.setString(2, member_pw);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        dto = MemberDTO.builder()
                .member_id(rs.getString(1))
                .member_id(rs.getString(2))
                .build();

        return dto;

    }

}
