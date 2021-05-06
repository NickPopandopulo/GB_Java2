package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("test");
        list.add("string");
        List<String> list2 = new LinkedList<>(list);
        list = new ArrayList<>(list2);
        list.removeIf(s -> s.length() < 3);
        System.out.println(list);

        System.out.println(list.get(1));

        System.out.println(list.contains("a"));
        System.out.println(list.contains("b"));


        Map<String, String> map = new HashMap<>();
        map.put("aaa", "abc");
        map.put("bbb", "abc");
        map.put("cccc", "bce");
        map.put("dfsdf", "grt");
        map.put("tsdfsd", "ytregd");
        System.out.println(map);
        System.out.println(map.containsKey("c"));
        map.remove("b");
        System.out.println(map);

        for(String key : map.keySet()) {
            System.out.println("Key = " + key + " value = " + map.get(key));
        }


        System.out.println();
        System.out.println("----Set-----");
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("aaa");

        System.out.println(set);

        System.out.println();
        System.out.println("-----Iterable-----");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<String> emptyList = new ArrayList<>();


        List<String> strings =new LinkedList<>(Arrays.asList("A", "B", "A", "C", "A"));
        //пройти по списку и удалить все "A"
        strings.remove("A");
        Iterator<String> iter = strings.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.equals("A")) {
                iter.remove();
            }
        }
        System.out.println(strings);


    }


    static void oldMethod(String[] strings) {

    }


}
