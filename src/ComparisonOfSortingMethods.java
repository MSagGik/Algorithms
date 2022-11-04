import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class ComparisonOfSortingMethods {
    public static void main(String[] args) {
        // создание массива
        final int SIZE = 100_000;
        int[] a = new int[SIZE];
        // инициализация массива рандомными значениями
        Random random = new Random();
        for (int i = 0; i < SIZE; i++)
            a[i] = random.nextInt(100);
        // создание объекта часов
        GregorianCalendar timeView = new GregorianCalendar();
        timeView.setTime(new Date());

        // фиксация первого отсчёта в миллисекундах
        long timeOne = timeView.getTimeInMillis();
        // сортировка "пузырьком"
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE-1; j++)
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
        // фиксация второго отсчёта в миллисекундах
        timeView.setTime(new Date());
        long timeSecond = timeView.getTimeInMillis();

        // время сортировки "пузырьком"
        long timeBubbleSort = timeSecond - timeOne;

        // фиксация третьего отсчёта в миллисекундах
        timeView.setTime(new Date());
        long timeThird = timeView.getTimeInMillis();
        // стандартный метод сортировки
        Arrays.sort(a);
        // фиксация третьего отсчёта в миллисекундах
        timeView.setTime(new Date());
        // Зафиксируем момент окончания стандартной сортировки
        long timeFourth = timeView.getTimeInMillis();

        // время стандартной сортировки
        long timeStandardSort = timeFourth - timeThird;

        System.out.println("Время сортировки пузырьком " + timeBubbleSort + " миллисекунд");
        System.out.println("Время стандартной сортировки " + timeStandardSort + " миллисекунд");
    }
}