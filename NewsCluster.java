import java.util.ArrayList;
public class NewsCluster {
	static ArrayList<String> func1;
	static ArrayList<String> func2;
	static int[] visited;
	static boolean isVal(char c) {
		if(c>='a'&&c<='z') return true;
		else return false;
	}
	public static int solution(String str1, String str2) {
	      int answer = 0;
	      String s1=str1.toLowerCase();
	      String s2=str2.toLowerCase();
	      func1=new ArrayList<String>();
	      func2=new ArrayList<String>();
	      visited=new int[s2.length()-1];
	      for(int i=0;i<s1.length()-1;i++) {
	    	  char a=s1.charAt(i),b=s1.charAt(i+1);
	    	  if(isVal(a)&&isVal(b))
	    		  func1.add(""+a+b);
	      }
	      for(int i=0;i<s2.length()-1;i++) {
	    	  char a=s2.charAt(i),b=s2.charAt(i+1);
	    	  if(isVal(a)&&isVal(b))
	    		  func2.add(""+a+b);
	      }
	      int cnt=0;
	      for(int i=0;i<func1.size();i++) {
	    	  for(int j=0;j<func2.size();j++) {
	    		  if(func1.get(i).equals(func2.get(j))&&visited[j]==0) {
	    			  visited[j]=1;
	    			  cnt++;
	    			  break;
	    		  }
	    	  }
	      }
	      double ans;
	      if(cnt==0&&func1.size()==0&&func2.size()==0) ans=1*65536;
	      else ans=(double)cnt/(func1.size()+func2.size()-cnt)*65536;
	      answer=(int)ans;
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("FRANCE","french"));
		System.out.println(solution("handshake","shake hands"));
		System.out.println(solution("aa1+aa2","AAAA12"));
		System.out.println(solution("E=M*C^2","e=m*c^2"));
	}

}
