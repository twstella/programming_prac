package progrmmers;
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;
class Work implements Comparable{
	int request;
	int duration;
	Work(int r,int d){
		request=r;
		duration=d;
	}
	public int compareTo(Object t) {
		Work w=(Work)t;
		int r=duration-w.duration;
		if(r!=0) return r;
		else return request-w.request;
	}
}
public class Scheduling {
	static int solution(int[][] jobs) {
		int answer=0;
		Arrays.sort(jobs,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				return o1[0]-o2[0];
			}
		});
		PriorityQueue<Work> que=new PriorityQueue<Work>();
		int idx=0,sum=0,loc=0;
		while(true) {
			if(idx>=jobs.length&&que.isEmpty()) break;
			while(idx<jobs.length&&jobs[idx][0]<=loc) {
				que.add(new Work(jobs[idx][0],jobs[idx][1]));
				idx++;
			}
			if(que.isEmpty()&&idx<jobs.length)
				loc=jobs[idx][0];
			else {
				Work k=que.poll();
				loc+=k.duration;
				sum+=loc-k.request;
			}
		}
		answer=sum/jobs.length;
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs= {{0,3},{1,9},{2,6}};
		System.out.print(solution(jobs));
	}

}
