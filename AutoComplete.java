import java.util.ArrayList;
import java.util.Arrays;
public class AutoComplete {
	static ArrayList<String> list=new ArrayList<String>();
	public static int solution(String[] words) {
	      int answer = 0;
	      Arrays.sort(words);
	      for(String s:words)
	    	  System.out.print(s+" ");
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"go","gone","guild"};
		System.out.println(solution(s));
		
	}

}
