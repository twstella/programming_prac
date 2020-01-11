import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
class Node{
	int num;
	int x,y;
	Node left,right;
	Node(int n,int x,int y){
		left=null;right=null;
		num=n;this.x=x;this.y=y;
	}
	void insert(Node n) {
		if(n.x<x) left=n;
		else right=n;
	}
}
class NodeList{
	Node root;
	ArrayList<Integer> d;
	NodeList(Node n){
		root=n;
		d=new ArrayList<Integer>();
	}
	Node input(Node r,Node n) {
		Node p=r;
		if(p==null) return n;
		else if(n.x<p.x) {
			p.left=input(p.left,n);
			return p;
		}
		else if(n.x>p.x) {
			p.right=input(p.right,n);
			return p;
		}
		else return p;
	}
	void resetList() {
		d=new ArrayList<Integer>();
	}
	void printPre(Node n) {
		if(n==null) return;
		else {
			d.add(n.num);
			printPre(n.left);
			printPre(n.right);
		}
	}
	void printPost(Node n) {
		if(n==null) return;
		else {
			printPost(n.left);
			printPost(n.right);
			d.add(n.num);
		}
	}
}
public class FindingRoad {
	static Node[] list;
	public static int[][] solution(int[][] nodeinfo) {
		list=new Node[nodeinfo.length];
		for(int i=0;i<nodeinfo.length;i++) {
			list[i]=new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]);
		}
		Arrays.sort(list,new Comparator<Node>() {
			public int compare(Node o1,Node o2) {
				int r=o2.y-o1.y;
				if(r==0) r=o1.x-o2.x;
				return r;
			}
		});
		NodeList n=new NodeList(list[0]);
		for(int i=1;i<nodeinfo.length;i++)
			n.input(n.root,list[i]);
        int[][] answer= new int[2][nodeinfo.length];
        n.printPre(n.root);
        for(int i=0;i<nodeinfo.length;i++) {
        	answer[0][i]=n.d.get(i);
        }
        n.resetList();
        n.printPost(n.root);
        for(int i=0;i<nodeinfo.length;i++)
        	answer[1][i]=n.d.get(i);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		int[][] t=solution(a);
		for(int i=0;i<2;i++) {
			for(int j=0;j<t[i].length;j++)
				System.out.print(t[i][j]);
			System.out.println();
		}
	}

}
