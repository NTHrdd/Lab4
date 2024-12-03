package ru.Khismatov.Compare;

public class Person implements Comparable<Person> {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
