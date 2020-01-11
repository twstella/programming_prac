import java.util.ArrayList;
public class Cache {
	
	public static int solution(int cacheSize, String[] cities) {
	      int answer = 0;
	      ArrayList<String> q=new ArrayList<String>();
	      if(cacheSize==0) return cities.length*5;
	      for(int i=0;i<cities.length;i++) {
	    	  if(q.contains(cities[i].toLowerCase())) {
		    		  q.remove(q.indexOf(cities[i].toLowerCase()));
		    		  q.add(cities[i].toLowerCase());
		    		  answer+=1;
	    		  
	    	  }
	    	  else {
	    		  answer+=5;
		    	  if(q.size()<cacheSize) {
		    		  q.add(cities[i].toLowerCase());
		    	  }
		    	  else {
		    		  if(q.size()>0)
		    			  q.remove(0);
		    		  q.add(cities[i].toLowerCase());
		    	  }
	    	  }
	      }
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int n=3;
		//String[] s= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		//String[] s= {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		//int n=2;
		//int n=5;
		//String[] s= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA","SanFrancisco","Seoul","Rome","Paris", "Jeju", "NewYork", "Rome"};
		//int n=2;
		//String[] s= {"Jeju","Pangyo","NewYork","newyork"};
		//int n=0;
		//String[] s= {"Jeju","Pangyo","Seoul","NewYork","LA"};
		int n=0;
		String[] s= {"Jeju","Jeju"};
		System.out.println(solution(n,s));
	}

}
