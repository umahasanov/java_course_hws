package countmap;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 23.12.16.
 */
public class CountMapImpl<E> implements CountMap<E> {

    Map<E, java.lang.Integer> map = new ConcurrentHashMap<>();

    @Override
    public void add(E k) {
        if (map.get(k) == null) {
            map.put(k, 1);
        } else {
            map.put(k, map.get(k) + 1);
        }
    }

    @Override
    public int getCount(E e) {
        if (map.get(e) == null) {
            return 0;
        } else {
            return map.get(e);
        }
    }

    @Override
    public int remove(E e) {
        int a = map.get(e);
        map.remove(e);
        return a;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {

        Set<Map.Entry<E, Integer>> set = map.entrySet();
        Map<E, Integer> sourseMap = source.toMap();
        Set<Map.Entry<E, Integer>> set1 = sourseMap.entrySet();
        for (Map.Entry<E, Integer> entry : set) {
            for (Map.Entry<E, Integer> entry1 : set1) {
                E e = entry.getKey();
                E e2 = entry1.getKey();
                if (e == e2) {
                    map.put(entry1.getKey(), entry.getValue() + entry1.getValue());
                    sourseMap.remove(e2);
                    break;
                }
            }
        }
        for (Map.Entry<E, Integer> entry1 : set1) {
            E e2 = entry1.getKey();
            map.put(e2, entry1.getValue());
        }
    }

    @Override
    public Map toMap() {
        return map;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        Set<Map.Entry<E, Integer>> set = map.entrySet();
        for (Map.Entry<E, Integer> entry : set) {
            destination.put(entry.getKey(), entry.getValue());
        }
    }
}

