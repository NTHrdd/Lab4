package ru.Khismatov.Boxes;

import java.util.List;

public class Box<T> {
    private T value;

    public void put(T obj) throws Exception {
        if (value != null){
            throw new Exception("Object already exists");
        }
        this.value = obj;
    }

    public T get() throws Exception {
        if (value == null){
            throw new Exception("Object not exists");
        }
        T temp = value;
        value = null;
        return temp;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public static double findMaxValue(List<Box<? extends Number>> list) throws Exception {
        if (list.isEmpty()){
            throw new Exception("List is empty");
        }
        double max = Double.NEGATIVE_INFINITY;
        for (Box<? extends Number> box : list){
            Number value = box.get();
            if (max < value.doubleValue()){
                max = value.doubleValue();
            }
        }
        return max;
    }
}
