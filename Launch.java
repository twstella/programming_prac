package progrmmers;

import java.util.Vector;
public class Launch {
	static int[] solution(int[] progresses,int[] speeds) {
		
		Vector<Integer> vec=new Vector<Integer>();
		int[] days=new int[speeds.length];
		for(int i=0;i<speeds.length;i++)
			days[i]=(100-progresses[i]+speeds[i]-1)/speeds[i];
		int cnt=0,j=0;
		while(j<speeds.length) {
			int k=j;
			while(k<speeds.length&&days[j]>=days[k]) {
				cnt++;
				k++;
			}
			j=k;
			vec.add(cnt);
			cnt=0;
		}
		int[] answer= new int[vec.size()];
		int t=0;
		for(int s:vec) {
			answer[t++]=s;
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] progresses= {93,30,55};
		//int[] speeds= {1,30,5};
		//int[] progresses= {50,60,20};
		//int[] speeds= {10,6,8};
		int[] progresses= {30,25,60,90};
		int[] speeds= {3,5,6,10};
		int[] tmp=solution(progresses,speeds);
		for(int i=0;i<tmp.length;i++)
			System.out.print(tmp[i]+" ");
	}

}
