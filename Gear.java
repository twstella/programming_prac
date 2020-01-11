import java.util.Scanner;

public class Gear {
	public static int[][] gear=new int[4][8];
	public static int[] direction=new int[4];
	public static void clockwise(int gnum) {
		int tmp=gear[gnum][7];
		for(int i=6;i>=0;i--)
			gear[gnum][i%8+1]=gear[gnum][i];
		gear[gnum][0]=tmp;
	}
	public static void anticlockwise(int gnum) {
		int tmp=gear[gnum][0];
		for(int i=0;i<7;i++)
			gear[gnum][i]=gear[gnum][i%8+1];
		gear[gnum][7]=tmp;
	}
	public static void activate(int gnum) {
		if(direction[gnum]==1)
			clockwise(gnum);
		else if(direction[gnum]==-1)
			anticlockwise(gnum);
	}
	public static void change(int gnum,int dir) {
		direction[gnum]=dir;
		for(int i=gnum;i>0;i--) {
			if(gear[i][6]!=gear[i-1][2])
				direction[i-1]=-direction[i];
			else
				direction[i-1]=0;
		}
		for(int i=gnum;i<3;i++) {
			if(gear[i][2]!=gear[i+1][6])
				direction[i+1]=-direction[i];
			else
				direction[i+1]=0;
		}
		for(int i=0;i<4;i++)
			activate(i);
	}
	public static void print() {
		for(int i=0;i<gear.length;i++) {
			for(int j=0;j<gear[i].length;j++)
				System.out.print(gear[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		for(int i=0;i<4;i++) {
			String s=key.next();
			for(int j=0;j<8;j++) {
				gear[i][j]=s.charAt(j)-'0';
			}
		}
		int gnum,dir;
		int num=key.nextInt();
		for(int i=0;i<num;i++) {
			gnum=key.nextInt();
			dir=key.nextInt();
			direction[gnum-1]=dir;
			change(gnum-1,dir);
			for(int j=0;j<4;j++)
				direction[j]=0;
			//print();
		}
		int count=0;
		int add=1;
		for(int i=0;i<4;i++) {
			count+=add*gear[i][0];
			add*=2;
		}
		System.out.println(count);
		key.close();

	}

}
