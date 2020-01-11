package progrmmers;

import java.util.HashMap;
import java.util.Set;

public class Camouflage {
	static HashMap<String,Integer> map=new HashMap();
	static int solution(String[][] clothes) {
		int answer=1;
		for(int i=0;i<clothes.length;i++) {
			if(!map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], Integer.parseInt("1"));
			}
			else {
				map.replace(clothes[i][1],map.get(clothes[i][1])+1);
			}
		}
		Set<String> tmp=map.keySet();
		String[] item=tmp.toArray(new String[0]);
		for(int j=0;j<map.size();j++) {
			answer*=(map.get(item[j])+1);
		}
		return answer-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tmp= {{"yello_hat","headgear"},{"blue_sunglass","eyewear"},{"green_turban","headgear"}};
		System.out.print(solution(tmp));
	}

}
