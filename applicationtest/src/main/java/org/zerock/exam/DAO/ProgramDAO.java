package org.zerock.exam.DAO;

import lombok.Cleanup;
import org.zerock.exam.DTO.ProgramDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAO {

    public List<ProgramDTO> selectProgram() throws Exception {
        String sqlSelect = "select * from program";


        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sqlSelect);

        @Cleanup ResultSet rs = pstmt.executeQuery();
        List<ProgramDTO> programList = new ArrayList<>();
        while (rs.next()) {
            ProgramDTO programDTO = ProgramDTO.builder()
                    .no(rs.getInt("no"))
                    .title(rs.getString("title"))
                    .text(rs.getString("text"))
                    .subrtext(rs.getString("subrtext"))
                    .schedule(rs.getString("schedule"))
                    .img(rs.getString("img"))
                    .create_date(rs.getDate("create_date").toLocalDate())
                    .build();

            programList.add(programDTO);
        }
        return programList;

    }

    public ProgramDTO selectTitle(String title) throws Exception {
        String sqlSelect = "select title from program where title = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
        pstmt.setString(1, title);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        ProgramDTO programDTO = ProgramDTO.builder()
                .title(rs.getString("title"))
                .build();

        return programDTO;
    }

}
