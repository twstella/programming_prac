import java.util.Arrays;
import java.util.Scanner;

public class Baseball {
	public static double Phytha(int r,int l) {
		double s,s1,s2;
		s1=r*r;
		s2=l*l;
		s=(s1/(s1+s2))*1000;
		return s;
	}
	public static void main(String[] args) {
		int team,game,i,t1,t2,s1,s2,S,j;
		Scanner key=new Scanner(System.in);
		S=key.nextInt();
		for(j=0;j<S;j++) {
			team=key.nextInt();
			game=key.nextInt();
			int[] runs=new int[team];
			int[] losts=new int[team];
			int[] score=new int[team];
			for(i=0;i<game;i++) {
				t1=key.nextInt();
				t2=key.nextInt();
				s1=key.nextInt();
				s2=key.nextInt();
				runs[t1-1]+=s1;
				losts[t1-1]+=s2;
				runs[t2-1]+=s2;
				losts[t2-1]+=s1;
			}
			for(i=0;i<team;i++) {
				score[i]=(int)Phytha(runs[i],losts[i]);
				//System.out.printf("%d ", score[i]);
			}
			Arrays.sort(score);
			System.out.println(score[team-1]);
			System.out.println(score[0]);
		}
		key.close();
	}

}
