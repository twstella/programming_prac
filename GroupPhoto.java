// 2018년도 Kakao 코드 페스티벌 예행문제 B번
// Permutation search space를 만들었음
// --
package recursion;
import java.util.Scanner;

public class GroupPhoto {
	static int[] f;
	static int[] t;
	static int[] r;
	static int[] d;
	static int C, N=8;
	static int cnt=0;
	
	public static int GetID (char c) {
		switch (c) {
			case '=' :
			case 'A': return (0);
			case '<':
			case 'C': return (1);
			case '>':
			case 'F': return (2);	
			case 'J': return (3);
			case 'M': return (4);
			case 'N': return (5);
			case 'R': return (6);	
			case 'T': return (7);
		}
		return -1;
	}
	
	public static int GetLoc(int[] t, int e) {
		for (int i=0; i<N;i++)
			if (t[i]==e) return i;
		return -1;
	}
	
	public static void Proc(int[] p) {
		for (int i=0; i<C; i++) {
			int m1 = GetLoc(p, f[i]);
			int m2 = GetLoc(p, t[i]);
			int m3 = m1 -m2;
			if (m3 < 0) m3 = -m3;
			m3 = m3-1;	// 중간 사람수
			if (r[i] == 0) {
				if (m3 != d[i]) return;
			}
			else if (r[i] == 1) { // m3 < d[i] 라야 적합
				if (m3 >= d[i]) return;
			}
			else if (r[i] == 2) { // m3 >= d[i]+1
				if (m3 <= d[i]) return;
			}
		}
		cnt++;
		return;
	}
	
	public static void Perm(int[] t, int loc) {
		if (loc == N) {
			Proc(t);
		}
		else {
			for (int i=loc; i< N; i++) {
				int p;
				p = t[loc]; t[loc] = t[i]; t[i] = p;
				Perm(t, loc+1);
				p = t[loc]; t[loc] = t[i]; t[i] = p;
			}
		}
	}

	public static void ShowConstraints() {
		for (int i=0; i<C; i++)
			System.out.println(f[i]+" " +t[i]+ " " +r[i]+ " "+ d[i]);
	}
	
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		C = key.nextInt();
		f = new int[N];
		t = new int[N];
		r = new int[N];
		d = new int[N];
		for (int i=0; i<C; i++) {
			String s = key.next();
			f[i] = GetID(s.charAt(0));
			t[i] = GetID(s.charAt(2));
			r[i] = GetID(s.charAt(3));
			d[i] = (int) (s.charAt(4) - '0');
		}
		key.close();
//		ShowConstraints();
		int[] seed = {0,1,2,3,4,5,6,7};
		Perm(seed, 0);
		System.out.println(cnt);
	}
}
