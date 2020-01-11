import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Baek3780 {
	static int[] parent;
	static long[] dis;
	static int N;
	static void reset() {
		for(int i=0;i<N;i++) {
			parent[i]=i;
		}
	}
	static void print() {
		for(int i=0;i<N;i++) {
			System.out.print(dis[i]+" ");
		}
		System.out.println();
	}
	static void union(int i,int j,int[] r,long[] add) {
		long[] ca=new long[1];
		if(parent[i]==i) {
			long t=Math.abs(i-j);
			t=t%1000;
			parent[i]=j; dis[i]=t;
			r[0]=j;add[0]=dis[i];
			return;
		}
		else {
			union(parent[i],j,r,ca);
			parent[i]=r[0];
			dis[i]=dis[i]+ca[0];
			add[0]=dis[i];
			return;
		}
	}
	static void find(int n,int[] r,long[] add) {
		long[] ca=new long[1];
		if(parent[n]==n) {
			r[0]=n;add[0]=0;
			return;
		}
		else {
			find(parent[n],r,ca);
			parent[n]=r[0];
			dis[n]=dis[n]+ca[0];
			add[0]=dis[n];
			return;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(s.nextToken());
			int[] r=new int[1];
			long[] a=new long[1];
			for(int i=0;i<t;i++) {
				s=new StringTokenizer(br.readLine());
				N=Integer.parseInt(s.nextToken());
				parent=new int[N];
				dis=new long[N];
				
				reset();
				while(true) {
					s=new StringTokenizer(br.readLine());
					String input=s.nextToken();
					if(input.equals("O")) break;
					else if(input.equals("E")) {
						int loc=Integer.parseInt(s.nextToken())-1;
						find(loc,r,a);
						System.out.println(a[0]);
					}
					else if(input.equals("I")) {
						int n1=Integer.parseInt(s.nextToken())-1;
						int n2=Integer.parseInt(s.nextToken())-1;
						union(n1,n2,r,a);
					}
				}
			}
		}
		catch(IOException e) {}
	}

}
