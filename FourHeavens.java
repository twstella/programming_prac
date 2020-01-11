import java.util.Scanner;

public class FourHeavens {
	static int M, N, K ;
	static char[][] board;
	static int[] r1, c1, r2, c2;
	static boolean done=false;
	
	public static void Proc(char[] t) {
		for (int i=0; i<K; i++) 
			System.out.print(t[i]);
		System.out.println();
		done = true;
		return;
	}
	
	public static void Perm(char[] t, int loc) {
		if (done==true) return;
		if (loc == K) {
			Proc(t);
		}
		else {
			for (int i=loc; i< K; i++) {
				char p;
				p = t[loc]; t[loc] = t[i]; t[i] = p;
				if (Reachable(t[loc]) == true) {
					int r, c, idx;
					idx = t[loc] -'A';
					r = r1[idx]; c = c1[idx];
					board[r][c]='.';
					r = r2[idx]; c = c2[idx];
					board[r][c]='.';
					Perm(t, loc+1);

					r = r1[idx]; c = c1[idx];
					board[r][c]=t[loc];
					r = r2[idx]; c = c2[idx];
					board[r][c]=t[loc];
				}
				p = t[loc]; t[loc] = t[i]; t[i] = p;
				if (done== true) return;
			}
		}
	}
	
	public static boolean Reachable(char c) {
		int idx = c - 'A';
		int i;
		int tr1 = r1[idx], tr2=r2[idx], tc1=c1[idx], tc2=c2[idx];
		
		if (tr1 == -1) return false;
		
		if (tr1==tr2) {
			for (i=tc1+1; i< tc2; i++)
				if (board[tr1][i] != '.')
					return false;
			return true;
		}
		if (tc1==tc2) {
			for (i=tr1+1; i< tr2; i++)
				if (board[i][tc1] != '.')
					return false;
			return true;
		}
		int cs, ce;
		if (tc1 > tc2) {
			cs= tc2; ce = tc1;
		}
		else {
			cs= tc1; ce = tc2;
		}
		boolean b1=true, b2=true, b3=true, b4=true;
		for (i=cs; i<= ce; i++) {
			if ((board[tr1][i] != '.') && (board[tr1][i] != c)) b1 = false;
//			System.out.println(tr1+" " +i+" "+ board[tr1][i]+ " "+ b1);
		}
		for (i = tr1; i<=tr2; i++)
			if ((board[i][tc2] != '.') && (board[i][tc2] != c)) b2 = false;

		for (i = tr1; i<=tr2; i++)
			if ((board[i][tc1] != '.') && (board[i][tc1] != c)) b3 = false;
		for (i=cs; i<= ce; i++)
			if ((board[tr2][i] != '.') && (board[tr2][i] != c)) b4 = false;
//System.out.println(b1+ " " + b2 + " " +b3 +" "+b4);
		if ( (b1 && b2) || (b3 && b4)) return true;
		else return false;
	}
	
	public static void ShowBoard() {
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++)
				System.out.print(board[i][j]+ " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void ShowMap() {
		for (int i=0; i<26; i++) {
			System.out.println(r1[i]+" "+c1[i]+", " +r2[i]+" "+c2[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);

		M=key.nextInt();
		N=key.nextInt();
		board = new char[M][N];
		r1 = new int[26]; c1 = new int[26];
		r2 = new int[26]; c2 = new int[26];
		for (int i=0; i<26; i++) 
			r1[i] = -1;
		
		for (int i=0; i<M; i++) {
			String str = key.next();
			for (int j=0; j<N; j++) {
				board[i][j] = str.charAt(j);
				if (board[i][j] == '*' || board[i][j] =='.')
					continue;
				if (r1[board[i][j]-'A']== -1) {
					r1[board[i][j]-'A'] = i;  c1[board[i][j]-'A'] = j;
				}
				else {
					r2[board[i][j]-'A'] = i;  c2[board[i][j]-'A'] = j;
				}
			}
		}
		key.close();
//		ShowBoard(); ShowMap();
		
		for (int i=0; i<26; i++)
			if (r1[i] != -1) 
				K++;
		
		char[] arr = new char[K];
		int nidx=0;
		for (int i=0; i<26; i++) 
			if (r1[i] != -1)
				arr[nidx++] = (char)('A'+ i);
		Perm(arr, 0);
		if (done == false)
			System.out.println("IMPOSSIBLE");
	}
}
