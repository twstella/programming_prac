
public class DartGame {
	public static boolean isDigit(char n) {
		if('0'<=n&&n<='9') return true;
		else return false;
	}
	public static boolean isChar(char n) {
		if(n=='S'||n=='D'||n=='T') return true;
		else return false;
	}
	 public static int solution(String dart) {
	      int answer = 0;
	      boolean aster=false;
	      String[][] score=new String[3][3];
	      int i=0,j=0;
	      for(int a=0;a<3;a++)
	    	  for(int b=0;b<3;b++)
	    		  score[a][b]="";
	      for(i=0;i<dart.length();i++) {
	    	  char t=dart.charAt(i);
	    	  if(isDigit(t)) { score[j][0]+=t;}
	    	  else {
	    		  if(isChar(t)) {
	    			  score[j][1]+=t;
	    			  if(i<dart.length()-1)
	    				  if(isDigit(dart.charAt(i+1))) j++;

	    		  }
	    		  else {
	    			  score[j][2]+=t;
	    			  j++;
	    		  }
	    	  }
	      }
	      for(int a=2;a>=0;a--) {
	    	  int b=Integer.parseInt(score[a][0]);
	    	  if(score[a][1].equals("D")) b=(int)Math.pow((double)b, 2);
	    	  else if(score[a][1].equals("T")) b=(int)Math.pow((double)b, 3);
	    	  if(aster==true) {
	    		  b*=2;
	    		  aster=false;
	    	  }
	    	  if(score[a][2].length()==0) {
	    		  answer+=b; 
	    		  continue;
	    	  }
	    	  if(score[a][2].equals("#")) b*=-1;
	    	  else if(score[a][2].equals("*")) {
	    		  b*=2;
	    		  aster=true;
	    	  }
	    	  answer+=b;
	      }
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="1S2D*3T";
		//String s="1D2S#10S";
		//String s="1D2S0T";
		String s="1S*2T*3S";
		//String s="1D#2S*3S";
		//String s="1T2D3D#";
		//String s="1D2S3T*";
		System.out.print(solution(s));
	}

}
