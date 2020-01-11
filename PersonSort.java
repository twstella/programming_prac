package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
class Person{
	String name;
	int age;
	int num;
	Person(int a,String n,int num){
		age=a;
		name=n;
		this.num=num;
	}
}
public class PersonSort {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(rd.readLine());
			N=Integer.parseInt(s.nextToken());
			Person[] arr=new Person[N];
			for(int i=0;i<N;i++) {
				s=new StringTokenizer(rd.readLine());
				arr[i]=new Person(Integer.parseInt(s.nextToken()),s.nextToken(),i);
			}
			Arrays.sort(arr,new Comparator<Person>() {
				public int compare(Person p1,Person p2) {
					int r=p1.age-p2.age;
					if(r==0)
						r=p1.num-p2.num;
					return r;
				}
			});
			for(Person p:arr) {
				System.out.println(p.age+" "+p.name);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
