package ru.Khismatov.ListUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public class ListUtils {
    public static <T, P> List<P> transform(List<T> list, Function<T, P> transformer) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(transformer.apply(item));
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T, R> R reduce(List<T> values, BiFunction<R, T, R> function, R initial) {
        R result = initial;
        for (T value : values) {
            result = function.apply(result, value);
        }
        return result;
    }

    public static <T, P extends Collection<T>> P collect(List<T> sourceList, Supplier<P> collectionSupplier, Function<T, Boolean> classifier) {
        P collection = collectionSupplier.get();
        for (T element : sourceList) {
            if (classifier.apply(element)) {collection.add(element);}
        }
        return collection;
    }
}
