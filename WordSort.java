package basic;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class WordSort {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			N=Integer.parseInt(s.nextToken());
			ArrayList<String> set=new ArrayList<String>();
			for(int i=0;i<N;i++) {
				s=new StringTokenizer(br.readLine());
				String t=s.nextToken();
				if(!set.contains(t))
					set.add(t);
			}
			Collections.sort(set,new Comparator<String>() {
				public int compare(String s1,String s2) {
					int r=s1.length()-s2.length();
					if(r==0)
						r=s1.compareTo(s2);
					return r;
				}
			});
			for(String i:set) {
				System.out.println(i);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
