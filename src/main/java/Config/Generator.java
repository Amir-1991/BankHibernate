package Config;

public class Generator {
    public static String createGenerateNumber(int number) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < number; i++) {
            int index = (int) (ConstantValue.NUMERIC_STRING.length() * Math.random());
            sb.append(ConstantValue.NUMERIC_STRING.charAt(index));
        }
        return sb.toString();
    }
}
