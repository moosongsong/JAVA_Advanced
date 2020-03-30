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
		hm.put(new MyKey(3), new MyValue("Hope"));//�������
		hm.put(new MyKey(3), new MyValue("Jin"));//�ؽ��ڵ带 �����ϸ� Ű�� 3�ΰ� �ϳ��ۿ� ���� �ʴ´�.
		
		System.out.println(new MyKey(3).equals(new MyKey(3)));//equals �� Ű �񱳰� �Ұ����ϴ�.
		//�� �ؽ��ڵ忡 ���ؼ� Key�� �������̵� �Ǿ� �־�� �Ѵ�. �� �ؽ��ڵ���� ���ƾ� ���� ��ü�̴�.
		//���� equals �� �������̵� �ؾ��Ѵ�.
		//equals �� ->  �ؽ��ڵ� �� -> ���� ����
		
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