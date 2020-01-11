import java.util.ArrayList;
import java.util.Scanner;
/*
class RPoint{
	int r,c;
	RPoint(int r,int c){
		this.r=r;
		this.c=c;
	}
}
*/
public class Virus {
	static ArrayList<RPoint> virus=new ArrayList <RPoint>();
	static ArrayList<RPoint> safe=new ArrayList <RPoint>();
	public static int max=0;
	public static int N;
	public static int M;
	public static int[] addWall;
	public static int[][] lab;
	public static int[][] tmp;
	public static int count;

	public static void spread() {	
		for(int i=0;i<lab.length;i++)
			for(int j=0;j<lab[i].length;j++)
				tmp[i][j]=lab[i][j];
		/*
		for(int i=0;i<addWall.length;i++)
			System.out.print(addWall[i]+" ");
		System.out.println();
		*/
		for(int i=0;i<addWall.length;i++) {
			RPoint m=safe.get(i);
			tmp[m.r][m.c]=addWall[i];
		}
		if(virus.isEmpty())
			for(int i=0;i<lab.length;i++)
				for(int j=0;j<lab[i].length;j++)
					if(lab[i][j]==2)
						virus.add(new RPoint(i,j));
		while(!virus.isEmpty()) {
			RPoint t=virus.remove(0);	
			if(t.c+1<M&&tmp[t.r][t.c+1]==0) {
				virus.add(new RPoint(t.r,t.c+1));
				tmp[t.r][t.c+1]=2;
			}
			if(t.r+1<N&&tmp[t.r+1][t.c]==0) {
				virus.add(new RPoint(t.r+1,t.c));
				tmp[t.r+1][t.c]=2;
			}
			if(t.r-1>=0&&tmp[t.r-1][t.c]==0) {
				virus.add(new RPoint(t.r-1,t.c));
				tmp[t.r-1][t.c]=2;
			}
			if(t.c-1>=0&&tmp[t.r][t.c-1]==0) {
				virus.add(new RPoint(t.r,t.c-1));
				tmp[t.r][t.c-1]=2;
			}
		}
		//print(tmp);
	}
	public static void dump() {
		count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tmp[i][j]==0)
					count++;
				//System.out.print(tmp[i][j]+" ");
			}
			//System.out.println();
		}
		//System.out.println("count:"+count);
		//System.out.println("-------------------------------------");
		if(max<count)
			max=count;
	}
	public static void combi(int n,int m,int loc) {
		if(m==0) {
			for(int i=loc;i<addWall.length;i++)
				addWall[i]=0;
			spread();
			dump();
			return;
		}
		else if(n==m) {
			for(int i=loc;i<addWall.length;i++)
				addWall[i]=1;
			spread();
			dump();
			return;
		}
		else {
			addWall[loc]=0;
			combi(n-1,m,loc+1);
			addWall[loc]=1;
			combi(n-1,m-1,loc+1);
		}	
	}

	
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		N=key.nextInt();
		M=key.nextInt();
		lab=new int[N][M];
		tmp=new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				lab[i][j]=key.nextInt();
		//print(lab);
		
		for(int i=0;i<lab.length;i++) {
			for(int j=0;j<lab[i].length;j++) {
				if(lab[i][j]==2)
					virus.add(new RPoint(i,j));
				else if(lab[i][j]==0)
					safe.add(new RPoint(i,j));
			}
		}

		addWall=new int[safe.size()];
		for(int i=0;i<addWall.length;i++) {
			addWall[i]=i%2;
		}
		//spread();
		combi(addWall.length,3,0);
		System.out.println(max);
	}

}
