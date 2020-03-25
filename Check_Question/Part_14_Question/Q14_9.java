package Part_14_Question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Q14_9 {

	public static void main(String[] args) {
		Map<String, Integer>map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name =null;
		int maxScore = 0;
		int totalScore =0;
		Set <String>keySet = map.keySet();
		Iterator<String>it = keySet.iterator();
		
		while(it.hasNext()) {
			String temp =null;
			temp = it.next();
			totalScore+=map.get(temp);
			if(map.get(temp)>maxScore) {
				maxScore=map.get(temp);
				name=temp;
			}
		}
		
		System.out.println("평균점수:"+totalScore/map.size());
		System.out.println("최고점수:"+maxScore);
		System.out.println("최고점수를 받은 아이디:"+name);
	}

}
