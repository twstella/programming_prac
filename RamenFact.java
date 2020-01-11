package progrmmers;
import java.util.PriorityQueue;
public class RamenFact {
	static int solution(int stock,int[] dates,int[] supplies,int k) {
		int ans=0;
		PriorityQueue<Integer> que=new PriorityQueue<Integer>();
		int i=0,j=stock;
		int cnt=0;
		while(j<k) {
			while(i<dates.length&&dates[i]<=j) {
				que.add(-supplies[i]);
				i++;
			}
			int e=-que.poll();
			cnt++;
			j=j+e;
		}
		ans=cnt;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dates= {4,10,15};
		int[] supplies= {20,5,10};
		System.out.print(solution(4,dates,supplies,30));
	}

}
