import java.util.Scanner;

public class AlgorithmsChessBoard {
    public static void main(String[] args) {
        // ввод
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        scanner.close();

        // создание матрицы шахматной доски
        int[][] matrix = new int[n][n];

        // математика:
        int numberOfCells = n*n; // общее количество клеток

        // проверка дополнительного условия
        boolean various = true;
        if ((k == 1 && n > 1)||k == 0 || k > 10) various = false;

        if ((numberOfCells % k == 0) && various) { // условие баланса цветов
            // инициализация матрицы
            int c = 0;
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                if(count < k) {
                    count++;
                    c = count;
                } else {
                    count = 0;
                    count++;
                    c = count;
                }
                for (int j = 0; j < matrix[i].length; j++) {
                    if (c <= k) {
                        matrix[i][j] = c;
                        c++;
                    } else {
                        c = 1;
                        matrix[i][j] = c;
                        c++;
                    }
                }
            }
            // вывод на консоль
            System.out.println("Yes");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No");
        }
    }
}