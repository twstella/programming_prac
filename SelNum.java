package codeGround;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
public class SelNum {
	static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	static int Answer=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner key=new Scanner(System.in);
		T=key.nextInt();
		for(int i=0;i<T;i++) {
			int n=key.nextInt();
			for(int j=0;j<n;j++) {
				int tmp=key.nextInt();
				int cnt=1;
				if(map.containsKey(tmp)) {
					cnt=map.get((Integer)tmp)+1;
				}
				map.put(tmp,(Integer)cnt);
			}
			Set<Integer> set=map.keySet();
			for(Integer t:set) {
				int cnt=map.get(t);
				if(cnt%2==0)
					continue;
				Answer=Answer^t;
			}	
			System.out.println("Case #"+(i+1));
			System.out.println(Answer);
		}

	}

}
