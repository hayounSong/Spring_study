package Spring_study.Spring_study.domain;

import javax.persistence.*;

@Entity
public class Member
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //DB가 생성해주는건 Identity
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
