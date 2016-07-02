package io.soumasish;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Soumasish on 7/1/16.
 * This is a C++ STL-styled Multimap for Java which can handle duplicates.
 */

public class Multimap<K, V> {

    private int size;
    private HashMap<K, List<V>> map;


    public Multimap() {

        size = 0;
        map = new HashMap<>();

    }

    //puts a key-value pair into the multi-map
    public void put(K k, V v){
        size++;
        if(map.containsKey(k)){
            LinkedList<V> list = (LinkedList<V>) map.get(k);
            list.add(v);
            map.put(k, list);

        }else{
            List<V> list = new LinkedList<V>();
            list.add(v);
            map.put(k, list);
        }
    }

    //returns an iterator to the beginning of the list for the key k
    public Iterator<V> begin(K k){
        if(!map.containsKey(k)) return null;
        LinkedList<V> list = (LinkedList<V>) map.get(k);
        return list.iterator();
    }

    //returns an iterator to the end/reverse beginning of the list for the key k
    public Iterator<V> rbegin(K k){
        if(!map.containsKey(k)) return null;
        LinkedList<V> list = (LinkedList<V>) map.get(k);
        return list.listIterator(list.size());
    }

    //returns true if a key is present
    public boolean containsKey(K k){
        return map.containsKey(k);
    }
}
