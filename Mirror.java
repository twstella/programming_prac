package codeGround;

import java.util.Scanner;
public class Mirror {
	static int Answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=0;test_case<T;test_case++) {
			int N=sc.nextInt();
			int[][] arr=new int[N][N];
			int[][] visited=new int[N][N];
			for(int i=0;i<N;i++) {
				String tmp=sc.next();
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(""+tmp.charAt(j));
					visited[i][j]=0;
				}
			}
			int r=0,c=0,d=2;
			Answer=0;
			while(true) {
				if(r<0||r>=N||c<0||c>=N)
					break;
				if(arr[r][c]==0) {
					if(d==0) {
							r--;
					}
					else if(d==1) {
							r++;
					}
					else if(d==2) {
							c++;
					}
					else if(d==3) {
							c--;
					}
				}
				else if(arr[r][c]==1) {
					if(visited[r][c]==0) {
						Answer++;
						visited[r][c]=1;
					}
					if(d==0) {
						c++;
						d=2;
					}
					else if(d==1) {
						c--;
						d=3;
					}
					else if(d==2) {
						r--;
						d=0;
					}
					else if(d==3) {
						r++;
						d=1;
					}
				}
				else if(arr[r][c]==2) {
					if(visited[r][c]==0) {
						visited[r][c]=1;
						Answer++;
					}
					if(d==0) {
						c--;
						d=3;
					}
					else if(d==1) {
						c++;
						d=2;
					}
					else if(d==2) {
						r++;
						d=1;
					}
					else if(d==3) {
						r--;
						d=0;
					}
				}
			}
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
