package miniproject.board.controller;

import miniproject.board.domain.Boards;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    @GetMapping("/boardlist")
    public String boardlist(){
        return "boardlist";
    }

    @GetMapping("/boardwrite")
    public String boardwrite(){
        return "boardwrite";
    }
    @PostMapping("/boardwrite")
    public String boardwritepost(Boards boards){
        //service 로직, repository db에 저장
        System.out.println(boards.getTitle() + boards.getContents());
        return "redirect:/boardlist";
    }

    @GetMapping("/board")
    public String board(){
        return "board";
    }
}

