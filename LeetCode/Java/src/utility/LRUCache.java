package utility;

import java.util.*;

class LRUCache extends LinkedHashMap<Integer, Integer>{

//    private int capacity;
//    private HashMap<Integer, Integer> map;
//    private Queue<Integer> qu;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        qu = new LinkedList<>();
//        map = new HashMap<>(capacity);
//    }
//
//    public int get(int key) {
//        if(map.containsKey(key)){
//            qu.remove(key);
//            qu.offer(key);
//        }
//        return map.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        map.put(key, value);
//        qu.remove(key);
//        qu.offer(key);
//        if(map.size() > capacity){
//            map.remove(qu.poll());
//        }
//    }

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }


}
