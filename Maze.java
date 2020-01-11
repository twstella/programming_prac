package codeGround;
import java.util.Scanner;
public class Maze {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=0;test_case<T;test_case++) {
			short N=sc.nextShort();
			Answer=1;
			short[][] arr=new short[N][N];
			short cnt=1;
			int d=0,r=0,c=0;
			//d=0->c++ d=1->r++,c-- d=2->r++ d=3->r--,c++
			int to=N*(1+N)/2;
			int end=N*N;
			while(cnt<=to) {
				
				if(d==0) {
					arr[r][c++]=cnt++;
					d=1;
				}
				else if(d==1) {
					while(c>0) {
						arr[r++][c--]=cnt++;
					}
					d=2;
				}
				else if(d==2) {
					arr[r++][c]=cnt++;
					d=3;
				}
				else if(d==3) {
					while(r>0) {
						arr[r--][c++]=cnt++;
					}
					d=0;
				}
			}
			if(d==1) {
				r++;
				c--;
			}
			else if(d==3) {
				r--;
				c++;
			}
			while(cnt<=end) {
				if(d==0) {
					arr[r][c++]=cnt++;
					d=3;
				}
				else if(d==1) {
					while(r<N-1) {
						arr[r++][c--]=cnt++;
					}
					d=0;
				}
				else if(d==2) {
					arr[r++][c]=cnt++;
					d=1;
				}
				else if(d==3) {
					while(c<N-1) {
						arr[r--][c++]=cnt++;
					}
					d=2;
				}
			}
			int L=sc.nextInt();
			String s=sc.next();
			int x=0,y=0;
			for(int i=0;i<L;i++) {
				char t=s.charAt(i);
				switch(t) {
				case 'D':
					Answer+=arr[++x][y]; break;
				case 'R':
					Answer+=arr[x][++y]; break;
				case 'U':
					Answer+=arr[--x][y];break;
				case 'L':
					Answer+=arr[x][--y]; break;				}
			}
			//print(arr);
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}

	}

}
