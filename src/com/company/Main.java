package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 25; i++) {
            integerList.add(random.nextInt(25));
        }

        System.out.println("Исходный массив:");
        for (Integer i : integerList) {
            System.out.print(i + " ");
        }
        System.out.println();
        //System.out.println("");
        System.out.println("\nУдаляем дубликаты:");
        System.out.print(integerList.stream()             // - Удалить дубликаты
                .distinct()
                .collect(Collectors.toList()));      // почему нельзя вывести результат в другом цикле, если возвращаем коллекцию?


        System.out.println("\nВыводим все четные элементы в диапазоне от 7 до 17 (включительно):");
        System.out.print(integerList.stream()
                .filter(x -> ((x % 2 == 0) && (x >= 7 && x <= 17)))
                .collect(Collectors.toList()));


        System.out.println("\nКаждый элемент умножиаем на 2:");
        System.out.print(integerList.stream()             // - Каждый элемент умножить на 2
                .map(x -> x * 2)
                .collect(Collectors.toList()));

        System.out.println("\nСортируем и выводим на экран первых 4 элемента:");
        System.out.print(integerList.stream()
                .sorted()
                .limit(4)
                .collect(Collectors.toList()));

        System.out.println("\nВыводим количество элементов в стриме:");
        System.out.println(integerList.stream()
                .count());

        System.out.println("Выводим среднее арифметическое всех чисел в стриме:");
        System.out.println(integerList.stream()
                .mapToInt(x -> Integer.valueOf(x)).average()
                .getAsDouble());


        System.out.println("\n\nДополнительное задание");

        List<String> students = new ArrayList<>();
        Optional<Student> studentsTwo;
        AditionalTask aditionalTask = new AditionalTask();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введи свое имя: ");
        String name = scanner.next();

        students = aditionalTask.returnSameName(name);
        System.out.println("количество количество людей с введенным именем: " + students.size());
        students.clear();
        students = aditionalTask.returnNameWithLetter();
        System.out.println("все имена, начинающиеся на \"а\": ");

        studentsTwo = aditionalTask.returnFirstName();
        studentsTwo.stream().collect(Collectors.toList());
        System.out.println("Первый элемент отсортированной коллекции: ");

    }
}
