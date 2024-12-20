package FinanceReportProcessor;

import FinanceReport.FinanceReport;
import Payment.Payment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanceReportProcessor {

    public static FinanceReport getPaymentsWithChar(List<Payment> payments, char sym) {
        FinanceReport report = new FinanceReport();
        for (Payment payment : payments) {
            if (payment.getFio().charAt(0) == sym) {
                report.add(payment);
            }
        }
        return report;
    }

    public static FinanceReport getPaymentsLowerSumma(List<Payment> payments, float summa) {
        FinanceReport report = new FinanceReport();
        for (Payment payment : payments) {
            if (payment.getSumma() < summa) {
                report.add(payment);
            }
        }
        return report;
    }

    public static float getSumPaymentOnDate(List<Payment> payments, Integer day, Integer month, Integer year) {
        float result = 0;
        for (Payment payment : payments) {
            if (payment.getDay().equals(day) && payment.getMonth().equals(month) && payment.getYear().equals(year)) {
                result += payment.getSumma();
            }
        }
        return result;
    }

    public static HashMap<Integer, String> getUnMonthPayment(List<Payment> payments, Integer year) {
        HashMap<Integer, String> sorted = new HashMap<>(Map.ofEntries(
                Map.entry(1,"Январь"),
                Map.entry(2,"Февраль"),
                Map.entry(3,"Март"),
                Map.entry(4,"Апрель"),
                Map.entry(5,"Май"),
                Map.entry(6,"Июнь"),
                Map.entry(7,"Июль"),
                Map.entry(8,"Август"),
                Map.entry(9,"Сентрябрь"),
                Map.entry(10,"Октябрь"),
                Map.entry(11,"Ноябрь"),
                Map.entry(12,"Декабрь")
        ));
        for (Payment payment : payments) {
            if (payment.getYear().equals(year)) {
                sorted.remove(payment.getMonth());
            }
        }
        return sorted;
    }
}
