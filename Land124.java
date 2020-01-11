import java.util.HashMap;
public class Land124 {
	static HashMap<Integer,String> map=new HashMap<Integer,String>();
	static String func(int n) {
		if(n==0) return "";
		else {
			if(map.containsKey(n)) return map.get(n);
			else {
				String str="";
				if(n%3==0) {
					str=func(n/3-1);
					str+="4";
				}
				else if(n%3==1) {
					str=func(n/3);
					str+="1";
				}
				else if(n%3==2) {
					str=func(n/3);
					str+="2";
				}
				map.put(n,str);
				return str;
			}
		}
	}
	public static String solution(int n) {
	      String answer = func(n);
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=39;i++) {
			System.out.println(solution(i));
		}
	}

}
