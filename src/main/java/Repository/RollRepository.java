package Repository;

import Config.ConstantValue;
import Config.DBConnector;
import Entity.RollEntity;

import java.util.List;

public class RollRepository {
    public static void save(RollEntity newRoll) {
        DBConnector.save(newRoll);
    }

    public static List<RollEntity> seeAllRolls() {
        List<RollEntity> rollRes = DBConnector.query(ConstantValue.ALL_ROLLS);
        return rollRes;
    }
}
