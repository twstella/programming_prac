package progrmmers;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TripTicket {
	static ArrayList<Integer> entry;
	static ArrayList<ArrayList<Integer>> adj;
	static ArrayList<Integer> path;
	static int[] visited;
	static String[] solution(String[][] tickets) {
		String[] ans= {};
		Arrays.sort(tickets,new Comparator<String[]>(){
			public int compare(String[] o1,String[] o2) {
				int res=o1[0].compareTo(o2[0]);
				if(res==0) {
					return o1[1].compareTo(o2[1]);
				}
				else return res;
			}
		});
		path=new ArrayList<Integer>();
		visited=new int[tickets.length];
		for(int i=0;i<tickets.length;i++) {
			for(int j=0;j<tickets[i].length;j++)
				System.out.print(tickets[i][j]+" ");
			System.out.println();
		}
		entry=new ArrayList<Integer>();
		adj=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<tickets.length;i++) {
			visited[i]=0;
			adj.add(new ArrayList<Integer>());
			if(tickets[i][0].equals("ICN"))
				entry.add(i);
			for(int j=0;j<tickets.length;j++) {
				if(tickets[i][1].equals(tickets[j][0]))
					adj.get(i).add(j);
				if(tickets[j][0].compareTo(tickets[i][1])>0)
					break;
			}
		}

		for(int j=0;j<entry.size();j++) {
			for(int i=0;i<visited.length;i++)
				visited[i]=0;
				boolean b=DFS(entry.get(j));
				if(b==true)  break;
			
		}
		ans=new String[path.size()+1];
		ans[0]="ICN";
		int idx=1;
		for(int i=path.size()-1;i>=0;i--)
			ans[idx++]=tickets[path.get(i)][1];
		return ans;
	}
	static void showGraph(ArrayList<ArrayList<Integer>> a) {
		for(int i=0;i<a.size();i++) {
			System.out.print(i+"-");
			for(int j=0;j<a.get(i).size();j++)
				System.out.print(a.get(i).get(j)+" ");
			System.out.println();
		}
		
	}
	static boolean DFS(int s){
		visited[s]=1;
		if(Done()) {
			path.add(s);
			return true;
		}
		for(int i:adj.get(s)) {
			boolean a=false;
			if(visited[i]==0)
				a=DFS(i);
			if(a==true) {
				path.add(s);
				return true;
			}
		}
		visited[s]=0;
		return false;
	}
	static boolean Done() {
		int n=adj.size();
		for(int i=0;i<n;i++)
			if(visited[i]==0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[][] tmp= {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};
		String[][] tmp= {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
		String[] t=solution(tmp);
		for(String s:t) {
			System.out.print(s+" ");
		}
	}

}
