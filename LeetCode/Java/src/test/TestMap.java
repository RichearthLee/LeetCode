package test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {

    public static void main(String[] args) {
//        int[] nums = {2,1,3,3,0};
//        testTreeMap(nums);

        TreeMap<Integer, Integer> treeMapmap = new TreeMap<>();
        treeMapmap.put(null,1);
        treeMapmap.getOrDefault(null,0);

        ConcurrentHashMap chm = new ConcurrentHashMap();
        chm.put("1",1);

        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(null,1);
        map1.getOrDefault(null,0);
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

}
