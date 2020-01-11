package progrmmers;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;
public class Parcel {
	static int[] A;
	static int w;
	static int N;
	static int sum=0;
	static HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
	static boolean Func() {
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int t=A[i]+A[j];
				if(map.containsKey(t)==true) {
					ArrayList<Integer> u=map.get(t);
					u.add(A[i]);
				}
				else {
					ArrayList<Integer> u=new ArrayList<Integer>();
					u.add(A[i]);
					map.put(t, u);
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int t=w-(A[i]+A[j]);
				if((t<3)||(map.containsKey(t)==false))
					continue;
				else {
					ArrayList<Integer> u=map.get(t);
					for(int k:u) {
						if(k==A[i]||k==A[j]||t-k==A[i]||t-k==A[j])
							continue;
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(in.readLine());
			w=Integer.parseInt(s.nextToken());
			N=Integer.parseInt(s.nextToken());
			A=new int[N];
			s=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)
				A[i]=Integer.parseInt(s.nextToken());
			if(Func()==true)
				System.out.println("YES");
			else System.out.println("NO");
		}
		catch(IOException e) {
			return;
		}
	}

}
