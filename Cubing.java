import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Cubing {
	static BufferedReader br;
	static BufferedWriter bw;
	static String[][] up= {{"w1","w2","w3"},{"w4","w5","w6"},{"w7","w8","w9"}};
	static String[][] down= {{"y1","y2","y3"},{"y4","y5","y6"},{"y7","y8","y9"}};
	static String[][] front= {{"r1","r2","r3"},{"r4","r5","r6"},{"r7","r8","r9"}};
	static String[][] back= {{"o1","o2","o3"},{"o4","o5","o6"},{"o7","o8","o9"}};
	static String[][] left= {{"g1","g2","g3"},{"g4","g5","g6"},{"g7","g8","g9"}};
	static String[][] right= {{"b1","b2","b3"},{"b4","b5","b6"},{"b7","b8","b9"}};
	static void reset() {
		int s=up.length;
		for(int i=0;i<s;i++) {
			for(int j=0;j<s;j++) {
				int k=i+j+1;
				up[i][j]="w"+k;
				down[i][j]="y"+k;
				front[i][j]="r"+k;
				back[i][j]="o"+k;
				left[i][j]="g"+k;
				right[i][j]="b"+k;
			}
		}
	}
	static void rotateClock(String[][] a) {
		String t1=a[0][0],t2=a[0][1];
		a[0][0]=a[2][0];
		a[2][0]=a[2][2];
		a[2][2]=a[0][2];
		a[0][2]=t1;
		a[0][1]=a[1][0];
		a[1][0]=a[2][1];
		a[2][1]=a[1][2];
		a[1][2]=t2;
	}
	static void rotateAnti(String[][] a) {
		String t1=a[0][0],t2=a[0][1];
		a[0][0]=a[0][2];
		a[0][2]=a[2][2];
		a[2][2]=a[2][0];
		a[2][0]=t1;
		a[0][1]=a[1][2];
		a[1][2]=a[2][1];
		a[2][1]=a[1][0];
		a[1][0]=t2;
	}
	static void turnU(String d) {
		String[] t=new String[3];
		for(int i=0;i<3;i++)
			t[i]=front[0][i];
		if(d.contains("+")) {
			rotateClock(up);
			for(int i=0;i<3;i++) {
				front[0][i]=right[0][i];
				right[0][i]=back[0][i];
				back[0][i]=left[0][i];
				left[0][i]=t[i];
			}
		}
		else if(d.contains("-")) {
			rotateAnti(up);
			for(int i=0;i<3;i++) {
				front[0][i]=left[0][i];
				left[0][i]=back[0][i];
				back[0][i]=right[0][i];
				right[0][i]=t[i];
			}
		}
	}
	static void turnD(String d) {
		String[] t=new String[3];
		for(int i=0;i<3;i++)
			t[i]=front[0][i];
		if(d.contains("+")) {
			rotateClock(down);
			for(int i=0;i<3;i++) {
				front[0][i]=left[0][i];
				left[0][i]=back[0][i];
				back[0][i]=right[0][i];
				right[0][i]=t[i];
			}
		}
		else if(d.contains("-")) {
			rotateAnti(down);
			for(int i=0;i<3;i++) {
				front[0][i]=right[0][i];
				right[0][i]=back[0][i];
				back[0][i]=left[0][i];
				left[0][i]=t[i];
			}
		}
	}
	static void turnF(String d) {
		String[] t=new String[3];
		for(int i=0;i<3;i++)
			t[i]=up[2][i];
		if(d.contains("+")) {
			rotateClock(front);
			for(int i=0;i<3;i++) {
				up[2][i]=left[2-i][2];
				left[2-i][2]=down[0][2-i];
				down[0][2-i]=right[i][0];
				right[i][0]=t[i];
			}
		}
		else if(d.contains("-"));{
			rotateAnti(front);
			for(int i=0;i<3;i++) {
				up[2][i]=right[i][0];
				right[i][0]=down[0][2-i];
				down[0][2-i]=left[2-i][2];
				left[2-i][2]=t[i];
			}
		}
	}
	static void turnB(String d) {
		String t[]=new String[3];
		for(int i=0;i<3;i++)
			t[i]=up[0][i];
		if(d.contains("+")) {
			rotateClock(back);
			for(int i=0;i<3;i++) {
				up[0][i]=right[i][2];
				right[i][2]=down[2][2-i];
				down[2][2-i]=left[2-i][0];
				left[2-i][0]=t[i];
			}
		}
		else if(d.contains("-")) {
			rotateAnti(back);
			for(int i=0;i<3;i++) {
				up[0][i]=left[2-i][0];
				left[2-i][0]=down[0][2-i];
				down[0][2-i]=right[i][2];
				right[i][2]=t[i];
			}
		}
	}
	static void turnL(String d) {
		String[] t=new String[3];
		for(int i=0;i<3;i++)
			t[i]=up[i][0];
		if(d.contains("+")) {
			rotateClock(left);
			for(int i=0;i<3;i++) {
				up[i][0]=back[2-i][2];
				back[2-i][2]=down[i][0];
				down[i][0]=front[i][0];
				front[i][0]=t[i];
			}
		}
		else if(d.contains("-"));{
			rotateAnti(left);
			for(int i=0;i<3;i++) {
				up[i][0]=front[i][0];
				front[i][0]=down[i][0];
				down[i][0]=back[2-i][2];
				back[2-i][2]=t[i];
			}
		}
	}
	static void turnR(String d) {
		String[] t=new String[3];
		for(int i=0;i<3;i++)
			t[i]=up[i][2];
		if(d.contains("+")) {
			rotateClock(right);
			for(int i=0;i<3;i++) {
				up[i][2]=front[i][2];
				front[i][2]=down[i][2];
				down[i][2]=back[2-i][0];
				back[2-i][0]=t[i];
			}
		}
		else if(d.contains("-")) {
			rotateAnti(right);
			for(int i=0;i<3;i++) {
				up[i][2]=back[2-i][0];
				back[2-i][0]=down[i][2];
				down[i][2]=front[i][2];
				front[i][2]=t[i];
			}
		}
	}
	public static void print(String[][] a) {
		try {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++)
					bw.append(a[i][j]+" ");
				bw.append("\n");
			}
			bw.append("\n");
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			bw=new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer s=new StringTokenizer(br.readLine());
			int T=Integer.parseInt(s.nextToken());
			for(int i=0;i<T;i++) {
				s=new StringTokenizer(br.readLine());
				int n=Integer.parseInt(s.nextToken());
				s=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					String dir=s.nextToken();
					char c=dir.charAt(0);
					String d=dir.substring(1);
					bw.append("c: "+c+"  d: "+d+"\n");
					switch(c) {
						case 'U': turnU(dir); break;
						case 'D':turnD(dir); break;
						case 'F':turnF(dir); break;
						case 'B':turnB(dir); break;
						case 'L':turnL(dir); break;
						case 'R':turnR(dir); break;
					}
				}
				print(up);
				reset();
			}
			bw.flush();
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}

	}

}
