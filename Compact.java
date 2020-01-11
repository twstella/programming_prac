import java.util.ArrayList;
import java.util.HashMap;
public class Compact {
	static HashMap<String,Integer> map=new HashMap<String,Integer>();
	static ArrayList<Integer> num=new ArrayList<Integer>();
	public static int[] solution(String msg) {
		 for(char c='A';c<='Z';c++) {
			 map.put(""+c,c-'A'+1);
		 }
		 String w=""+msg.charAt(0);
		 for(int i=0;i<msg.length();i++) {
			 String t=w;
			 for(int j=i+1;j<msg.length();j++) {
				 t=w+msg.charAt(j);
				 if(map.containsKey(t)) { w=t;i=j;}
				 else break;
			 }
			 if(map.containsKey(w)) {
				 num.add(map.get(w));
				 int n=w.length();
				 if(i<msg.length()-1) {
					 w=w+msg.charAt(i+1);
				 }
				 map.put(w,map.size()+1);
				 w=w.substring(n);
			 }
		 }
		 int[] answer= new int[num.size()];
		 for(int i=0;i<num.size();i++)
			 answer[i]=num.get(i);
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="KAKAO";
		//String s="TOBEORNOTTOBEORTOBEORNOT";
		String s="ABABABABABABABAB";
		int[] t=solution(s);
		for(int i:t)
			System.out.println(i);
	}

}
