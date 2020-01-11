import java.util.Arrays;
class FileN implements Comparable<FileN>{
	String head,num,tail;
	FileN(String s){
		head=new String();
		num=new String();
		tail=new String();
		int i=0,j;
		for(i=0;i<100;i++) {
			char c=s.charAt(i);
			if(!isNum(c)) head+=c;
			else break;
		}
		for(j=i;j<i+5&&j<s.length();j++) {
			char c=s.charAt(j);
			if(isNum(c)) num+=c;
			else break;
		}
		for(int a=j;a<s.length();a++) {
			char c=s.charAt(a);
			tail+=c;
		}
	}
	public int compareTo(FileN o) {
		int r=this.head.toLowerCase().compareTo(o.head.toLowerCase());
		if(r==0) {
			int a=Integer.parseInt(this.num),b=Integer.parseInt(o.num);
			r=a-b;
		}
		return r;
	}
	boolean isNum(char c) {
		if(c>='0'&&c<='9') return true;
		else return false;
	}
}
public class FileSort {
	static FileN[] list;
	public static String[] solution(String[] files) {
	      String[] answer = new String[files.length];
	      list=new FileN[files.length];
	      for(int i=0;i<list.length;i++) {
	    	  list[i]=new FileN(files[i]);
	      }
	      Arrays.sort(list);
	      for(int i=0;i<list.length;i++)
	    	  answer[i]=list[i].head+list[i].num+list[i].tail;
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] list= {"img12.png","img10.png","img02.png","img1.png","IMG01.GIF","img2.JPG"};
		//String[] list= {"F-5 Freedom Fighter","B-50 Superfortress","A-10 Thunderbolt II","F-14 Tomcat"};
		//String[] list= {"muzi1.txt","muzi1.txt","muzi001.txt","muzi1.txt"};
		String[] list= {"foo9.txt","foo010bar020.zip","F-15"};
		list=solution(list);
		for(String s:list)
			System.out.println(s);
	}

}
