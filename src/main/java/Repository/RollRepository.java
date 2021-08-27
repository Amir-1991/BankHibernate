package Repository;

import Config.DBConnector;
import Entity.RollEntity;

import java.util.List;

public class RollRepository {
    public static void save(RollEntity newRoll) {
        DBConnector.save(newRoll);
        DBConnector.commit();
    }

    public static List<RollEntity> seeAllRolls() {
        List<RollEntity> rollRes = DBConnector.query("SELECT roll FROM RollEntity roll");
        return rollRes;
    }
}
