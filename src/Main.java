import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[][] nums = new int[SIZE][SIZE];

        while (true) {
            int inputChoice = 0;

            System.out.println("Выбирайте поворот градуса матрицы: ");
            System.out.println("1- 90  /  2- 180  /  3-  270   /  0-  Выход");
            inputChoice = scanner.nextInt();

            if (inputChoice == 0) {
                break;
            }

            rotateMatrix(nums, random, inputChoice);
        }
        System.out.println("Программа завершена");

    }

    public static void rotateMatrix(int[][] numsNew, Random random, int inputChoiceNew) throws InterruptedException {

        int[][] nums2 = new int[SIZE][SIZE];
        int[][] nums3 = new int[SIZE][SIZE];
        int[][] nums4 = new int[SIZE][SIZE];

        if (inputChoiceNew != 0) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    numsNew[i][j] = random.nextInt(9);
                }
            }
            printMatrix(numsNew, SIZE);
            System.out.println();
        }

        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            count++;
            for (int j = 0; j < SIZE; j++) {
                nums2[j][i] = numsNew[SIZE - count][j];
            }
        }

        if (inputChoiceNew == 1) {
            System.out.println("--- Матрица повернута 90 градусов ---");
            printMatrix(nums2, SIZE);
            System.out.println();
        }

        int count2 = 0;
        for (int i = 0; i < SIZE; i++) {
            count2++;
            for (int j = 0; j < SIZE; j++) {
                nums3[j][i] = nums2[SIZE - count2][j];
            }
        }

        if (inputChoiceNew == 2) {
            System.out.println("--- Матрица повернута 180 градусов ---");
            printMatrix(nums3, SIZE);
            System.out.println();
        }

        int count3 = 0;
        for (int i = 0; i < SIZE; i++) {
            count3++;
            for (int j = 0; j < SIZE; j++) {
                nums4[j][i] = nums3[SIZE - count3][j];
            }
        }

        if (inputChoiceNew == 3) {
            System.out.println("--- Матрица повернута 270 градусов ---");
            printMatrix(nums4, SIZE);
            System.out.println();
        }
    }

    public static void printMatrix(int[][] numsNew, int sizeNew) throws InterruptedException {
        for (int i = 0; i < sizeNew; i++) {
            for (int j = 0; j < sizeNew; j++) {
                System.out.format("%3d",numsNew[i][j]);
                Thread.sleep(100);
            }
            System.out.println();
        }
    }

}