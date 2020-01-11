import java.util.Arrays;
import java.util.Comparator;
public class SortObjects1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr= {"lost child","goodbye like yesterday","bookmark","secret garden","secret love story","take a bow"};
		Arrays.sort(arr,new Comparator<String>() {
			public int compare(String o1,String o2) {
				return o1.compareTo(o2);
			}
		});
		for(String s:arr) {
			System.out.print(s+" ");
		}
		System.out.println();
		int[][] num= {{1,2},{5,1},{4,3},{2,2},{3,1},{5,2}};
		Arrays.sort(num,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				return o2[1]-o1[1];
			}
		});
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<num[i].length;j++) {
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}
	}

}
