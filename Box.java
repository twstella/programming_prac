import java.util.Scanner;
public class Box {
	static int[][] box;
	static int m,n;
	static void function() {
		int sum=0;
		int i=m-1;
		while(i>=0) {
			for(int j=0;j<n;j++) {
				if(box[i][j]==1) {
					//System.out.println(i+","+j);
					if(i+1<m) {
						int t=i;
						while(box[t+1][j]!=1) {
							box[t+1][j]=1;
							box[t][j]=0;
							sum++;
							t++;
							if(t+1>=m)
								break;
							
						}	
					}
				}
			}
			i--;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int t;
		t=key.nextInt();
		for(int i=0;i<t;i++) {
			m=key.nextInt();
			n=key.nextInt();
			box=new int[m][n];
			for(int j=0;j<m;j++)
				for(int k=0;k<n;k++)
					box[j][k]=key.nextInt();
			function();
		}
	}

}
