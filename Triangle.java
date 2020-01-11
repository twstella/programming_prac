package progrmmers;

public class Triangle {
	static int[][] dyn;
	static int search(int i,int j,int[][] arr) {
		if(i>=arr.length||j>i) return 0;
		else {
			if(dyn[i][j]!=-1) return dyn[i][j];
			else {
				int a=arr[i][j]+search(i+1,j,arr);
				int b=arr[i][j]+search(i+1,j+1,arr);
				int max=(a>b)?a:b;
				dyn[i][j]=max;
				return dyn[i][j];
			}
		}
	}
	public static int solution(int[][] triangle) {
		int answer=0;
		dyn=new int[triangle.length][];
		for(int i=0;i<dyn.length;i++)
			dyn[i]=new int[i+1];
		for(int j=0;j<dyn.length;j++)
			for(int k=0;k<dyn[j].length;k++)
				dyn[j][k]=-1;
		answer=search(0,0,triangle);
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tmp={{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.print(solution(tmp));
	}

}
