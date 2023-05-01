package kr.bit.controller;

import javax.servlet.http.HttpSession;

import kr.bit.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.entity.Member;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/login/*")
public class LoginController {

    @Autowired
    BoardService boardService;


    @RequestMapping("/loginProcess")
    public String login(Member vo, HttpSession session) {
        Member mvo = boardService.login(vo);
        if(mvo != null) {
            session.setAttribute("mvo",mvo); //객체 바인딩
        }

        return "redirect:/board/list";
    }

    @RequestMapping("/logoutProcess")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/board/list";
    }
}
