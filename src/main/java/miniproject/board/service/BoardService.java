package miniproject.board.service;

import miniproject.board.domain.Boards;
import miniproject.board.repository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private final JpaBoardRepository repository;

    public BoardService(JpaBoardRepository repository){
        this.repository = repository;
    }

    public void boardSave(Boards boards){
        repository.save(boards);
    };

    public List<Boards> boardsList(){
        return repository.findAll();
    }

    public void boardDelete(Integer id){
        repository.deleteById(id);
    }
    public Boards board(Integer id){
        return repository.findById(id).get();
    }

}
