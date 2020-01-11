import java.util.Arrays;
import java.util.Scanner;
public class Closest {

	public static void main(String[] args) {
		int i,j,pNum,qNum,py,qy,k,min,sub,count=1;
		Scanner key=new Scanner(System.in);
		
		pNum=key.nextInt();
		qNum=key.nextInt();
		int[] pSet=new int[pNum];
		int[] qSet=new int[qNum];
		py=key.nextInt();
		qy=key.nextInt();
		for(i=0;i<pNum;i++)
			pSet[i]=key.nextInt();
		for(i=0;i<qNum;i++)
			qSet[i]=key.nextInt();
		key.close();
		sub=Math.abs(py-qy);
		Arrays.sort(pSet);
		Arrays.sort(qSet);
		i=0;j=0;
		min=Math.abs(qSet[qNum-1]-pSet[0]);
		while((i<pNum)&&(j<qNum)) {
			k=Math.abs(pSet[i]-qSet[j]);
			
			if(k<min) {
				min=k;
				count=1;
			}
			else if(k==min)
				count++;
			
			//System.out.println(pSet[i]+" "+qSet[j]);
			if(pSet[i]<qSet[j]) {
				i++;
			}
			else {
				j++;
			}
			//System.out.println("i:"+i+" j:"+j);
		}
		System.out.println(min+sub+" "+count);

	}

}
