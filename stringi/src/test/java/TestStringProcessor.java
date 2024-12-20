import static Strings.StringProcessor.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStringProcessor {
    //     Тесты копий строки:
    @ParameterizedTest
    @CsvSource (value = {"2,привет привет,ри","1,word,word","0,что-нибудь,люк"})
    void TestCopiesOutputUsing(String expected, String str1, String str2) {
        assertEquals(expected, amountOfStringInString(str1,str2));
    }

    @Test
    void TestCopiesOutputException() {
        assertThrows(
                IllegalArgumentException.class, () -> copiesOutput("привет", -3)
        );
    }

    @Test
    void TestCopiesOutputIsNull() {
        assertThrows(
                NullPointerException.class, () -> copiesOutput(null, 1)
        );
    }

    @Test
    void TestCopiesOutputIsEmpty() {
        assertThrows(
                IllegalArgumentException.class, () -> copiesOutput("", 1)
        );
    }
    //      Тесты вхождения строки в строку:
    @ParameterizedTest
    @CsvSource (value = {"2,привет привет,ри","1,word,word","0,что-нибудь,люк"})
    void TestAmountOfStringInStringUsing(String expected, String str1, String str2) {
        assertEquals(expected, amountOfStringInString(str1,str2));
    }

    @Test
    void TestAmountOfStringInStringException() {
        assertThrows(
                IllegalArgumentException.class, () -> amountOfStringInString("привет", "приветствую")
        );
    }

    @ParameterizedTest
    @CsvSource (value = {",текст","текст,",","})
    void TestAmountOfStringInStringIsNull(String str1, String str2) {
        assertThrows(
                NullPointerException.class, () -> amountOfStringInString(str1, str2)
        );
    }

    @ParameterizedTest
    @CsvSource (value = {"'',текст","текст,''","'',''"})
    void TestAmountOfStringInStringIsEmpty(String str1, String str2) {
        assertThrows(
                IllegalArgumentException.class, () -> amountOfStringInString(str1, str2)
        );
    }
    //      Тесты замены "1 2 3" на "один два три":
    @ParameterizedTest
    @CsvSource (value = {"один два три,1 2 3",
            "один один какое-то слово - два три два три, 1 1 какое-то слово - 2 3 2 3", "0 4 5,0 4 5"})
    void TestReplaceOneTwoThreeUsing(String expected, String text) {
        assertEquals(expected, replaceOneTwoThree(text));
    }

    @Test
    void TestReplaceOneTwoThreeIsNull() {
        assertThrows(
                NullPointerException.class, () -> replaceOneTwoThree(null)
        );
    }

    @Test
    void TestReplaceOneTwoThreeIsEmpty() {
        assertThrows(
                IllegalArgumentException.class, () -> replaceOneTwoThree("")
        );
    }
    //      Тесты удаления каждого второго символа
    @ParameterizedTest
    @CsvSource (value = {"пие,привет","япоел,я пробеел","Ж,Ж","Д,Да"})
    void TestDeleteEachSecondCharUsing(String expected, String text) {
        assertEquals(expected, deleteEachSecondChar(text));
    }

    @Test
    void TestDeleteEachSecondChaIsNull() {
        assertThrows(
                NullPointerException.class, () -> deleteEachSecondChar(null)
        );
    }

    @Test
    void TestDeleteEachSecondChaIsEmpty() {
        assertThrows(
                IllegalArgumentException.class, () -> deleteEachSecondChar("")
        );
    }
    //      Тесты переворота текста
    @ParameterizedTest
    @CsvSource (value = {"джава,джава","безумие такое что,что такое безумие",
            "получается палиндром - 1 2 3 4 3 2 1,1 2 3 4 3 2 1 - палиндром получается"})
    void TestTextReverseUsing(String expected, String text) {
        assertEquals(expected, textReverse(text));
    }

    @Test
    void TestTextReverseIsNull() {
        assertThrows(
                NullPointerException.class, () -> textReverse(null)
        );
    }

    @Test
    void TestTextReverseIsEmpty() {
        assertThrows(
                IllegalArgumentException.class, () -> textReverse("")
        );
    }
    //      Тесты замены 16-ричного числа в 10-тичное внутри текста
    @ParameterizedTest
    @CsvSource (value = {"16 16 привет 10,0x10 0x10 привет 10","801,0x321","321,321","x321,x321"})
    void TestSixthToTenthInTextUsing(String expected, String text) {
        assertEquals(expected, sixthToTenthInText(text));
    }

    @Test
    void TestSixthToTenthInTexIsNull() {
        assertThrows(
                NullPointerException.class, () -> sixthToTenthInText(null)
        );
    }

    @Test
    void TestSixthToTenthInTexIsEmpty() {
        assertThrows(
                IllegalArgumentException.class, () -> sixthToTenthInText("")
        );
    }
}
