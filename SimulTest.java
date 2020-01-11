
public class SimulTest {
	static int max;
	static int[] st1= {1,2,3,4,5};
	static int[] st2= {2,1,2,3,2,4,2,5};
	static int[] st3= {3,3,1,1,2,2,4,4,5,5};
	static int[] student=new int[3];
	public static int[] solution(int[] answers) {
		for(int i=0;i<answers.length;i++) {
			int n1=st1[i%st1.length];
			if(n1==answers[i])
				student[0]+=1;
			int n2=st2[i%st2.length];
			if(n2==answers[i])
				student[1]+=1;
			int n3=st3[i%st3.length];
			if(n3==answers[i])
				student[2]+=1;
		}
		max=0;
		for(int i:student) {
			if(max<i) max=i;
		}
		int cnt=0;
		for(int i:student) {
			if(max==i) {
				cnt++;
			}
		}
		int[] answer=new int[cnt];
		int j=0;
		for(int i=0;i<3;i++)
			if(student[i]==max)
				answer[j++]=i+1;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t= {1,2,3,4,5};
		//int[] t= {1,3,2,4,2};
		int[] s=solution(t);
		for(int i:s)
			System.out.print(i+" ");
	}

}
