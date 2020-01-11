package progrmmers;

import java.util.ArrayList;

public class IronRod {
	static int solution(String arrangement) {
		int answer=0;
		int cnt=0;
		for(int i=0;i<arrangement.length()-1;i++) {
			char pre=arrangement.charAt(i);
			char tmp=arrangement.charAt(i+1);
			if(pre=='('&&tmp=='(') {
				cnt++;
			}
			else if(pre=='('&&tmp==')') {
				answer+=cnt;
			}
			else if(pre==')'&&tmp==')') {
				cnt--;
				answer+=1;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tmp="()(((()())(())()))(())";
		//String tmp="(((()())(())))";
		System.out.println(solution(tmp));
	}

}
