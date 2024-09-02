package pack;

public class User {
    private String name;
    private int age;

    // Конструктор
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User  name = " + name + "', age = " + age + ';';
    }
}
