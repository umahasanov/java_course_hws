package streamapi;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


public class Streams<T> {
    private List<T> data = new ArrayList<>();

    public Streams() {
    }

    public Streams(Collection<? extends T> data) {
        this.data = new ArrayList<>(data);
    }

    public static <T> Streams<T> of(Collection<? extends T> someCollection) {
        return new Streams<T>(someCollection);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        Streams<T> filteredStream = new Streams<>();
        for(T t : data)
            if(predicate.test(t))
                filteredStream.data.add(t);
        return filteredStream;
    }

    public <R> Streams<R> transform(Function<? super T, ? extends R> transformUnit) {
        Streams<R> transformedStream = new Streams<>();
        for(T t : data)
            transformedStream.data.add(transformUnit.apply(t));
        return transformedStream;
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyMapUnit, Function<? super T, ? extends V> valueMapUnit) {
        Map<K, V> map = new HashMap<K, V>();
        for(T t : data)
            map.put(keyMapUnit.apply(t), valueMapUnit.apply(t));
        return map;
    }
}
