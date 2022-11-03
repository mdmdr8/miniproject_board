package miniproject.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*Lombok을 쓰기 때문에 위에 @Getter를 주면 쓸 수 있다;
도메인의 Boards는 DB의 영속성을 위해 setter를 사용하면 안된다.*/
@Entity
@Getter
@Setter
public class Boards {
    @Id //PK에 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ai 자동으로 만들어져
    private Integer id;

    @Column  //컬럼 어노테이션 생략 가능
    private String title;
    @Column
    private String contents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
