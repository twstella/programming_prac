
public class LiveBroad {
	public static int solution(int[] food_times, long k) {
        int answer = 0;
        int time=0;
        while(time<k) {
        	if(food_times[answer]==0) {
        		answer=(answer+1)%food_times.length; 
        		continue;
        	}
        	food_times[answer]--;
        	answer=(answer+1)%food_times.length;
        	time++;
        }
        return answer+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] f= {3,1,2}; int k=5;
		System.out.println(solution(f,k));
	}

}
