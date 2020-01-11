package recursion;

public class Hanoi {
	public static int cnt=0;
	public static int[] count= {0,0,0};
	public static void hanoi(char from,char tmp,char to,int n) {
		cnt++;
			count[from-'A']++;
		if(n==1) {
			System.out.println("Move from "+from+" to "+to);
			return;
		}
		hanoi(from,to,tmp,n-1);
		hanoi(from,tmp,to,1);
		hanoi(tmp,from,to,n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi('A','B','C',10);
		System.out.println(cnt);
		int sum=0;
		for(int i=0;i<3;i++) {
			System.out.println(count[i]);
			sum+=count[i];
		}
		System.out.println("sum:"+sum);
	}

}
