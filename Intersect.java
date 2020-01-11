import java.util.Scanner;
class Locate{
	long x,y;
	Locate(long x,long y){
		this.x=x;
		this.y=y;
	}
}
public class Intersect {
	static Locate A,B,C,D;
	static int area(long x1,long y1,long x2,long y2,long x3,long y3) {
		long sum;
		sum=x1*y2-x2*y1;
		sum+=x2*y3-x3*y2;
		sum+=x3*y1-x1*y3;
		if(sum<0) return -1;
		else if(sum==0) return 0;
		else return 1;
	}
	static int solution(int t1,int t2,int t3,int t4) {
		int flag=1;
		if(t1*t2==0&&t3*t4==0) {
			long m=C.x<D.x?C.x:D.x;
			if(m>A.x&&m>B.x) return 0;
			m=C.x>D.x?C.x:D.x;
			if(m<A.x&&m<B.x) return 0;
			m=C.y<D.y?C.y:D.y;
			if(m>A.y&&m>B.y) return 0;
			m=C.y>D.y?C.y:D.y;
			if(m<A.y&&m<B.y) return 0;
			flag=1;
		}
		else if(t1*t2<=0&&t3*t4<=0) flag=1;
		else return 0;
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		A=new Locate(key.nextInt(),key.nextInt());
		B=new Locate(key.nextInt(),key.nextInt());
		C=new Locate(key.nextInt(),key.nextInt());
		D=new Locate(key.nextInt(),key.nextInt());
		int r1=area(A.x,A.y,B.x,B.y,C.x,C.y);
		int r2=area(A.x,A.y,B.x,B.y,D.x,D.y);
		int r3=area(C.x,C.y,D.x,D.y,A.x,A.y);
		int r4=area(C.x,C.y,D.x,D.y,B.x,B.y);
		System.out.println(solution(r1,r2,r3,r4));
	}

}
