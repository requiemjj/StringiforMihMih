package Payment;

import java.util.Objects;

public class Payment {
    private String fio;
    private Integer day, month, year;
    private Float summa;

    public Payment(String fio, Integer day, Integer month, Integer year, Float summa) {
        this.fio = fio;
        this.day = day;
        this.month = month;
        this.year = year;
        this.summa = summa;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getSumma() {
        return summa;
    }

    public void setSumma(Float summa) {
        this.summa = summa;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Payment payment = (Payment) object;
        return Objects.equals(fio, payment.fio) && Objects.equals(day, payment.day) && Objects.equals(month, payment.month) && Objects.equals(year, payment.year) && Objects.equals(summa, payment.summa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, day, month, year, summa);
    }

    @Override
    public String toString() {
        return "Плательщик: " + fio + " | Дата: " + day + "." + month + "." + year + " | Сумма: " + summa + " рублей";
    }
}
