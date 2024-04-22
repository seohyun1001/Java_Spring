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

  @RequestMapping("/list")
  public void list(Model model) {
    log.info("todo list......");
    model.addAttribute("dtoList",todoService.getAll());
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
