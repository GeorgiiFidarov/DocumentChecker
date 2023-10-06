package ru.fidarov;

import java.io.*;
import java.util.*;

public class Main {
    private static final String PATH = "/home/georgii/Desktop/DocumentChecker/src/main/resources/";

    public static void main(String[] args) {
        System.out.println("Введите пожалуйста имя файла который вы хотите прочитать из папаки resources");
        Scanner scan = new Scanner(System.in);
        String fileName = scan.nextLine();

        try {
            Set<Character> uniqueCharacters = makeUnique(PATH+fileName+".txt");
            for (char c : uniqueCharacters) {
                System.out.print(c + ", ");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static Set<Character> makeUnique(String fileName) throws IOException {
        Set<Character> uniqueCharacters = new LinkedHashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int charCode;
            while ((charCode = reader.read()) != -1) {
                char character = (char) charCode;
                if (Character.isLetter(character)) {
                    uniqueCharacters.add(Character.toUpperCase(character));
                }
            }
        }

        return uniqueCharacters;
    }
}