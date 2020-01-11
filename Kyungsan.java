package progrmmers;

public class Kyungsan {
	static int[][] dyn;
	static int bike(int c,int t, int[][] travel) {
		int k=-1,a=-1,b=-1;
		if(c<0) return 0;
		if(dyn[c][t]!=-2) return dyn[c][t];
		else {
			if(t>=travel[c][0]) {
				k=bike(c-1,t-travel[c][0],travel);
				if(k>=0)
					a=travel[c][1]+k;
			}
			if(t>=travel[c][2]) {
				k=bike(c-1,t-travel[c][2],travel);
				if(k>=0)
					b=travel[c][3]+k;
			}
			dyn[c][t]=(a>b)?a:b;
			return dyn[c][t];
		}
	}
	static int solution(int K,int[][] travel ) {
		int answer=0;
		dyn=new int[travel.length+1][K+1];
		for(int j=0;j<travel.length+1;j++)
			for(int k=0;k<K+1;k++)
				dyn[j][k]=-2;
		answer=bike(travel.length-1,K,travel);
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=1650;
		int[][] tmp={{500,200,200,100},{800,370,300,120},{700,250,300,90}};
		System.out.print(solution(k,tmp));
	}

}
