import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Loc{
	int r,c;
	Loc(int r,int c){
		this.r=r;
		this.c=c;
	}
}
public class Curcuit {
	static ArrayList<Loc> cpu;
	static int T,N;
	static final int up=0,down=1,left=2,right=3;
	static int[][] curcuit;
	static int maxC,minJ;
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(curcuit[i][j]+" ");
			System.out.println();
		}
	}
	static int count(int d,int n) {
		int r=cpu.get(n).r;int c=cpu.get(n).c;
		int cnt=0;
		switch(d){
			case up:r--;
			while(r>=0) {
				if(curcuit[r][c]==1) return 0;
				r--;
			}
			r=cpu.get(n).r-1;
			while(r>=0) {
				curcuit[r--][c]=1;
				cnt++;
			}
			return cnt;
			case down: r++;
			while(r<N) {
				if(curcuit[r][c]==1) return 0;
				r++;
			}
			r=cpu.get(n).r+1;
			while(r<N) {
				curcuit[r++][c]=1;
				cnt++;
			}
			return cnt;
			case left: c--;
			while(c>=0) {
				if(curcuit[r][c]==1) return 0;
				c--;
			}
			c=cpu.get(n).c-1;
			while(c>=0) {
				curcuit[r][c--]=1;
				cnt++;
			}
			return cnt;
			case right:c++;
			while(c<N) {
				if(curcuit[r][c]==1) return 0;
				c++;
			}
			c=cpu.get(n).c+1;
			while(c<N) {
				curcuit[r][c++]=1;
				cnt++;
			}
			return cnt;
		}
		return 0;
	}
	static void reset(int d,int n) {
		int r=cpu.get(n).r,c=cpu.get(n).c;
		switch(d) {
		case up:r--;
		while(r>=0)
			curcuit[r--][c]=0; break;
		case down:r++;
		while(r<N) curcuit[r++][c]=0;break;
		case left:c--;
		while(c>=0) curcuit[r][c--]=0;break;
		case right:c++;
		while(c<N) curcuit[r][c++]=0;break;
		}
	}
	static boolean bound(int n) {
		int r=cpu.get(n).r,c=cpu.get(n).c;
		if(r==0||r==N-1||c==0||c==N-1) return true;
		return false;
	}
	static void solution(int n,int a,int c) {
		int num=0;
		if(n==cpu.size()) {
			if(maxC<c) {
				maxC=c;
				minJ=a;
			}
			else if(maxC==c) {
				if(minJ>a) minJ=a;
			}
			return;
		}
		if(bound(n)) {
			solution(n+1,a,c+1);
			return;
		}
		num=count(up,n);
		if(num>0) {
			solution(n+1,a+num,c+1); reset(up,n);
		}
		num=count(down,n);
		if(num>0) {
			solution(n+1,a+num,c+1); reset(down,n);
		}
		num=count(left,n);
		if(num>0) {
			solution(n+1,a+num,c+1); reset(left,n);
		}
		num=count(right,n);
		if(num>0) {
			solution(n+1,a+num,c+1); reset(right,n);
		}
		solution(n+1,a,c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(rd.readLine());
			T=Integer.parseInt(s.nextToken());
			for(int i=0;i<T;i++) {
				cpu=new ArrayList<Loc>();
				s=new StringTokenizer(rd.readLine());
				N=Integer.parseInt(s.nextToken());
				curcuit=new int[N][N];
				for(int j=0;j<N;j++) {
					s=new StringTokenizer(rd.readLine());
					for(int k=0;k<N;k++) {
						curcuit[j][k]=Integer.parseInt(s.nextToken());
						if(curcuit[j][k]==1&&j>0&&j<N-1&&k>0&&k<N-1) cpu.add(new Loc(j,k));
					}
				}	
				maxC=0; minJ=100000000;
				solution(0,0,0);
				System.out.println("#"+(i+1)+" "+minJ);
			}
		}
		catch(IOException e) {
			
		}

	}

}
