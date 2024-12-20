package Strings;

public class StringProcessor {

    public static int amountOfWords(String str) {
        return (str.split(" ", -1).length - 1);
    }

    public static int amountOfLetters(String str) {
        return (str.split("", -1).length - 1);
    }

    public static String copiesOutput(String text, int copies) {
        if (copies < 0) {
                throw new IllegalArgumentException("Нельзя вывести меньше 0 раз");
            }
        if (text.isEmpty()) {
                throw new IllegalArgumentException("Текст пуст");
            }

            text = text.repeat(copies);
                return text;
    }

    public static String amountOfStringInString(String str1, String str2) {

        if (str1.isEmpty() || str2.isEmpty()) {
                throw new IllegalArgumentException("Одна или все строки пусты");
            }
        if (amountOfLetters(str2) > amountOfLetters(str1)) {
                throw new IllegalArgumentException("Строка вхождения больше проверяемой строки");
            }
        int x = str1.split(str2, -1).length-1;
            return Integer.toString(x);
    }

    public static String replaceOneTwoThree(String text) {
        if (text.isEmpty()) {
                throw new IllegalArgumentException("Некоторые строки пусты");
            }
            text = text.replace("1", "один");
            text = text.replace("2", "два");
            text = text.replace("3", "три");
            return text;
    }

    public static String deleteEachSecondChar(String text) {
        if (text.isEmpty()) {
                throw new IllegalArgumentException("Некоторые строки пусты");
            }
            StringBuilder result = new StringBuilder(text);
        for (int i = 1; i < result.length(); i++) {
                result.deleteCharAt(i);
            }
            return String.valueOf(result);
    }

    public static String textReverse(String text) {
        if (text.isEmpty()) {
                throw new IllegalArgumentException("Некоторые строки пусты");
            }
            String[] words = new String[amountOfWords(text)];
            String[] edited = new String[amountOfWords(text)];
            words = text.split(" ");
            edited = text.split(" ");
            for (int i = 0; i < amountOfWords(text) + 1; i++) {
                edited[i] = words[amountOfWords(text) - i];
            }
            return String.join(" ", edited);
    }

    public static String sixthToTenthInText(String text) {
            if (text.isEmpty()) {
                throw new IllegalArgumentException("Некоторые строки пусты");
            }
            if (amountOfWords(text) == 0) {
                if (text.contains("0x") && amountOfLetters(text) > 2) {
                    String replace = text.substring(2);
                    int replaceInt = Integer.parseInt(replace, 16);
                    text = Integer.toString(replaceInt);
                    return Integer.toString(Integer.parseInt(text));
                }
            }
            String[] stringArray = new String[amountOfWords(text)];
            stringArray = text.split(" ");
            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i].contains("0x") && amountOfLetters(stringArray[i]) > 2) {
                    String replace = stringArray[i].substring(2);
                    int replaceInt = Integer.parseInt(replace, 16);
                    stringArray[i] = Integer.toString(replaceInt);
                }
            }
            return String.join(" ", stringArray);
    }
}
