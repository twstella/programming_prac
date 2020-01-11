package progrmmers;

import java.util.ArrayList;
class Document{
	int id;
	int priority;
	Document(int i,int p){
		id=i;
		priority=p;
	}
}
public class Printer {
	static ArrayList<Document> que=new ArrayList<Document>();
	static int solution(int[] priorities,int loc) {
		for(int i=0;i<priorities.length;i++) {
			que.add(new Document(i,priorities[i]));
		}
		int cnt=1;
		while(true) {
			Document e=que.remove(0);
			int w=findHigher(e.priority);
			if(w==-1) {
				if(loc==e.id) return cnt;
				else cnt++;
			}
			else que.add(e);
		}
	}
	static int findHigher(int p) {
		int max=-1,idx=-1;
		for(int i=0;i<que.size();i++)
			if(max<que.get(i).priority) {
				max=que.get(i).priority;
				idx=i;
			}
		if(p<max) return idx;
		else return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities= {2,1,3,2};
		int loc=2;
		//int[] priorities= {1,1,9,1,1,1};
		//int loc=0;
		System.out.println(solution(priorities,loc));
	}

}
