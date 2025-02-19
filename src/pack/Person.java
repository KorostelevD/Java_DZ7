package pack;


// Визначення enum Gender
enum Gender {
    MALE,
    FEMALE
    }

public class Person {

    private String name;
    private int age;
    private Gender gender;

    // Конструктор
    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person  name ='" + name + "', age = " + age + ", gender = " + gender + ';';
    }
}

