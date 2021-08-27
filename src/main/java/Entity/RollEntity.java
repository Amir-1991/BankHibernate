package Entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLL")
public class RollEntity {
    @Id
    @Column(name = "ROLL_ID",length = 2)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLL_TITLE",length = 25,unique = true)
    private String rollTitle;

    public RollEntity() {

    }

    public RollEntity(String rollTitle) {
        this.rollTitle = rollTitle;
    }

    @Override
    public String toString() {
        return "RollEntity{" +
                "id=" + id +
                ", rollTitle='" + rollTitle + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRollTitle() {
        return rollTitle;
    }

    public void setRollTitle(String rollTitle) {
        this.rollTitle = rollTitle;
    }
}
