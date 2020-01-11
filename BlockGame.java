import java.util.HashMap;
import java.util.ArrayList;
class Pos{
	int r,c;
	Pos(int r,int c){
		this.r=r; this.c=c;
	}
}
public class BlockGame {
	static int[][] field;
	static HashMap<Integer,ArrayList<Pos>> list=new HashMap<Integer,ArrayList<Pos>>();
	public static int solution(int[][] board) {
		field=new int[board.length][board[0].length];
		
        int answer = 0;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
