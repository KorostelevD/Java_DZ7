package pack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        // Вывод результата
        System.out.println("Аble to work: ");
        workablePeople.forEach(System.out::println);
    }
}
