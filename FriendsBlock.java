import java.util.ArrayList;
class Loc{
	int r,c;
	Loc(int row,int col){
		r=row;c=col;
	}
}
public class FriendsBlock {
	static ArrayList<Loc> tmp=new ArrayList<Loc>();
	static int[][] val;
	static void remove(String[] b) {
		while(!tmp.isEmpty()) {
			Loc t=tmp.remove(0);
			val[t.r][t.c]=0;val[t.r+1][t.c]=0;val[t.r][t.c+1]=0;val[t.r+1][t.c+1]=0;
		}
		for(int j=0;j<val[0].length;j++) {
			for(int i=val.length-1;i>=0;i--) {
				if(val[i][j]==1) {
					if(i<val.length-1) {
						int k=i;
						while(i<val.length-1&&val[i+1][j]==0) {
							i++;
						}
						if(i!=k) {
							int t=val[i][j];
							val[i][j]=val[k][j];
							val[k][j]=t;
							String a=b[i].substring(j,j+1);
							if(j<b[i].length()) {
								b[i]=b[i].substring(0,j)+b[k].substring(j,j+1)+b[i].substring(j+1);	
								b[k]=b[k].substring(0,j)+a+b[k].substring(j+1);
							}
							else {
								b[i]=b[i].substring(0,j)+b[k].substring(j,j+1);
								b[k]=b[k].substring(0,j)+a;
							}
							
						}
					}
				}
			}
		}
	}
	public static int solution(int m, int n, String[] board) {
	      int answer = 0;
	      boolean c=true;
	      val=new int[m][n];
	      for(int i=0;i<m;i++) {
	    	  for(int j=0;j<n;j++) {
	    		  val[i][j]=1;
	    		  if(j<board[i].length()-1&&i<board.length-1&&
	    				  (board[i].charAt(j)==board[i].charAt(j+1))&&(board[i].charAt(j)==board[i+1].charAt(j))
							&&(board[i+1].charAt(j)==board[i+1].charAt(j+1)))
	    			  tmp.add(new Loc(i,j));
	    	  }
	      }
	      if(tmp.size()==0) c=false;
	      while(c) {
	    	  remove(board);
	    	  for(int i=0;i<m;i++) {
		    	  for(int j=0;j<n;j++) {
		    		  if(j<board[i].length()-1&&i<board.length-1&&val[i][j]==1&&val[i+1][j]==1&&val[i][j+1]==1&&val[i+1][j+1]==1&&
		    				  (board[i].charAt(j)==board[i].charAt(j+1))&&(board[i].charAt(j)==board[i+1].charAt(j))
								&&(board[i+1].charAt(j)==board[i+1].charAt(j+1)))
		    			  tmp.add(new Loc(i,j));
		    	  }
		      }
	    	  if(tmp.isEmpty()) c=false;
	    	  else c=true;
	      }
	      for(int i=0;i<m;i++)
	    	  for(int j=0;j<n;j++)
	    		  if(val[i][j]==0) answer++;
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"CCBDE","AAADE","AAABF","CCBBF"};
		System.out.println(solution(4,5,s));
		//String[] s= {"TTTANT","RRFACC","RRRFCC","TRRRAA","TTMMMF","TMMTTJ"};
		//System.out.println(solution(6,6,s));
	}

}
