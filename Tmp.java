import java.util.Arrays;
public class Tmp {
	 public static int N, T, M;
	   
	   public static int ntime(String t) {
	      int m, s;
	      m = (t.charAt(0) -'0') * 10 + (t.charAt(1) -'0');
	      s = (t.charAt(3) -'0') * 10 + (t.charAt(4) -'0');
	      return (m*60+s);
	      
	   }
	   
	   public static String solution (int N, int T, int M, String[] timetable ) {
	      String answer="";
	      int[] arrival = new int[timetable.length];
	      int last, idx, departure, ans;
	      int[] res = new int[2];
	      
	      for (int i=0; i<timetable.length; i++) 
	         arrival[i] = ntime(timetable[i]);
	      Arrays.sort(arrival);
	      
//	      for (int i=0; i<timetable.length; i++) 
//	         System.out.println(arrival[i]);

	      last = (N-1)*T + ntime("09:00");
	      departure = ntime("09:00");
	      
	      idx  =0;
	      for (int i=0; i<N-1; i++) {
	         for (int j =0; j<M; j++) {
	            if (arrival[idx] <= departure)
	               idx++;
	         }
	         departure += T;
	      }
	//System.out.println("At "+ idx + " "+departure);
	//System.out.println("Comp "+ (timetable.length - idx) + " "+M);
	      if (timetable.length-idx < M) 
	         ans = departure;
	      else {
	         int k = idx+M-1;
	         if ( arrival[k] <= departure)
	            ans = arrival[k] -1;
	         else 
	            ans = departure;
	      }

	      res[0] = ans/60; res[1] = ans%60;
	      if (res[0]>=10) 
		         answer+="";
		      else 
		         answer+="0";
	      answer+=res[0];
	      answer+=":";
		      if (res[1]>=10) 
		         answer+="";
		      else 
		         answer+="0";
		   answer+=res[1];  
	      return answer;
	   }
	   
	   
	   
	   public static void main(String[] args) {

	      String[] t1 = {"08:00", "08:01", "08:03", "08:02"};
	      System.out.println(solution(1, 1, 5, t1));

	      String[] t2 = {"09:10", "09:09", "08:00"};
	      N = 2; T= 10; M=2;
	      System.out.println(solution(2, 10, 2, t2));


	      String[] t3 = {"09:00", "09:00", "09:00", "09:00"};
	      N = 2; T= 1; M=2;
	      System.out.println(solution(2, 1, 2, t3));
	      

	      String[] t4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
	      System.out.println(solution(1, 1, 5, t4));

	      String[] t5 = {"23:59"};
	      N = 1; T= 1; M=1;
	      System.out.println(solution(1, 1, 1, t5));

	      String[] t6 = {"23:59", "23:59", "23:59", "23:59",
	            "23:59", "23:59", "23:59", "23:59",
	            "23:59", "23:59", "23:59", "23:59",
	            "23:59", "23:59", "23:59", "23:59"};
	      System.out.println(solution(10, 60, 45, t6));
	   }
}
