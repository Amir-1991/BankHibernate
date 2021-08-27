package Config;

public class ConstantValue {
    public static String NATIONAL_CODE_REGEX = "\\d{10}";
    public static String PHONE_NUMBER_REGEX = "\\d{11}";
    public static String MENU_REGEX = "\\d{2}";
    public static String DATE_FORMATTER_REGEX = "\\d{4}-\\d{2}-\\d{2}";
    public static String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    public static String NAME_REGEX = "^[a-zA-Z\\s]*$";

}
