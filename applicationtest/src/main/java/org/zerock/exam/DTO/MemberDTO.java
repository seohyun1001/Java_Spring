package org.zerock.exam.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.exam.domain.MemberVO;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO extends MemberVO {

    private String member_id;
    private String member_pw;
    private String name;
    private String phone;
    private String Email1;
    private String Email2;
    private String gender;
    private boolean agree;
    private LocalDate create_date;

}
