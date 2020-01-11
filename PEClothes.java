import java.util.ArrayList;
public class PEClothes {
	static int[] students;
	
	public static int solution(int n, int[] lost, int[] reserve) {
        ArrayList<String> re=new ArrayList<String>();
		students=new int[n];
        for(int i=0;i<n;i++)
        	students[i]=1;
        for(int i:lost)
        	students[i-1]-=1;
        for(int i:reserve)
        	students[i-1]+=1;
        for(int i=0;i<n;i++)
        	if(students[i]==2) re.add(""+i);
        for(int i=0;i<n;i++) {
        	if(students[i]==0) {
        		if(re.contains(""+(i-1))) {
        			students[i]+=1;
        			students[i-1]-=1;
        			re.remove(""+(i-1));
        		}
        		else if(re.contains(""+(i+1))) {
        			students[i]+=1;
        			students[i+1]-=1;
        			re.remove(""+(i+1));
        		}
        	}
        }
        int answer=0;
        for(int i:students)
        	if(i>=1) answer++;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int n=5;
		int[] lost= {2,4};
		int[] reserve= {1,3,5};
		int n=3;
		int[] lost= {3};
		int[] reserve= {1};
		int n=6;
		int[] lost= {2,6};
		int[] reserve= {1,4};
		int n=30;
		int[] lost= {1,2,3,4};
		int[] reserve= {1,4,5};
		*/
		int n=7;
		int[] lost= {2,3,4};
		int[] reserve= {1,2,3,6};
		System.out.println(solution(n,lost,reserve));
	}

}
