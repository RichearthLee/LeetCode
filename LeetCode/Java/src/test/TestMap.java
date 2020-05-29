package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.math.*;
public class TestMap {

    public static void main(String[] args) {
//        int[] nums = {2,1,3,3,0};
//        testTreeMap(nums);
        Math.min(1,2);
        TreeMap<Integer, Integer> treeMapmap = new TreeMap<>();
        treeMapmap.put(null,1);
        treeMapmap.getOrDefault(null,0);

        ConcurrentHashMap chm = new ConcurrentHashMap();
        chm.put("1",1);

        HashSet<Integer> hs = new HashSet<>();

        Hashtable ht = new Hashtable();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(null,1);
        map1.getOrDefault(null,0);

        LinkedHashMap<Integer, Integer> lmap  = new LinkedHashMap<>();
        lmap.put(1,1);
        lmap.put(2,2);
        lmap.put(3,3);
        lmap.remove(1);
        lmap.put(1,-1);
        lmap.remove(4);
        printMap(lmap);
    }

    public static void testTreeMap(int[] nums){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int key : nums){
            map.put(key, Math.max(map.getOrDefault(key, 0), key));
        }
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            System.out.println(en.getKey());
        }
    }

    public static void printMap(Map map){
//        for (Map.Entry entry: map.entrySet()) {
//        }
        Iterator<Map.Entry> entries = map.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry entry = entries.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

}
