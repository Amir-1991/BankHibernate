import Config.DBConnector;
import View.MainForm;

public class Main {
    public static void main(String[] args) {
        DBConnector.connection();
        MainForm.menu();
        DBConnector.disConnection();
    }
}
