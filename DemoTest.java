import java.util.HashMap;
public class DemoTest {
	static HashMap<Integer,Integer> x=new HashMap<Integer,Integer>();
	static HashMap<Integer,Integer> y=new HashMap<Integer,Integer>();
	public static int[] solution(int[][] v) {
        int[] answer = new int[2];
        for(int i=0;i<v.length;i++) {
        	if(!x.containsKey(v[i][0])) x.put(v[i][0],1);
        	else {
        		int c=x.get(v[i][0]);
        		c++;
        		x.put(v[i][0],c);
        	}
        	if(!y.containsKey(v[i][1])) y.put(v[i][1],1);
        	else {
        		int c=y.get(v[i][1]);
        		c++;
        		y.put(v[i][1],c);
        	}
        }
        for(int i:x.keySet()) {
        	if(x.get(i)<2)
        		answer[0]=i;
        }
        for(int j:y.keySet()) {
        	if(y.get(j)<2)
        		answer[1]=j;
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] t= {{1,4},{3,4},{3,10}};
		int[][] t= {{1,1},{2,2},{1,2}};
		int[] s=solution(t);
		for(int i:s)
			System.out.print(i+" ");
	}

}
