package progrmmers;

import java.util.Arrays;

public class PhoneBook {
	static boolean solution(String[] phone_book) {
		boolean answer=true;
		Arrays.sort(phone_book);
		if(phone_book.length==1) return true;
		for(int i=0;i<phone_book.length-1;i++) {
			//System.out.println(phone_book[i]);
			if(phone_book[i].length()>phone_book[i+1].length())
				continue;
			if(phone_book[i].equals(phone_book[i+1].substring(0,phone_book[i].length())))
				answer=false;
				
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr={"119","97674223","1195524421"};
		System.out.print(solution(arr));

	}

}
