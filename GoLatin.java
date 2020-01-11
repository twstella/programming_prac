import java.util.HashMap;
import java.util.Scanner;
public class GoLatin {
	static HashMap<String,String> map=new HashMap<String,String>();
	static void init() {
		map.put("a","as"); map.put("i","ios");map.put("y","ios");
		map.put("l","les");map.put("n","anes");map.put("ne","anes");
		map.put("o","os");map.put("r","res");map.put("t","tas");
		map.put("u","us");map.put("v","ves");map.put("w","was");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		String[] ans=new String[t];
		init();
		for(int i=0;i<t;i++) {
			String tmp=s.next();
			String a=tmp.substring(tmp.length()-1);//last letter
			String b=tmp.substring(tmp.length()-2);//last two letters
			if(map.containsKey(a)) {
				ans[i]=tmp.substring(0,tmp.length()-1)+map.get(a);
			}
			else if(map.containsKey(b)) {
				ans[i]=tmp.substring(0,tmp.length()-2)+map.get(b);
			}
			else {
				ans[i]=tmp+"us";
			}
		}
		s.close();
		for(String a:ans) {
			System.out.println(a);
		}
	}

}
