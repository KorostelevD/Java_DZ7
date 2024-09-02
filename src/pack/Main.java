package pack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        // Колекція людей
        System.out.println("All person: ");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ivan", 25, Gender.MALE));
        people.add(new Person("Anna", 30, Gender.FEMALE));
        people.add(new Person("Oleg", 67, Gender.MALE));
        people.add(new Person("Olga", 59, Gender.FEMALE));
        people.add(new Person("Vladimir", 64, Gender.MALE));
        people.add(new Person("Elena", 17, Gender.FEMALE));
        people.add(new Person("Dmytro", 36, Gender.FEMALE));
        people.add(new Person("Oksana", 61, Gender.FEMALE));

        //Всі персони
        people.forEach(System.out::println);
        System.out.println();


        // Працездатні люди
        List<Person> workablePeople = people.stream()
                .filter(person -> person.getAge() >= 18) // Минимальный возраст для работы
                .filter(person -> (person.getGender() == Gender.MALE && person.getAge() < 65) ||
                        (person.getGender() == Gender.FEMALE && person.getAge() < 60))
                .collect(Collectors.toList());

        System.out.println("Аble to work: ");
        workablePeople.forEach(System.out::println);



    /////////////////////////  2  ///////////////////////////////////
        System.out.println();
        System.out.println("//// 2 ////");
        System.out.println();
        // Колекція користувачів

        List<User> users = new ArrayList<>();
        users.add(new User("Jack1", 23));
        users.add(new User("Harry", 31));
        users.add(new User("Charlie12", 18));
        users.add(new User("Thomas", 32));
        users.add(new User("Amelia33", 30));
        users.add(new User("Olivia3", 19));
        users.add(new User("Emily", 18));
        users.add(new User("Sophie", 25));

        // 1. Сортування  за алфавітом
        System.out.println("Сортування за алфавітом: ");
        List<User> sortedUsers = users.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());
        sortedUsers.forEach(System.out::println);
        System.out.println();

        // 2. Користувачі, імена яких не містять чисел
        List<User> usersWithoutNumbers = sortedUsers.stream()
                .filter(user -> !user.getName().matches(".*\\d.*"))
                .collect(Collectors.toList());
        System.out.println("Користувачі без чисел в імені:");
        usersWithoutNumbers.forEach(System.out::println);

        // 3. Підрахунок користувачів з числами в іменах
        long countWithNumbers = sortedUsers.stream()
                .filter(user -> user.getName().matches(".*\\d.*"))
                .count();

        System.out.println("Кількість користувачів з числами в іменах: " + countWithNumbers);

        // 4. Отримання  Map,
        Map<String, Integer> userMap = sortedUsers.stream()
                .collect(Collectors.toMap(User::getName, User::getAge));
        System.out.println();
        System.out.println("Мапа користувача (Ім'я -> Вік):");
        userMap.forEach((name, age) -> System.out.println(name + " -> " + age));

        System.out.println();
        System.out.println("//////////// 3 /////////////");
        System.out.println();

   /////////////////////////////// 3 ///////////////////////////////////////////////////////////////////
        String text = "Еней був парубок моторний "
                + "І хлопець хоть куди козак,"
                + "Удавсь на всеє зле проворний,"
                + "Завзятіший од всіх бурлак.";

        // 1. Перетворення строки в колекцію речень
        List<String> sentences = Arrays.stream(text.split("(?<=[.!?])\\s*"))
                .collect(Collectors.toList());

        // 2. Перетворення строки в колекцію слів
        List<String> words = Arrays.stream(text.split("[\\P{IsCyrillic}]+"))
                .collect(Collectors.toList());

        // 3. Перетворення строки в масив
        char[] characters = text.replace(" ", "").toCharArray();


        System.out.println("Колекція речень:");
        sentences.forEach(System.out::println);


        System.out.println("\nКолекція слів:");
        words.forEach(System.out::println);


        System.out.println("\nМасив символів:");
        System.out.println(Arrays.toString(characters));

        // 4. Підрахунок кількості
        long sentenceCount = sentences.size();
        long wordCount = words.size();
        long charCount = characters.length;


        System.out.println("\nКількість речень: " + sentenceCount);
        System.out.println("Кількість слів: " + wordCount);
        System.out.println("Кількість символів (без пробілів): " + charCount);

        /////////////////// 4 ///////////////////////////////////////////////

        System.out.println();
        System.out.println("/////////////// 4 //////////////////////");
        System.out.println();

        // 1. Генерація числел від 0 до 100
        Random random = new Random();
        int[] numbers = random.ints(100, 0, 101).toArray();

        // 2. Створення  стріма
        System.out.println("Сгенеровані числа:");
        IntStream.of(numbers).forEach(System.out::println);

        // 3. Подсчет различных статистических данных
        long count = IntStream.of(numbers).count();
        long evenCount = IntStream.of(numbers).filter(n -> n % 2 == 0).count();
        long oddCount = IntStream.of(numbers).filter(n -> n % 2 != 0).count();
        int max = IntStream.of(numbers).max().orElse(Integer.MIN_VALUE);
        int min = IntStream.of(numbers).min().orElse(Integer.MAX_VALUE);
        double average = IntStream.of(numbers).average().orElse(0.0);
        int sum = IntStream.of(numbers).sum();


        System.out.println("\nСтатистика:");
        System.out.println("Кількість усіх чисел: " + count);
        System.out.println("Кількість парних чисел: " + evenCount);
        System.out.println("Кількість непарних чисел: " + oddCount);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Мінімальне значення: " + min);
        System.out.println("Середнє значення : " + average);
        System.out.println("Сума всіх чисел: " + sum);

        // 4. Получение коллекции чисел от 30 до 60 индекса и вывод в консоль
        List<Integer> subList = IntStream.of(numbers)
                .skip(30)
                .limit(31)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\nЧисла від 30 до 60 індексу:");
        subList.forEach(System.out::println);
    }

}
