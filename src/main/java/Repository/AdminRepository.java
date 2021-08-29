package Repository;

import Config.DBConnector;
import Entity.AdminEntity;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {

    public static List load(List<String> logInfo) {
        List<AdminEntity> resultAdmin ;
        resultAdmin = DBConnector.query("SELECT admin FROM AdminEntity admin WHERE admin.adminName = '" + logInfo.get(0) + "'");
        return resultAdmin;
    }

}
