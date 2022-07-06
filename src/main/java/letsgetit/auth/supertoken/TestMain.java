package letsgetit.auth.supertoken;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;

public class TestMain {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        LocalDateTime localDateTime = LocalDateTime.now();

        Thread thread1 = new EjThread(calendar, localDateTime);
        Thread thread2 = new ShThread(calendar, localDateTime);

        thread1.start();
        thread2.start();
    }


    public static class EjThread extends Thread {
        private Calendar calendar;

        private LocalDateTime localDateTime;

        public EjThread(Calendar calendar, LocalDateTime localDateTime) {
            this.calendar = calendar;
            this.localDateTime = localDateTime;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {

                this.updateCalendarTime();
//                this.updateLocalDateTime();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}

                this.printCalendar();
//                this.printLocalDateTime();
            }

            System.out.println("은지 생일 끝");
        }

        private void updateCalendarTime() {
            calendar.set(2022, Calendar.JANUARY, 27);
        }

        private void updateLocalDateTime() {
            localDateTime = localDateTime.withYear(2022).withMonth(Month.JANUARY.getValue()).withDayOfMonth(27);
        }

        private void printCalendar() {
            if (calendar.getTime().getDate() != 27) {
                System.out.println("은지 생일 : " + this.calendar.getTime());
            }
        }

        private void printLocalDateTime() {
            if (localDateTime.getDayOfMonth() != 27) {
                System.out.println("은지 생일 : " + this.localDateTime);
            }
        }
    }

    public static class ShThread extends Thread {
        private Calendar calendar;

        private LocalDateTime localDateTime;

        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {

                this.updateCalendarTime();
//                this.updateLocalDateTime();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}

                this.printCalendar();
//                this.printLocalDateTime();
            }
            System.out.println("세형 생일 끝");

        }

        public ShThread(Calendar calendar, LocalDateTime localDateTime) {
            this.calendar = calendar;
            this.localDateTime = localDateTime;
        }

        private void updateCalendarTime() {
            calendar.set(2022, Calendar.JANUARY, 8);
        }

        private void updateLocalDateTime() {
            localDateTime = localDateTime.withYear(2022).withMonth(Month.JANUARY.getValue()).withDayOfMonth(8);
        }

        private void printCalendar() {
            if (calendar.getTime().getDate() != 8) {
                System.out.println("세형 생일 : " + this.calendar.getTime());
            }
        }

        private void printLocalDateTime() {
            if (localDateTime.getDayOfMonth() != 8) {
                System.out.println("세형 생일 : " + this.localDateTime);
            }
        }
    }
}
