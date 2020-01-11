package progrmmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;

class Song{
	int num;
	int cnt;
	Song(int i,int j){
		num=i;
		cnt=j;
	}
}
class SongList {
	String genre;
	int cnt;
	ArrayList<Song> songs;
	SongList(){
		songs=new ArrayList();
		cnt=0;
	}
}
public class SongRequest {
	public static int[] solution(String[] genres,int[] plays) {
		int[] answer= {};
		HashMap<String,SongList> map=new HashMap();
		int len=genres.length;
		for(int i=0;i<len;i++) {
			if(!map.containsKey(genres[i])) {
				SongList list=new SongList();
				list.genre=genres[i];
				list.cnt=plays[i];
				list.songs.add(new Song(i,plays[i]));
				map.put(genres[i],list);
			}
			else {
				SongList list=map.get(genres[i]);
				list.cnt+=plays[i];
				list.songs.add(new Song(i,plays[i]));
			}
		}
		ArrayList<SongList> tmp=new ArrayList<SongList>();
		for(String key:map.keySet()) {
			tmp.add(map.get(key));
		}
		Collections.sort(tmp,new Comparator<SongList>() {
			@Override
			public int compare(SongList a,SongList b) {
				return b.cnt-a.cnt;
			}
		});
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(SongList t:tmp) {
			Collections.sort(t.songs,new Comparator<Song>() {
				public int compare(Song s1,Song s2) {
					int a=s2.cnt;
					int b=s1.cnt;
					int res=a-b;
					if(res!=0) return res;
					else return s1.num-s2.num;
				}
			});
			for(int i=0;i<Math.min(2, t.songs.size());i++)
				list.add(t.songs.get(i).num);
		}
		answer=new int[list.size()];
		for(int i=0;i<answer.length;i++)
			answer[i]=list.get(i);
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres= {"classic","pop","classic","classic","pop"};
		int[] plays= {500,600,150,800,2500};
		int[] ans=solution(genres,plays);
		for(int i=0;i<ans.length;i++)
			System.out.print(ans[i]+" ");
	}

}
