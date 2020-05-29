package utility;

import java.util.*;

public class LRUCache{

    class LRUCacheV1 {

        private int capacity;
        private HashMap<Integer, Integer> map;
        private Queue<Integer> qu;

        public LRUCacheV1(int capacity) {
            this.capacity = capacity;
            qu = new LinkedList<>();
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if(map.containsKey(key)){
                qu.remove(key);
                qu.offer(key);
            }
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
            qu.remove(key);
            qu.offer(key);
            if(map.size() > capacity){
                map.remove(qu.poll());
            }
        }
    }


    class LRUCacheV2 extends LinkedHashMap<Integer, Integer>{
        private int capacity;

        public LRUCacheV2(int capacity) {
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


}
