package miniproject.board.controller;

import miniproject.board.domain.Boards;
import miniproject.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping("/boardlist")
    public String boardlist(Model model){
        List<Boards> boards = service.boardsList();
        model.addAttribute("boards", boards);
        return "boardlist";
    }

    @GetMapping("/boardwrite")
    public String boardwrite(){
        return "boardwrite";
    }
    @PostMapping("/boardwrite")
    public String boardwritepost(BoardForm form){
        //service 로직, repository db에 저장
        Boards boards = new Boards();
        service.boardSave(boards);
        boards.setTitle(form.getTitle());
        boards.setContents(form.getContents());
        service.boardSave(boards);
        return "redirect:/boardlist";
    }

    @GetMapping("/board/{id}")
    public String board(Model model, @PathVariable Integer id){
        Boards board = service.board(id);
        model.addAttribute("board", board);
        return "board";
    }
    @PostMapping("/boardUpdate")
    public String boardUpdate(BoardForm form, Integer id){
        Boards boards = service.board(id);
        boards.setTitle(form.getTitle());
        boards.setContents(form.getContents());
        service.boardSave(boards);
        return "redirect:/boardlist";
    }

    @PostMapping("/boardDelete")
    public String boardDelete(Integer id){
        service.boardDelete(id);
        return "redirect:/boardlist";
    }

/*      <p> <input type="submit" value="수정" th:action="@{/boardUpdate/{id}(id=${board.id})}"> </p>
    <p> <input type="submit" value="삭제" th:action="@{/boardDelete/{id}(id=${board.id})}}">*/
}

