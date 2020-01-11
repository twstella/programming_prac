package basic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SortNum {
	static int N;
	static Integer[] A;
	static int partition(int l,int r) {
		int i=l+1,j=l,pivot=A[l];
		for(;i<=r;i++) {
			if(A[i]<pivot) {
				j++;
				int t=A[i];
				A[i]=A[j];
				A[j]=t;
			}
		}
		int t=A[l];
		A[l]=A[j];
		A[j]=t;
		return j;
	}
	static void quick(int l,int r) {
		if(l<r) {
			int p=partition(l,r);
			quick(l,p-1);
			quick(p+1,r);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer s=new StringTokenizer(br.readLine());
			N=Integer.parseInt(s.nextToken());
			A=new Integer[N];
			for(int i=0;i<N;i++) {
				s=new StringTokenizer(br.readLine());
				A[i]=Integer.parseInt(s.nextToken());
			}
			Arrays.sort(A);
			for(int i=0;i<N;i++)
				bw.write(A[i].toString()+"\n");
			bw.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
