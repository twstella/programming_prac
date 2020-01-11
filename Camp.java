import java.util.Arrays;

 class CampLocU implements Comparable<CampLocU>{
	int x,y;
	CampLocU(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int compareTo(CampLocU o) {
		int res=this.x-o.x;
		if(res==0)
			res=o.y-this.y;
		return res;
	}
}
class CampLocD implements Comparable<CampLocD>{
	int x,y;
	CampLocD(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int compareTo(CampLocD o) {
		int res=this.x-o.x;
		if(res==0)
			res=this.y-o.y;
		return res;
	}
}

public class Camp {
	public static CampLocU[] ua;
	public static CampLocD[] da;
	public static void show(int n) {
		for(int i=0;i<n;i++)
			System.out.println(ua[i].x+" "+ua[i].y);
		for(int i=0;i<n;i++)
			System.out.println(da[i].x+" "+da[i].y);
	}
	public static int solution(int n,int[][] p) {
		ua=new CampLocU[n];
		da=new CampLocD[n];
		int cnt=0;
		for(int i=0;i<n;i++) {
			ua[i]=new CampLocU(p[i][0],p[i][1]);
			da[i]=new CampLocD(p[i][0],p[i][1]);
		}
		Arrays.sort(ua);
		Arrays.sort(da);
		int up,down;
		int bound=(int)(Math.pow(2,31)-1);
		for(int i=0;i<n;i++) {
			up=bound;
			for(int j=i+1;j<n;j++) {
				if((ua[i].x==ua[j].x)||(ua[i].y==ua[j].y))
					continue;
				if(ua[i].y<ua[j].y) {
					if(ua[j].y<=up) {
						cnt++;
						up=ua[j].y;
					}
				}
				else continue;
			}
		}
//System.out.println("UP "+cnt);
		for(int i=0;i<n;i++) {
			down=0;
			for(int j=i+1;j<n;j++) {
				if(da[i].x==da[j].x||da[i].y==da[j].y)
					continue;
				if(da[i].y>da[j].y) {
					if(da[j].y>=down) {
						cnt++;
						down=da[j].y;
					}
				}
				else continue;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pts = {{0,0},{1,1},{0,2},{2,0}};

		int[][] pts0 = {{0,0},{0,1},{0,2}, {1,0},{1,1}, {1,2}};
		int[][] pts1 = {{0,0},{0,1},{0,2}, {1,2}, {1,0},{1,1}};
		int[][] pts2 = {{0,0},{0,1},{0,2}, {1,2}, {1,0},{1,1}, {2,1}, {2,0},{2,2}};
		int[][] pts3 = {{0,0},{0,1},{0,2}, {1,2}, {1,0}, {2,1}, {2,0},{2,2}};

		System.out.println(solution(4, pts));
		System.out.println(solution(9, pts2));
		System.out.println(solution(8, pts3));
	}

}
