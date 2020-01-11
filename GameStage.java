import java.util.Arrays;
import java.util.Comparator;
class Stage{
	int stage;
	int done;
	int chall;
	Stage(int s,int d,int c){
		stage=s;
		done=d;
		chall=c;
	}

}
public class GameStage {
	static Stage[] game;
	static int[] done;
	static int[] chall;
	public static int[] solution(int N, int[] stages) {
        int[] answer =new int[N];
        game=new Stage[N];
        for(int i=0;i<N;i++)
        	game[i]=new Stage(i+1,0,0);
        done=new int[N];
        chall=new int[N];
        for(int i=0;i<stages.length;i++) {
        	int t=stages[i];
        	if(t>N)
        		for(int j=0;j<N;j++)
        			game[j].done++;
        	else {
        		for(int j=0;j<t;j++)
        			game[j].done++;
        		game[t-1].chall++;
        	}
        }
        Arrays.sort(game,new Comparator<Stage>() {
        	public int compare(Stage o1,Stage o2) {
        		double a=(double)o1.chall/o1.done;
        		double b=(double)o2.chall/o2.done;
        		int r;
        		if(a<b) r=1;
        		else if(a>b) r=-1;
        		else {
        			r=o1.stage-o2.stage;
        		}
        		return r;
        	}
        });
        for(int i=0;i<N;i++) {
        	answer[i]=game[i].stage;
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int n=5; int[] s= {2,1,2,6,2,4,3,3};
		int n=4;int[] s= {4,4,4,4};
		int[] t=solution(n,s);
		for(int i=0;i<t.length;i++)
			System.out.print(t[i]+" ");
	}

}
