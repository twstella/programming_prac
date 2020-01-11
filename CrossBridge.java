package progrmmers;

import java.util.ArrayList;

public class CrossBridge {
	static int solution(int bridge_len,int weight,int[] truck_weight) {
		int ans=0;
		ArrayList<Integer> bridge=new ArrayList<Integer>();
		int idx=0,pass=0,sum=0;
		for(int j=0;j<bridge_len;j++)
			bridge.add(0);
		while(pass<=truck_weight.length&&idx<truck_weight.length) {
			int a=truck_weight[idx];
			if((sum+a)<=weight) {
				bridge.add(0,a);
				sum+=a;
				idx++;
			}
			else {
				bridge.add(0,0);
			}
			if(bridge.get(bridge_len-1)==truck_weight[pass]) {
				pass++;
				sum-=bridge.get(bridge_len-1);
			}
		}
		ans=bridge.size();
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] tmp= {7,4,5,6};
		//int[] tmp= {10};
		int[] tmp= {10,10,10,10,10,10,10,10,10,10};
		//System.out.print(solution(2,10,tmp));
		//System.out.print(solution(100,100,tmp));
		System.out.print(solution(100,100,tmp));
	}

}
