package org.zerock.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
  // DTO(Data Transfer Object) : 프레젠테이션 계층, 보여주는 층
  // 결론 : 실제 디비에서 5개의 정보가 있으면
  // 내가 실제로 보여주고 싶은 정보 3개만 골라서 사용 가능
  private Long tno;
  @NotEmpty // null, "     "
  private String title;
  @Future
  private LocalDate dueDate;

  private boolean finished;
  @NotEmpty
  private String writer;
}
