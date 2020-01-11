package progrmmers;
import java.util.Arrays;
public class KthNum {
	static int[] solution(int[] arr,int[][] cmd) {
		int[] ans=new int[cmd.length];
		for(int i=0;i<cmd.length;i++) {
			int[] tmp=Arrays.copyOfRange(arr,cmd[i][0]-1,cmd[i][1]);
			Arrays.sort(tmp);
			ans[i]=tmp[cmd[i][2]-1];
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,5,2,6,3,7,4};
		int[][] cmd= {{2,5,3},{4,4,1},{1,7,3}};
		int[] tmp=solution(arr,cmd);
		for(int i:tmp)
			System.out.print(i+" ");
	}

}
