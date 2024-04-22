package org.zerock.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import javax.validation.Valid;

// 깃 커밋 테스트 , 주석입니다.

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;

  // 기존 단순 전체 개수 출력 -> 페이징 처리해서 화면에 전달하는 코드 수정하기
  // 기존 코드
//  @RequestMapping("/list")
//  public void list(Model model) {
//    log.info("todo list......");
//    model.addAttribute("dtoList",todoService.getAll());
//  }

  // 페이징 처리된 목록 출력 코드
  @GetMapping("/list")
  // 화면에서 전달 된 파라미터를 PageRequestDTO가 자동 변환해준다
  // page, size 가 1 또는 최소, 최대 양수 등이 아니면 오류가 발생하고
  // 기본 페이지(page=1&size=10)로 이동
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
    log.info(pageRequestDTO);
    // 에러가 존재한다면 출력 후 리다이렉트
    if (bindingResult.hasErrors()) {
      pageRequestDTO = PageRequestDTO.builder().build();
    }
    // responseDTO 키 안에 페이징에 관련된 재료 준비물들이 다 들어있다.
    model.addAttribute("responseDTO",todoService.getList(pageRequestDTO));
  }

  @GetMapping({"/read","/modify"})
  public void read(Long tno, Model model) {
    model.addAttribute("dto",todoService.getOne(tno));
  }

  @PostMapping("/remove")
  public String remove(Long tno, RedirectAttributes redirectAttributes) {
    log.info("-----------------remove-------------------");
    log.info("tno:"+tno);
    todoService.remove(tno);
    return "redirect:/todo/list";
  }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO dto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
      if(bindingResult.hasErrors()){
        log.info("has errors.......");
        redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
        redirectAttributes.addAttribute("tno",dto.getTno());
        return "redirect:/todo/modify";
      }
      todoService.modify(dto);
      return "redirect:/todo/list";
    }

//  @RequestMapping(value = "/register", method= RequestMethod.GET)
  @GetMapping("/register")
  public void register(){
    log.info("todo register.......");
  }

  //@RequestMapping(value = "/register", method= RequestMethod.POST)
  @PostMapping("/register")
  public String registerPost(@Valid TodoDTO todoDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
    log.info("POST todo register.......");
    if(bindingResult.hasErrors()){
      log.info("has errors.......");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      return "/todo/register";
    }
    log.info(todoDTO);
    todoService.register(todoDTO);
    return "redirect:/todo/list";
  }
}
