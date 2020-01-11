package progrmmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Scoville {
	static int solution(int[] scoville,int K) {
		int answer=0,zero=0;
		PriorityQueue<Integer> pri=new PriorityQueue<Integer>();
		for(int j:scoville)
			pri.add(j);
		int cnt=0;
		while(true) {
			int t=pri.poll();
			if(t>=K) return cnt;
			if(pri.isEmpty()) return -1;
			int u=pri.poll();
			pri.add(t+2*u);
			cnt++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tmp= {0,0,0,1,1,1};
		int k=9;
		//int[] tmp= {2,3,5,7,10,12};
		//int k=10;
		System.out.print(solution(tmp,k));
	}

}
