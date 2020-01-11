import java.util.ArrayList;
import java.util.Scanner;

class RPoint{
	int r,c;
	RPoint(int r,int c){
		this.r=r;
		this.c=c;
	}
}

public class Chicken {
	static ArrayList<RPoint> house= new ArrayList<RPoint>();
	static ArrayList<RPoint> chicken= new ArrayList<RPoint>();
	public static int A[];
	public static int minDis=1000000000;
	private static void combi(int n,int m,int loc) {
		if(m==0) {
			for(int i=loc;i<chicken.size();i++)
				A[i]=0;
			getDis();
			return;
		}
		else if(m==n) {
			for(int i=loc;i<chicken.size();i++)
				A[i]=1;
			getDis();
			return;
		}
		else {
			A[loc]=0;
			combi(n-1,m,loc+1);
			A[loc]=1;
			combi(n-1,m-1,loc+1);
		}
	}
	public static void getDis() {
		int chickenDis=0;
		for(int i=0;i<house.size();i++) {
			int min=1000000000;
			int distance=0;
			RPoint h=house.get(i);
			for(int j=0;j<chicken.size();j++) {
				RPoint t=chicken.get(j);
					distance=Math.abs(h.r-t.r)+Math.abs(h.c-t.c);
					if(A[j]==1)
						if(min>distance)
							min=distance;	
			}
			chickenDis+=min;
		}
		if(minDis>chickenDis)
			minDis=chickenDis;
		//System.out.println("chicken distance:"+chickenDis);
	}
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		int n,m;
		n=key.nextInt();
		m=key.nextInt();
		int[][] array=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				array[i][j]=key.nextInt();
				if(array[i][j]==1)
					house.add(new RPoint(i,j));
				else if(array[i][j]==2)
					chicken.add(new RPoint(i,j));
			}
		}
		A=new int[chicken.size()];
		/*
		System.out.println("House");
		for(int i=0;i<house.size();i++) {
			RPoint t=house.get(i);
			System.out.println("("+t.r+","+t.c+")");
		}
		System.out.println("Chicken");
		for(int i=0;i<chicken.size();i++) {
			RPoint t=chicken.get(i);
			System.out.println("("+t.r+","+t.c+")");
		}
		*/
		combi(chicken.size(),m,0);
		System.out.println(minDis);
	}

}
