package Part14Main;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class Collection_TreeMap_Practice {

	public static void main(String[] args) {
		
		TreeMap <Integer, String> map = new TreeMap<>();
		map.put(100, "JIN");
		map.put(200, "SUGA");
		map.put(150, "HOPE");
		map.put(160, "JIMIN");
		map.put(180, "RM");
		map.put(179, "JK");
		map.put(203, "V");
		
		Set<Integer> keySet = map.keySet();
		Iterator<Integer>it = keySet.iterator();
		
		while(it.hasNext()) {
			int key=it.next();
			System.out.println(key+" : "+map.get(key));
		}
		
		System.out.println("========");
		
		NavigableSet <Integer> nvkeySet = map.descendingKeySet();
		Iterator<Integer>it2 = nvkeySet.iterator();
		
		while(it2.hasNext()) {
			int key=it2.next();
			System.out.println(key+" : "+map.get(key));
		}
		
		System.out.println("========");
		
		NavigableMap <Integer, String> nvMap = map.descendingMap();
		Set<Integer>kset = nvMap.keySet();
		Iterator<Integer> nkey = kset.iterator();
		
		while( nkey.hasNext()) {
			int key= nkey.next();
			System.out.println(key+" : "+map.get(key));
		}
		
	}

}
