import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
class Posi{
	int r,c;
	Posi(int x,int y){
		r=x;
		c=y;
	}
}
public class Surveillance {
	static int M,N;
	static int[][] arr;
	static int[][] visited;
	static HashMap<Integer,ArrayList<Posi>> cctv=new HashMap<Integer,ArrayList<Posi>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			M=Integer.parseInt(s.nextToken());
			N=Integer.parseInt(s.nextToken());
			arr=new int[M][N];
			visited=new int[M][N];
			for(int i=0;i<M;i++) {
				s=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int t=Integer.parseInt(s.nextToken());
					arr[i][j]=t;
					if(1<=t&&t<=5) {
						if(!cctv.containsKey(t)) {
							ArrayList<Posi> tmp=new ArrayList<Posi>();
							tmp.add(new Posi(i,j));
							cctv.put(t,tmp);
						}
						else {
							ArrayList<Posi> tmp=cctv.get(t);
							tmp.add(new Posi(i,j));
							cctv.put(t,tmp);
						}
					}
					else if(t==6)
						visited[i][j]=1;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}

}
