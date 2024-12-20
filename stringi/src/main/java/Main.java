import FinanceReport.FinanceReport;
import FinanceReportProcessor.FinanceReportProcessor;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Strings.StringProcessor.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задания: ");
        byte select = 0;
        try {
            select = scanner.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("Error");
        }
        switch (select) {
            case 1:
                useCopiesOutput(); // Повтор слова N раз
                break;
            case 2:
                useAmountOfStringInString(); // Поиск количества вхождений строки в другую строку
                break;
            case 3:
                useReplaceOneTwoThree(); // Изменение цифр на слова
                break;
            case 4:
                useDeleteEachSecondChar(); // Удаление каждого 2-го символа строки
                break;
            case 5:
                useTextReverse(); // Изменение порядка слов
                break;
            case 6:
                useSixthToTenthInText(); // Перевод из 16-ричного в 10-тичное внутри строки
                break;
            case 7:
                Payments(); // Платежи
                break;
        }
    }

    public static void useCopiesOutput() {
        System.out.println(copiesOutput("привет", 3));
    }

    public static void useAmountOfStringInString() {
        System.out.println(amountOfStringInString("Пироги пекут очень долго и очень редко", "очень"));
    }

    public static void useReplaceOneTwoThree() {
        System.out.println(replaceOneTwoThree("123"));
    }

    public static void useDeleteEachSecondChar() {
        System.out.println(deleteEachSecondChar("Технически неполадки требуют поладки"));
    }

    public static void useTextReverse() {
        System.out.println(textReverse("работа         должна оплачиваться"));
    }

    public static void useSixthToTenthInText() {
        System.out.println(sixthToTenthInText("Антону 0x10 лет, в то время как его отцу 0x322 лет"));
    }

    public static void Payments() {
        FinanceReport report = new FinanceReport("Марк Дэвид Перкус", 28,11,2006);
        report.add("Eвгений Евгениевич Судейкин", 22, 1, 2000, 50.0F);
        report.add("Черенков Кирилл Дмитриевич", 2, 2, 2002, 99999.0F);
        FinanceReport coped = new FinanceReport(report);
        for (int i = 0; i < report.getPaymentsArraySize(); i++) {
            System.out.println(report.getPayment(i));
        }
        report.add("Максим Максим Старокожев", 22, 2, 2000, 100.0F);
        report.add("Уголь Мальгельдинов Углеродов", 2, 2, 2002, 100.0F);
        System.out.println(coped.toString());
        System.out.println(report.toString());

        //System.out.println(FinanceReportProcessor.getPaymentsWithChar(report.getPaymentsList(),'М').allPaymentsToString());
        System.out.println(FinanceReportProcessor.getPaymentsLowerSumma(report.getPaymentsList(), 1000.0F).allPaymentsToString());

        System.out.println(FinanceReportProcessor.getSumPaymentOnDate(report.getPaymentsList(), 22, 2, 2000));

        System.out.println(FinanceReportProcessor.getUnMonthPayment(report.getPaymentsList(), 2000).values());

    }
}
