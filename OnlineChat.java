import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashMap;
class Sentence{
	String uid;
	String tail;
	Sentence(String u,String t){
		uid=u;
		tail=t;
	}
}
public class OnlineChat {
	static HashMap<String,String> user=new HashMap<String,String>();
	static ArrayList<Sentence> line=new ArrayList<Sentence>();
	public static String[] solution(String[] record) {
		String uid,cmd,id;
		for(int i=0;i<record.length;i++) {
			StringTokenizer s=new StringTokenizer(record[i]," ");
			cmd=s.nextToken();
			uid=s.nextToken();
			if(cmd.equals("Enter")) {
				id=s.nextToken();
				user.put(uid,id);
				line.add(new Sentence(uid,"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù."));
			}
			else if(cmd.equals("Leave")) {
				line.add(new Sentence(uid,"´ÔÀÌ ³ª°¬½À´Ï´Ù."));
			}
			else if(cmd.equals("Change")) {
				id=s.nextToken();
				user.put(uid,id);
			}
		}
        String[] answer = new String[line.size()];
        for(int i=0;i<line.size();i++)
        	answer[i]=user.get(line.get(i).uid)+line.get(i).tail;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] t={"Enter uid1234 Muzi","Enter uid4567 Prodo",
			"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"	
		};
		String[] s=solution(t);
		for(String i:s)
			System.out.println(i);
	}

}
