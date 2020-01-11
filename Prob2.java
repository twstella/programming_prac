
/*
 class RPoint{
 	int r,c;
 	RPoint(int r,int c){
 	this.r=r;
 	this.c=c;
 	}
 }
 */
//down=1
//right=0
public class Prob2 {
	public static int cnt;
	public static int[][][] dp;
	public static int proc(int r,int c,int dir,int[][] city_map) {	

		int t1=0,t2=0;
		if(r>=city_map.length){
			//dp[r][c][dir]=0;
			return 0;
		}
		if(c>=city_map[0].length) {
			//dp[r][c][dir]=0;
			return 0;
		}
		if(dp[r][c][dir]!=-1)
			return dp[r][c][dir];
		//System.out.println("("+r+","+c+")");
		if(r==city_map.length-1&&c==city_map[0].length-1) {
			//cnt++;
			//System.out.println(cnt);
			dp[r][c][dir]=1;
			return 1;
			
		}	
		if(city_map[r][c]==0) {
			t1=proc(r,c+1,0,city_map);		
			t2=proc(r+1,c,1,city_map);
		}
		else if(city_map[r][c]==1) {
			dp[r][c][dir]=0;
			return 0;
		}
		else {
			if(dir==1)
				t1= proc(r+1,c,1,city_map);
			else if(dir==0)
				t2= proc(r,c+1,0,city_map);
		}
		dp[r][c][dir]=t1+t2;
		return 	dp[r][c][dir];
		
	}
	public static int solution(int m,int n,int[][] city_map) {
		dp=new int[city_map.length][city_map[0].length][2];
		for(int i=0;i<city_map.length;i++)
			for(int j=0;j<city_map[0].length;j++)
				for(int k=0;k<2;k++)
					dp[i][j][k]=-1;
		cnt=proc(0,0,0,city_map);
		if(city_map[0][0]!=0)
			cnt+=proc(0,0,1,city_map);
		return cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] city_map= {{0,0,0},{0,0,0},{0,0,0}};

		int count=solution(3,3,city_map);
		System.out.println(count);
		
		
		int[][] example= {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}};
		count=solution(3,6,example);
		System.out.println(count);
		
		int[][] example2= {{2,0,1,0},{0,0,2,0},{0,1,0,0}};
		 count=solution(3,4,example2);
		System.out.println(count);
		
	}

}
