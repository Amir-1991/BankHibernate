import Config.DBConnector;
import Entity.AdminEntity;
import View.MainForm;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBConnector.connection();
        creatAdmin();
        MainForm.menu();
        DBConnector.disConnection();
    }

    public static void creatAdmin() {
        List adminCount = DBConnector.query("select admin from AdminEntity admin");
        if (adminCount.size() == 0){
            AdminEntity admin = new AdminEntity();
            admin.setAdminName("admin");
            admin.setAdminPassword("admin");
            DBConnector.save(admin);
            DBConnector.commit();
        }

    }
}
