package org.zerock.springex.service;

import com.sun.tools.javac.comp.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
  private final TodoMapper todoMapper;
  private final ModelMapper modelMapper;

  @Override
  public void register(TodoDTO todoDTO) {
    log.info(modelMapper);
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    log.info(todoVO);
    todoMapper.insert(todoVO);
  }

  @Override
  public List<TodoDTO> getAll() {
    List<TodoDTO> dtoList = todoMapper.selectAll().stream()
        .map(vo -> modelMapper.map(vo, TodoDTO.class))
        .collect(Collectors.toList());
    return dtoList;
  }

  @Override
  public TodoDTO getOne(Long tno) {
    return modelMapper.map(todoMapper.selectOne(tno), TodoDTO.class);
  }

  @Override
  public void remove(Long tno) {
    todoMapper.delete(tno);
  }

  @Override
  public void modify(TodoDTO todoDTO) {
    todoMapper.update(modelMapper.map(todoDTO, TodoVO.class));
  }

  @Override
  public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
    // 서버에서 계산한 멤버들을 반환 값으로 보내기 위한 준비 단계
    // 기존에 서비스에서 사용했던 메서드들을 재사용할 예정
    // 해당 페이지의 게시글 목록
    List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
    // TodoVO -> TodoDTO로 변환하는 함수
    List<TodoDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo, TodoDTO.class))
            .collect(Collectors.toList());

    int total = todoMapper.getCount(pageRequestDTO);

    PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
            .dtoList(dtoList)
            .total(total)
            .pageRequestDTO(pageRequestDTO)
            .build();

    return pageResponseDTO;
  }
}










