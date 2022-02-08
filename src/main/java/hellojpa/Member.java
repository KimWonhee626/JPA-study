package hellojpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Table(name = "[테이블이름]") => 클래스명과 테이블이름 다를때

// jpa를 사용한다는걸 인식하는 어노테이션
@Entity
public class Member {

    // pk 알려주는 어노테이션
    @Id
    private long id;

//    @Column(name = "[컬럼 이름]") => 테이블의 컬럼이름과 변수이름 다를때
   private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

