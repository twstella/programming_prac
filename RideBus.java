package codeGround;

import java.util.Scanner;
import java.util.PriorityQueue;


public class RideBus {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		  for(int test_case=0;test_case<T;test_case++) {
			  int N=sc.nextInt();
			  int K=sc.nextInt();
			  PriorityQueue<Integer> que=new PriorityQueue<Integer>();
			  PriorityQueue<Integer> bus=new PriorityQueue<Integer>();
			  for(int i=0;i<N;i++) {
				  que.add(sc.nextInt());
			  }
			  for(int j=0;j<N;j++) {
				  int tmp=que.poll();
				  if(bus.isEmpty())
					  bus.add(tmp);
				  else {
					  if(tmp-bus.peek()<=K)
						  bus.add(tmp);
					  else {
						  bus.poll();
						  bus.add(tmp);
					  }
				  }
			  }
			  Answer=bus.size();
			  System.out.println("Case #"+(test_case+1));
			  System.out.println(Answer);
		  }
	}

}
