import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceRolling {
	static int[] arr=new int[6];
	static void printDice() {
		System.out.println("  "+arr[0]);
		for(int i=1;i<4;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		System.out.println("  "+arr[4]);
		System.out.println("  "+arr[5]);
		System.out.println();
	}
	static void goEast() {
		int t=arr[3];
		arr[3]=arr[2];
		arr[2]=arr[1];
		arr[1]=arr[5];
		arr[5]=t;
	}
	static void goWest() {
		int t=arr[2];
		arr[2]=arr[3];
		arr[3]=arr[5];
		arr[5]=arr[1];
		arr[1]=t;
	}
	static void goNorth() {
		int t=arr[0];
		arr[0]=arr[2];
		arr[2]=arr[4];
		arr[4]=arr[5];
		arr[5]=t;
	}
	static void goSouth() {
		int t=arr[0];
		arr[0]=arr[5];
		arr[5]=arr[4];
		arr[4]=arr[2];
		arr[2]=t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(rd.readLine());
			int N=Integer.parseInt(s.nextToken());
			int M=Integer.parseInt(s.nextToken());
			int[][] map=new int[N][M];
			int r=Integer.parseInt(s.nextToken());
			int c=Integer.parseInt(s.nextToken());
			if(map[r][c]!=0) arr[5]=map[r][c];
			int n=Integer.parseInt(s.nextToken());
			for(int i=0;i<N;i++) {
				s=new StringTokenizer(rd.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(s.nextToken());
				}
			}
			s=new StringTokenizer(rd.readLine());
			for(int i=0;i<n;i++) {
				int cmd=Integer.parseInt(s.nextToken());
				//System.out.println("command: "+cmd);
				if(c<M-1&&cmd==1) {
					goEast();
					c++;
					if(map[r][c]==0)
						map[r][c]=arr[5];
					else {
						arr[5]=map[r][c];
						map[r][c]=0;
					}
					System.out.println(arr[2]);
				}
				else if(c>0&&cmd==2) {
					goWest();
					c--;
					if(map[r][c]==0)
						map[r][c]=arr[5];
					else {
						arr[5]=map[r][c];
						map[r][c]=0;
					}
					System.out.println(arr[2]);
				}
				else if(r>0&&cmd==3) {
					goNorth();
					r--;
					if(map[r][c]==0)
						map[r][c]=arr[5];
					else {
						arr[5]=map[r][c];
						map[r][c]=0;
					}
					System.out.println(arr[2]);
				}
				else if(r<N-1&&cmd==4) {
					goSouth();
					r++;
					if(map[r][c]==0)
						map[r][c]=arr[5];
					else {
						arr[5]=map[r][c];
						map[r][c]=0;
					}
					System.out.println(arr[2]);
				}
				//printDice();
			}
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}

}
