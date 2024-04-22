package org.zerock.exam.DAO;

import lombok.Cleanup;
import org.zerock.exam.DTO.NoticeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {

    public void writeNewNotice(NoticeDTO noticeDTO) throws Exception {

        String sqlNewNotice = "insert into notice (title, content) values(?,?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sqlNewNotice);

        pstmt.setString(1, noticeDTO.getTitle());
        pstmt.setString(2, noticeDTO.getContent());
        pstmt.executeUpdate();

    }

    public List<NoticeDTO> selectNotice() throws Exception {
        String sqlSelect = "select * from notice order by no desc";


        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sqlSelect);

        @Cleanup ResultSet rs = pstmt.executeQuery();
        List<NoticeDTO> list = new ArrayList<>();
        while (rs.next()) {
            NoticeDTO noticeDTO = NoticeDTO.builder()
                    .no(rs.getInt("no"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .count(rs.getInt("count"))
                    .create_date(rs.getDate("create_date").toLocalDate())
                    .build();

            list.add(noticeDTO);
        }
            return list;

    }


    public void deleteNotice(int no) throws Exception {
        String sqlDelete = "delete from notice where no = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sqlDelete);
        pstmt.setInt(1, no);
        pstmt.executeUpdate();
    }

    public NoticeDTO selectOne(int no) throws Exception {
        String sqlSelectOne = "select * from notice where no = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sqlSelectOne);
        pstmt.setInt(1, no);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        NoticeDTO noticeDTO = NoticeDTO.builder()
                .no(rs.getInt("no"))
                .title(rs.getString("title"))
                .content(rs.getString("content"))
                .count(rs.getInt("count"))
                .create_date(rs.getDate("create_date").toLocalDate())
                .build();

        return noticeDTO;
    }

}
