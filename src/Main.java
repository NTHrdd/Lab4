import ru.Khismatov.Boxes.Box;
import ru.Khismatov.Compare.Person;
import ru.Khismatov.ListUtils.ListUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        do{
            System.out.println("Enter number of task: ");
            n = scan.nextInt();
            switch(n){
                case 1:
                    Box<Integer> box = new Box<>();
                    try {
                        System.out.println("Enter number which be put in box: ");
                        box.put(scan.nextInt());
                        System.out.println("Box is empty: " + box.isEmpty());
                        int value = box.get();
                        System.out.println("Extracted value: " + value);
                        System.out.println("Box is empty: " + box.isEmpty());
                        box.get();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    Person person1 = new Person("Egor", 25);
                    Person person2 = new Person("Seva", 21);
                    if (person1.compareTo(person2) > 0) {
                        System.out.println("Person 1 is elder than Person 2.");
                        System.out.println("Difference: " + person1.compareTo(person2));
                    }
                    else if (person1.compareTo(person2) < 0) {
                        System.out.println("Person 1 is younger than Person 2.");
                        System.out.println("Difference: " + person2.compareTo(person1));
                    }
                    else {
                        System.out.println("Person 1 and Person 2 have same age.");
                    }
                    break;
                case 3:
                    Box<Integer> box1 = new Box();
                    Box<Float> box2 = new Box();
                    Box<Double> box3 = new Box();
                    try{
                        box1.put(3);
                        box2.put(20.5F);
                        box3.put(16.4);
                        List<Box<? extends Number>> boxes = List.of(box1, box2, box3);
                        System.out.println("Maximum value is " + Box.findMaxValue(boxes));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Length of strings: " + ListUtils.transform(List.of("qwerty", "asdfg", "zx"), String::length));
                    System.out.println("Absolute values: " + ListUtils.transform(List.of(1, -3, 7), Math::abs));
                    System.out.println("Max value: " + ListUtils.transform(List.of(List.of(1, 2, 3), List.of(-5, -3, 0), List.of(8, 7, 9)), list -> list.stream().max(Integer::compareTo).orElseThrow()));
                    break;
                case 5:
                    System.out.println("Stings have less 3 letters: " + ListUtils.filter(List.of("qwerty", "asdfg", "zx"), x -> x.length() < 3));
                    System.out.println("Positive numbers: " + ListUtils.filter(List.of(1, -3, 7), x -> x > 0));
                    System.out.println("Lists with only negative numbers: ");
                    for (List<Integer> list : ListUtils.filter(List.of(List.of(1, -2, 3), List.of(-1, -2, -3), List.of(0, -4, -5)), list -> list.stream().allMatch(x -> x < 0))) {
                        System.out.println(list);
                    }
                    break;
                case 6:
                    System.out.println("Concatenated string: " + ListUtils.reduce(List.of("qwerty", "asdfg", "zx"), (a, b) -> a + b, ""));
                    System.out.println("Sum: " + ListUtils.reduce(List.of(1, -3, 7), (a, b) -> a + b, 0));
                    System.out.println("Total elements: " + ListUtils.reduce(List.of(List.of(1, 2), List.of(3, 4, 5), List.of(6)), (a, b) -> a + b.size(), 0));
                    break;
                case 7:

                    break;
            }
        } while (n != 8);
    }
}