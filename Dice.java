import java.util.Scanner;
public class Dice {
	public static int u=0,f=0,r=0,l=0,d=0,b=0;
	public static int M,N,R,C,I;
	public static int[][] field;
	public static void shiftLeft() {
		if(C-1>=0)
			C--;
		else return;
		int tmp;
		tmp=l;
		l=u;
		u=r;
		r=d;
		d=tmp;
		change();
		//System.out.println("shift left");
		show();
		System.out.println(u);
	}
	public static void shiftRight() {
		if(C+1<N)
			C++;
		else return;
		int tmp;
		tmp=d;
		d=r;
		r=u;
		u=l;
		l=tmp;
		change();
		//System.out.println("shift right");
		show();
		System.out.println(u);
	}
	public static void shiftUp() {
		if(R-1>=0)
			R--;
		else return;
		int tmp;
		tmp=f;
		f=d;
		d=b;
		b=u;
		u=tmp;
		change();
		//System.out.println("shift up");
		show();
		System.out.println(u);
	}
	public static void shiftDown() {
		if(R+1<M)
			R++;
		else return;
		int tmp;
		tmp=f;
		f=u;
		u=b;
		b=d;
		d=tmp;
		change();
		//System.out.println("shift down");
		show();
		System.out.println(u);
	}
	public static void show() {
		System.out.println("  "+u);
		System.out.println(l+" "+f+" "+r);
		System.out.println("  "+d);
		System.out.println("  "+b);
		
		System.out.println();
		
	}
	public static void change() {
		if(field[R][C]==0)
			field[R][C]=d;
		else
			d=field[R][C];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		M=key.nextInt();
		N=key.nextInt();
		R=key.nextInt();
		C=key.nextInt();
		I=key.nextInt();
		field=new int[M][N];
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				field[i][j]=key.nextInt();
		for(int i=0;i<I;i++) {
			int dir=key.nextInt();
			//System.out.println("direction:"+dir);
			if(dir==1)
			
				shiftRight();
			else if(dir==2)
				shiftLeft();
			else if(dir==3)
				shiftUp();
			else if(dir==4)
				shiftDown();
			
			//System.out.println("R:"+R+" C:"+C);
			//System.out.println();
			
		}
		
	}

}