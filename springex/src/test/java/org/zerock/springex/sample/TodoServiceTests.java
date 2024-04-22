package org.zerock.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import java.time.LocalDate;
import java.util.stream.Stream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {
  @Autowired(required = false)
  private TodoService todoService;

  @Test
  public void testRegister(){
    TodoDTO todoDTO = TodoDTO.builder()
        .title("스프링 테스트")
        .dueDate(LocalDate.of(2022,10,10))
        .writer("user00")
        .build();
    todoService.register(todoDTO);

  }

  @Test
  // 페이징 테스트
  public void testPaging() {

    PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(3).size(10).build();
    PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
    log.info(responseDTO);
    responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));


  }
}
