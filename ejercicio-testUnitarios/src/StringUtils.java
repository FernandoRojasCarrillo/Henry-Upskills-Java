public class StringUtils {
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        String reversedStr = reverse(str);
        return str.equals(reversedStr);
    }

    public static String truncate(String str, int maxLength) {
        if (str == null) {
            return null;
        }

        if (str.length() <= maxLength) {
            return str;
        }

        return str.substring(0, maxLength);
    }
}
