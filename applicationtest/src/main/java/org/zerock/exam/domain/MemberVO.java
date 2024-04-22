package org.zerock.exam.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

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
