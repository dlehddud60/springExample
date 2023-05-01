package kr.bit.controller;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.bit.entity.Board;
import kr.bit.service.BoardService;
import lombok.extern.log4j.Log4j;


@Controller  // POJO
@RequestMapping("/board/*")
//@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String getlist(Model model) {

        List<Board> list = boardService.getList();
        model.addAttribute("list",list);
        return "board/list";
    }

    @GetMapping("/register")
    public String register() {
        return "board/register";
    }

    @PostMapping("/register")
    public String register(Board vo, RedirectAttributes rttr) { //파라미터수집(vo) <-- 한글 인코딩
        boardService.register(vo); //게시물 등록
        System.out.println(vo);
        rttr.addFlashAttribute("result",vo.getIdx());
        return "redirect:/board/list";
    }

}
