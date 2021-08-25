package Repository;

import Config.DBConnector;
import Entity.AdminEntity;
import java.util.List;

public class AdminRepository {

    public static List load(List<String> logInfo) {
        String query = "SELECT admin FROM AdminEntity admin WHERE admin.adminName LIKE "+logInfo.get(0)+"";
        List<AdminEntity> resultAdmin = DBConnector.query(query);
        return resultAdmin;
    }

}
