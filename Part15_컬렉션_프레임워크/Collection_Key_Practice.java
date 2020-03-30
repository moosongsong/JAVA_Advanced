package Part14Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MyKey{
	private int key;

	public MyKey(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "MyKey [key=" + key + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(!(this.getClass().getName().equals(obj.getClass().getName()))) {
			return false;
		}
		if(this.key != ((MyKey)obj).key) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int code = 1;
		code =prime * code + this.key;
		return code;
	}
}

class MyValue{
	private String value;

	public MyValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyValue [value=" + value + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(!(this.getClass().getName().equals(obj.getClass().getName()))) {
			return false;
		}
		
		if(this.value == null) {
			if(((MyValue)obj).value != null) {
				return false;
			}
		}
		else {
			if(((MyValue)obj).value == null) {
				return false;
			}
		}
		if(this.value.equals(((MyValue)obj).value)) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int code = 1;
		code =prime * code + value.hashCode();
		return code;
	}
}

public class Collection_Key_Practice {

	public static void main(String[] args) {
		HashMap<MyKey, MyValue>hm = new HashMap<MyKey, MyValue>();
		hm.put(new MyKey(1), new MyValue("TaeTae"));
		hm.put(new MyKey(2), new MyValue("Suga"));
		hm.put(new MyKey(3), new MyValue("Hope"));//덮어써짐
		hm.put(new MyKey(3), new MyValue("Jin"));//해쉬코드를 구현하면 키가 3인거 하나밖에 들어가지 않는다.
		
		System.out.println(new MyKey(3).equals(new MyKey(3)));//equals 로 키 비교가 불가능하다.
		//즉 해시코드에 대해서 Key가 오버라이딩 되어 있어야 한다. 즉 해쉬코드까지 같아야 같은 객체이다.
		//물론 equals 를 오버라이딩 해야한다.
		//equals 비교 ->  해쉬코드 비교 -> 최종 승인
		
		Set <Map.Entry<MyKey, MyValue>> entrySet = hm.entrySet();
		Iterator<Map.Entry<MyKey, MyValue>> it = entrySet.iterator();
		
		while(it.hasNext()) {
			Map.Entry<MyKey, MyValue> entry = it.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		System.out.println("====DELETE====");
		hm.remove(new MyKey(1), new MyValue("TaeTae"));
		it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<MyKey, MyValue> entry = it.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}