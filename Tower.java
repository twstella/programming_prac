package progrmmers;

public class Tower {
	static int[]solution(int[] arr) {
		int[] answer=new int[arr.length];
		for(int i=arr.length-1;i>0;i--) {
			answer[i]=0;
			if(arr[i]<arr[i-1]) {
				int j=i;
				while(j<arr.length&&answer[j]==0&&arr[j]<arr[i-1]) {
					answer[j]=i;
					j++;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {6,9,5,7,4};
		//int[] arr= {3,9,9,3,5,7,2};
		//int[] arr= {1,5,3,6,7,6,5};
		int[] tmp=solution(arr);
		for(int i=0;i<tmp.length;i++)
			System.out.print(tmp[i]+" ");
	}

}
