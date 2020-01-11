import java.util.Arrays;
public class ShuttleBus {
	static int toMin(String t) {
		int h=(t.charAt(0)-'0')*10+t.charAt(1)-'0';
		int m=(t.charAt(3)-'0')*10+t.charAt(4)-'0';
		return h*60+m;
	}
	public static String solution(int n, int t, int m, String[] timetable) {
	      String answer = "";
	      int[] crew=new int[timetable.length];
	      int l,bus,i,ans;
	      Arrays.sort(timetable);
	      for(int j=0;j<crew.length;j++) {
	    	  crew[j]=toMin(timetable[j]);
	      }
	      l=(n-1)*t+toMin("09:00");
	      bus=toMin("09:00");
	      i=0;
	      for(int j=0;j<n-1;j++) {
	    	  for(int k=0;k<m;k++) {
	    		  if(crew[i]<=bus)
	    			  i++;
	    	  }
	    	  bus+=t;
	      }
	      if(timetable.length-i<m)
	    	  ans=bus;
	      else {
	    	  int j=i+m-1;
	    	  if(crew[j]<=bus)
	    		  ans=crew[j]-1;
	    	  else
	    		  ans=bus;
	      }
	      int a=ans/60,b=ans%60;
	      if(a<10) answer+="0";
	      else answer+="";
	      answer+=a;
	      answer+=":";
	      if(b<10) answer+="0";
	      else answer+="";
	      answer+=b;
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1,t=1,m=5;
		String[] s= {"08:00","08:01","08:02","08:03"};
		//int n=2,t=10,m=2;
		//String[] s= {"09:10","09:09","08:00"};
		//int n=2,t=1,m=2;
		//String[] s= {"09:00","09:00","09:00","09:00"};
		//int n=1,t=1,m=5;
		//String[] s= {"00:01","00:01","00:01","00:01","00:01"};
		//int n=1,t=1,m=1;
		//String[] s= {"23:59"};
		/*
		int n=10,t=60,m=45;
		
		String[] s= {"23:59","23:59","23:59","23:59","23:59",
				"23:59","23:59","23:59","23:59","23:59",
				"23:59","23:59","23:59","23:59","23:59","23:59"
		};
		*/
		System.out.print(solution(n,t,m,s));
	}

}
