package basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
	class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
public class PointSort {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			N=Integer.parseInt(s.nextToken());
			Point[] arr=new Point[N];
			for(int i=0;i<N;i++) {
				s=new StringTokenizer(br.readLine());
				arr[i]=new Point(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
			}
			Arrays.sort(arr,new Comparator<Point>() {
				public int compare(Point p1,Point p2) {
					int r=p1.x-p2.x;
					if(r==0)
						r=p1.y-p2.y;
					return r;
				}
			});
			for(int i=0;i<N;i++) {
				Point t=arr[i];
				System.out.println(t.x+" "+t.y);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
