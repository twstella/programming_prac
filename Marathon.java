package progrmmers;

import java.util.HashMap;
import java.util.Set;

public class Marathon {
	static HashMap<String,Integer>map=new HashMap();
	static String solution(String[] participant,String[] completion) {
		String answer="";
		for(int i=0;i<participant.length;i++) {
			if(!map.containsKey(participant[i]))
				map.put(participant[i], Integer.parseInt("1"));
			else
				map.replace(participant[i],map.get(participant[i])+1);
		}
		for(int j=0;j<completion.length;j++) {
			if(map.get(completion[j])==1) {
				map.remove(completion[j]);
			}
			else
				map.replace(completion[j],map.get(completion[j])-1);
		}
		Set<String> s=map.keySet();
		String[] set=s.toArray(new String[0]);
		answer=set[0];
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant={"leo","kiki","eden"};
		String[] completion= {"eden","kiki"};
		System.out.print(solution(participant,completion));
	}

}
