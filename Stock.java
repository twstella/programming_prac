package progrmmers;

public class Stock {
	static int[] solution(int[] prices) {
		int[] answer=new int[prices.length];
		for(int i=0;i<prices.length;i++) {
			int cnt=0;
			for(int j=i+1;j<prices.length;j++) {
				cnt++;
				answer[i]=cnt;
				if(prices[i]>prices[j]) {
					break;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices={498,501,470,489};
		int[] t=solution(prices);
		for(int i:t) {
			System.out.print(i+" ");
		}
	}

}
