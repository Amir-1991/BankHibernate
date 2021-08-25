package Entity;

import javax.persistence.*;

@Entity
@Table(name = "ADMIN_PROJECT")
public class AdminEntity {

    @Id
    @Column(name = "ID",length = 2)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ADMIN_NAME",length = 30)
    private String adminName;

    @Column(name = "ADMIN_PASSWORD",length = 50)
    private String adminPassword;

    public AdminEntity() {

    }

    public AdminEntity(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
