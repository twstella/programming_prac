import java.util.Scanner;
public class TreasureHunt {
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      int[] map=new int[n];
	      for(int i=0;i<n;i++) {
	    	  answer[i]="";
	    	  int tmp=arr1[i]|arr2[i];
	    	  for(int j=0;j<n;j++) {
	    		  map[n-1-j]=tmp%2;
	    		  tmp=tmp>>1;
	    	  }
	    	  for(int j=0;j<n;j++)
	    		  if(map[j]==1)
	    			  answer[i]+="#";
	    		  else answer[i]+=" ";
	      }
	    	  
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int n=5;
		//int[] arr1= {9,20,28,18,11};
		//int[] arr2= {30,1,21,17,28};
		int n=6;
		int[] arr1= {46,33,33,22,31,50};
		int[] arr2= {27,56,19,14,14,10};
		String[] s=solution(n,arr1,arr2);
		for(int i=0;i<n;i++)
			System.out.println(s[i]);
	}

}
