import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas para StringUtils.")
class StringUtilsTest {

    // StringUtils stringUtils;

    @Test
    @DisplayName("Purueba el método reverse con un String valido.")
    public void testReverseWithValidString() {
        // GIVEN
        String input = "Hola";

        // WHEN
        String result = StringUtils.reverse(input);

        // THEN
        String expectedResult = "aloH";
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Prueba de isPalindrome con cadena palíndroma")
    public void testIsPalindromeWithPalindromeString() {
        // GIVEN
        String input = "level";

        // WHEN
        boolean result = StringUtils.isPalindrome(input);

        // THEN
        Assertions.assertTrue(result);
    }
}