package recursion;

public class OnOff {
	public static int[] binary= {0,0,0,0,0};
	public static int end=5;
	public static void Dump() {
		for(int i=0;i<end;i++)
			System.out.print(binary[i]);
		System.out.println();
	}
	public static void traverse(int loc) {
		if(loc==end)
			Dump();
		else {
			for(int i=1;i<=3;i++) {
				binary[loc]=i;
				traverse(loc+1);
			}

		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		traverse(0);
	}

}
