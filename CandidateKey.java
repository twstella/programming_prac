import java.util.ArrayList;
public class CandidateKey {
	static String[] mask;
	static void digit(int n) {
		mask=new String[(1<<n)-1];
		for(int i=1;i<=mask.length;i++) {
			mask[i-1]=Integer.toBinaryString(i);
			while(mask[i-1].length()<n) {
				mask[i-1]="0"+mask[i-1];
			}
		}
	}
	static int solution(String[][] relation) {
		digit(relation[0].length);
		ArrayList<Integer> an=new ArrayList<Integer>();
		for(int i=0;i<mask.length;i++) {
			ArrayList<String> tmp=new ArrayList<String>();
			for(int j=0;j<relation.length;j++) {
				String t="";
				for(int k=0;k<relation[0].length;k++) {
					if(mask[i].charAt(k)=='1') t+=relation[j][k];
				}
				if(!tmp.contains(t)) tmp.add(t);
				else break;
			}
			if(tmp.size()==relation[0].length) {
				boolean nDup=true;
				for(int n:an) {
					if((n&i)==n) {
						nDup=false;
						break;
					}
				}
				if(nDup) an.add(Integer.parseInt(mask[i]));
			}
		}
		int answer=an.size();
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] t= {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},
				{"500","muzi","music","3"},{"600","apeach","music","2"}};
			
		//String[][] t= {{"3","5","4","3"},{"4","4","2","6"},{"8","5","7","2"},{"3","4","4","6"}};
		//String[][] t= {{"1"}};
		/*
		String[][] t= {{"3","5","4","3","4","4","2","6"},{"4","4","2","6","8","5","7","2"},{"8","5","7","2","3","4","4","6"},
				{"3","4","4","6","3","5","4","3"},{"3","5","4","4","8","5","3","4"},{"5","4","5","7","4","4","2","6"}};
		*/
		System.out.println(solution(t));
	}

}
