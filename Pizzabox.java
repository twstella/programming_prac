import java.util.Arrays;
import java.util.Scanner;
public class Pizzabox {
	static int[] Mx;
	static int[] My;
	static int idx=0;
	public static boolean Already(int x,int y) {
		int i;
		for(i=0;i<idx;i++)
			if((Mx[i]==x)&&(My[i]==y))
				return true;
		return false;
	}
	public static void Add(int x,int y) {
		Mx[idx]=x;
		My[idx]=y;
		idx++;
	}
	public static void showMax() {
		int i;
		for(i=0;i<idx;i++) {
			System.out.println(Mx[i]+", "+My[i]);
		}
	}
	public static void main(String[] args) {
		int c,r,i,j,max;
		long sum=0,maxsum=0,a;
		Scanner key=new Scanner(System.in);
		r=key.nextInt();
		c=key.nextInt();
		int[][] pizza=new int[r][c];
		Mx = new int[r+c];
		My = new int[r+c];

		for(i=0;i<r;i++) {
			for(j=0;j<c;j++) {
				pizza[i][j]=key.nextInt();
				sum+=pizza[i][j];
			}
		}
		key.close();
		//System.out.println(sum);
		int mx=0,my=0;
		for(i=0;i<r;i++) {
			max=0;
			for(j=0;j<c;j++) {
				if(max<pizza[i][j]) {
					max=pizza[i][j];
					mx=i;
					my=j;
				}
			}
			if(Already(mx,my)==false)
				Add(mx,my);
		}
		//showMax();		
		

		for(i=0;i<c;i++) {
			max=0;
			for(j=0;j<r;j++) {
				if(max<pizza[j][i]) {
					max=pizza[j][i];
					mx=j;
					my=i;
				}
			}

			if(Already(mx,my)==false)
				Add(mx,my);
		}
		for(i=0;i<idx;i++)
			maxsum+=pizza[Mx[i]][My[i]];
		//System.out.println(maxsum);
		//showMax();
		a=sum-maxsum;
		System.out.println(a);
	}

}
