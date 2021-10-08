package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Эта программа выводит простые числа из массива");
        int arraySize = readArraySize();
        int[] array = readArray(arraySize);
        System.out.print("Простые числа: ");
        getPrimeNumbers(array);
    }

    public static int readArraySize(){
        int arraySize = 0;
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader("E:\\ОАиП\\ЛР2\\Java\\LR2.4\\InputData.txt"));
            arraySize = Integer.parseInt(input.readLine());
        } catch (FileNotFoundException e){
            System.err.println("File is not found");
        } catch (IOException e){
            e.getMessage();
        } finally {
            try {
                input.close();
            } catch (IOException e){
                e.getMessage();
            }
        }
        return arraySize;
    }



    public static int[] readArray(int arraySize){
        BufferedReader reader = null;
        int[] array = new int[arraySize];
        try {
            reader = new BufferedReader(new FileReader("E:\\ОАиП\\ЛР2\\Java\\LR2.4\\InputData.txt"));
            array = new int[Integer.parseInt(reader.readLine())];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(reader.readLine());
            }
        } catch (FileNotFoundException e){
            System.err.println("Input file is not found");
        } catch (IOException e){
            e.getMessage();
        } finally {
            try {
                reader.close();
            } catch (IOException e){
                e.getMessage();
            }
        }
        return array;
    }

    public static void getPrimeNumbers(int[] array) {
        String primeNumber = "";
        int counter;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                counter = 0;
                for (int j = 2; j < array[i]; j++) {
                    if (array[i] % j == 0) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    primeNumber += array[i] + " ";
                }
            }
        }
        output(primeNumber);
    }

    public static void output(String primeNumber){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("E:\\ОАиП\\ЛР2\\Java\\LR2.4\\OutputData.txt"));
            writer.write(primeNumber + " ");
        } catch (FileNotFoundException e){
            System.err.println("Output file is not found");
        } catch (IOException e){
            e.getMessage();
        } finally {
            try {
                writer.close();
            } catch (IOException e){
                e.getMessage();
            }
        }
        System.out.println(primeNumber);
    }

    /* public static int checkInputData() {
        int number = 0;
        boolean isInCorrect;
        Scanner input = new Scanner(System.in);
        do {
            isInCorrect = false;
            try {
                number = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                isInCorrect = true;
                System.err.print("It's not a number: ");
            }
            if (number < 1 && isInCorrect == false){
                isInCorrect = true;
                System.err.print("Enter plural number: ");
            }
        } while (isInCorrect);
        return number;
    } */
}
