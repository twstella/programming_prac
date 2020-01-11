import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Location implements Comparable<Location>{
	double x,y;
	Location(double x,double y){
		this.x=x;
		this.y=y;
	}
	public int compareTo(Location o) {
		if(this.x>o.x) return 1;
		else if(this.x<o.x) return -1;
		else {
			if(this.y>o.y) return 1;
			else if(this.y<o.y) return -1;
		}
		return 0;
	}
}
public class ServerTraffic {
	static double[][] times;
	static PriorityQueue<Double> q=new PriorityQueue<Double>();
	public static int solution(String[] lines) {
		times=new double[lines.length][2];
		for(int i=0;i<lines.length;i++) {
			StringTokenizer st=new StringTokenizer(lines[i]," ");
			String s=st.nextToken();
			s=st.nextToken();
			StringTokenizer t=new StringTokenizer(s,":");
			times[i][1]+=Double.parseDouble(t.nextToken())*60*60*1000;
			times[i][1]+=Double.parseDouble(t.nextToken())*60*1000;
			times[i][1]+=Double.parseDouble(t.nextToken())*1000;
			s=st.nextToken();s=s.substring(0,s.length()-1);
			times[i][0]=times[i][1]-Double.parseDouble(s)*1000+1;
		}
		Location[] r=new Location[lines.length];
		for(int  i=0;i<lines.length;i++) {
			r[i]=new Location(times[i][0],times[i][1]);
		}
		Arrays.sort(r);
	      int answer = 0;
	      for(int i=0;i<lines.length;i++) {
	    	  q.add(r[i].y);
	    	  while((!q.isEmpty())&&(r[i].x-q.peek()>=1000)) {
	    		  q.remove();
	    	  }
	    	  if(answer<q.size())
    			  answer=q.size();
	      }
	      return answer;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String[] s= {"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"};
				*/
		/*		
		String[] s= {"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"};
		*/
		String[] s= {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		System.out.println(solution(s));
		
	}

}
