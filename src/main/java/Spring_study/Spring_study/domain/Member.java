package Spring_study.Spring_study.domain;

import javax.persistence.*;

@Entity
public class Member
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //DB가 생성해주는건 Identity
    private Long id;

    private String name;

    public long getId() {
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
