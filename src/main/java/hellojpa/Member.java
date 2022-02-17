package hellojpa;


import javax.persistence.*;
import java.util.Date;

//@Table(name = "[테이블이름]") => 클래스명과 테이블이름 다를때

/*
@Column : 컬럼 매핑
@Temporal : 날짜 타입 매핑 => LocalDate, LocalDateTime 으로 대체 가능
@Enumerated : enum 타입 매핑
=> EnumType.STRING 사용!!! (ORDINAL 사용xxx)
@Lob : BLOB, CLOB 매핑
@Transient : 특정 필드를 컬럼에 매핑하지 않음(매핑 무시

 */

// jpa를 사용한다는걸 인식하는 어노테이션
@Entity
public class Member { // 기본생성자 필수!

    // pk
    @Id
    private Long id;

    @Column(name = "name") // db 의 column명
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member(){}

}

