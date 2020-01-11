import java.util.Scanner;
import java.util.ArrayList;
public class TopologySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> G=new ArrayList<ArrayList<Integer>>();
		Scanner sc=new Scanner(System.in);
		int V=sc.nextInt();
		int E=sc.nextInt();
		int[] inCnt=new int[V];
		for(int i=0;i<V;i++) {
			G.add(new ArrayList<Integer>());
		}
		for(int i=0;i<E;i++) {
			int t1=sc.nextInt()-1;
			int t2=sc.nextInt()-1;
			G.get(t1).add(t2);
			inCnt[t2]++;
		}
		sc.close();
		ArrayList<Integer> q=new ArrayList<Integer>();
		for(int i=0;i<V;i++)
			if(inCnt[i]==0)
				q.add(i);
		while(!q.isEmpty()) {
			int e=q.remove(0);
			System.out.print((e+1)+" ");
			for(int u:G.get(e)) {
				inCnt[u]--;
				if(inCnt[u]==0)
					q.add(u);
			}
		}
		System.out.println();
	}

}
