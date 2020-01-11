
/*
  3 3 52
  1 1
  1 1 3
  1 1 90
  2 2 100
  3 1 30
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

class MNode {
	ArrayList<Integer> list;
	int singer;
	MNode () {
		list = new ArrayList<Integer>();
		singer = -1;
	}
}

public class Music {
	static int N, K, J;
	static MNode[] tree;
	static int[] singer;
	static int[] done;
	static int[] numsongs;
	
	public static void ShowTree() {
		for (int i=0; i<N; i++) {
			System.out.println(i +": " + tree[i].singer +" ");
			for (int j=0; j<tree[i].list.size(); j++)
				System.out.print(tree[i].list.get(j)+" ");
			System.out.println();
		}
	}
	
	public static void ShowSinger() {
		for (int i=0; i<N; i++)
			System.out.println(singer[i]+ " " + numsongs[i]+" " +done[i]);
		System.out.println();
	}
	
	public static void ShowResult() {
		for (int i=0; i<N; i++) {
			int ss = tree[i].singer;
			System.out.println(done[ss]);
		}
		System.out.println();
	}
	
	public static int Count(int t) {
		int cnt = 0;
		Stack<Integer> stack = new Stack<Integer> ();
		cnt =1;
		stack.push(t);
		while (stack.isEmpty() != true) {
			int u = stack.pop();
			for (int k:tree[u].list) {
				stack.push(k); cnt++;
			}		
		}
		return(cnt);	
	}
	
	public static void Update(int t, int inc, int curtime) {
		Stack<Integer> stack = new Stack<Integer> ();
		stack.push(t);
		while (stack.isEmpty() != true) {
			int u = stack.pop();
			int sid = tree[u].singer;
			singer[sid] += inc;
			if ((done[sid] == -1) && (singer[sid]/numsongs[sid] >= J))
					done[sid] = curtime;
			for (int k:tree[u].list) {
				stack.push(k); 
			}		
		}
	}
	
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		N = key.nextInt();
		K = key.nextInt();
		J = key.nextInt();
		tree = new MNode[N];
		singer = new int[N];		// current score
		done = new int[N];			// time instant done
		numsongs = new int[N];			// time instant done
		
		for (int i=0; i<N; i++)
			done[i] = -1;
		for (int i=0; i<N; i++)
			tree[i] = new MNode();
		for (int i = 0; i<N-1; i++) {
			int p = key.nextInt()-1;
			tree[p].list.add(i+1);
		}
		for (int i=0; i<N; i++) {
			int p = key.nextInt()-1;
			tree[i].singer = p;
			numsongs[p]++;
		}
//		ShowTree();
//		ShowSinger();
		
		int tm, tr, wt, cnt, add;
		for (int i=0; i<K; i++) {
			tm = key.nextInt();	// time
			tr = key.nextInt()-1; // song in tree
			wt = key.nextInt();	// weight
			cnt = Count(tr);
			add = wt /cnt;
			Update(tr, add, tm);
//			ShowSinger();
		}
		key.close();
//		ShowSinger();
		ShowResult();
	}
}

