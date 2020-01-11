import java.util.Scanner;
/*
class Locate{
	long x,y;
	Locate(long x,long y){
		this.x=x;
		this.y=y;
	}
}
*/
public class IntersectSquare {
	static Locate A,B,C,D;
	static boolean f=false;
	static int area(long x1,long y1,long x2,long y2,long x3,long y3) {
		long sum;
		sum=x1*y2-x2*y1;
		sum+=x2*y3-x3*y2;
		sum+=x3*y1-x1*y3;
		if(sum<0) return -1;
		else if(sum==0) return 0;
		else return 1;
	}
	static int solution(long x1,long y1,long x2,long y2,long x3,long y3,long x4,long y4) {
		int t1=area(x1,y1,x2,y2,x3,y3);
		int t2=area(x1,y1,x2,y2,x4,y4);
		int t3=area(x3,y3,x4,y4,x1,y1);
		int t4=area(x3,y3,x4,y4,x2,y2);
		int flag=1;
		if(t1*t2==0&&t3*t4==0) {
			long m=x3<x4?x3:x4;
			if(m>x1&&m>x2) return 0;
			m=x3>x4?x3:x4;
			if(m<x1&&m<x2) return 0;
			m=y3<y4?y3:y4;
			if(m>y1&&m>y2) return 0;
			m=y3>y4?y3:y4;
			if(m<y1&&m<y2) return 0;
			flag=1;
		}
		else if(t1*t2<=0&&t3*t4<=0) flag=1;
		else return 0;
		return flag;
	}
	static char func() {
		if(solution(A.x,A.y,B.x,B.y,C.x,C.y,D.x,C.y)==1) return 'T';
		if(solution(A.x,A.y,B.x,B.y,D.x,C.y,D.x,D.y)==1) return 'T';
		if(solution(A.x,A.y,B.x,B.y,D.x,D.y,C.x,D.y)==1) return 'T';
		if(solution(A.x,A.y,B.x,B.y,C.x,D.y,C.x,C.y)==1) return 'T';
		long minX,maxX,minY,maxY;
		if(C.x<D.x) {minX=C.x;maxX=D.x;}
		else {minX=D.x;maxX=C.x;}
		if(C.y<D.y) {minY=C.y;maxY=D.y;}
		else{minY=D.y;maxY=C.y;}
		if(minX<=A.x&&maxX>=A.x&&minX<=B.x&&maxX>=B.x&&
				minY<=A.y&&maxY>=A.y&&minY<=B.y&&maxY>=B.y) return 'T';
		return 'F';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int t=key.nextInt();
		for(int i=0;i<t;i++) {
			A=new Locate(key.nextLong(),key.nextLong());
			B=new Locate(key.nextLong(),key.nextLong());
			C=new Locate(key.nextLong(),key.nextLong());
			D=new Locate(key.nextLong(),key.nextLong());
			System.out.println(func());
		}
		
	}

}
