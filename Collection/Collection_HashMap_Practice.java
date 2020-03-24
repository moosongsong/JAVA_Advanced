package Part14Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.omg.CORBA.portable.ValueBase;


public class Collection_HashMap_Practice {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();//타입 미지정시 모두 오브젝트
		
		hm.put(1, "Jin");
		hm.put(2, "Suga");
		hm.put(3, "Hope");//덮어쓰기 됨.
		hm.put(3, "RM");
		
		Set<Integer> keys = hm.keySet();
		
		Iterator <Integer> it = keys.iterator();
		while(it.hasNext()) {
			int i = it.next();
			System.out.println(hm.get(i));
		}
		
		Set<Map.Entry<Integer, String>>entrySet = hm.entrySet();
		Iterator<Map.Entry<Integer, String>>entryIt = entrySet.iterator();
		while(entryIt.hasNext()) {
			Map.Entry<Integer, String> i = entryIt.next();
			System.out.println(i.getKey() +", " + i.getValue());
		}
		
		it = keys.iterator();
		//delete
		//3
//		Integer key =null;
//		String value = null;
//		while(it.hasNext()) {
//			int i = it.next();
//			if(i==2) {
//				key =i;
//				value = hm.get(i);
//			}
//		}
//		if(key !=null) {
//			hm.remove(key, value);
//		}
		//1
		String str = hm.get(2);
		if(str!=null) {
			hm.remove(str);
		}
		//2
		if(hm.containsKey(2)) {
			hm.remove(2);
		}
		
		if(hm.containsKey(1)) {
			System.out.println(hm.get(1));
		}
		else {
			System.out.println("there is no entry whose key is \'1\'");
		}
		//Using containskey
		if(hm.containsKey(4)) {
			System.out.println(hm.get(4));
		}
		else {
			System.out.println("there is no entry whose key is \'4\'");
		}
		//Using get
//		String value = hm.get(4);
//		if(value != null) {
//			System.out.println(value);
//		}
//		else {
//			System.out.println("Fail");
//		}
		
		it = keys.iterator();
		while(it.hasNext()) {
			int i = it.next();
			System.out.println(hm.get(i));
		}
	}

}
