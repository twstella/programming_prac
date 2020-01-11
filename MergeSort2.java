import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class MergeSort2 {
	static int[] S;
	static void mergeSort(int l,int r) {
		if(l<r) {
			int m=(l+r)/2;
			System.out.print("divide- ");
			for(int i=l;i<=m;i++)
				System.out.print(S[i]+" ");
			System.out.print("  ");
			for(int i=m+1;i<=r;i++)
				System.out.print(S[i]+" ");
			System.out.println("  ");
			mergeSort(l,m);
			mergeSort(m+1,r);
			System.out.print("merge-");
			merge(l,m,r);
			for(int i=l;i<=r;i++)
				System.out.print(S[i]+" ");
			System.out.println();
		}
	}
	static void merge(int l,int m,int r) {
		int i=l,j=m+1,k=l;
		int[] L=new int[S.length];
		while(i<=m&&j<=r) {
			L[k++]=(S[i]<S[j])?S[i++]:S[j++];
		}
		if(i>m)
			for(int t=j;t<=r;t++,k++)
				L[k]=S[t];
		else
			for(int t=i;t<=m;t++,k++)
				L[k]=S[t];
		for(int t=l;t<=r;t++)
			S[t]=L[t];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter numbers is one line.");
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			int n=s.countTokens();
			S=new int[n];
			for(int i=0;i<n;i++)
				S[i]=Integer.parseInt(s.nextToken());
			mergeSort(0,n-1);
			for(int i:S)
				System.out.print(i+" ");
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}

}
