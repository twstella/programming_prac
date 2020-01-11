
import java.util.*;

class Solution {
    public static int solution(String[][] relation) {
    	
    	int total = (1 << relation[0].length);
        Set<Integer> keys = new HashSet<>();
        for (int i = 1; i < total; ++i) {
            boolean isMinimal = true;
            for (int uniqueKey: keys) {
                if ((uniqueKey & i) == uniqueKey) {
                    isMinimal = false;
                    break;
                } 
            }
            if (!isMinimal) continue;
            int t = i;
            int col = 0;
            String[] strs = new String[relation.length];
            for (int k = 0; k < strs.length; ++k) {
                strs[k] = "";
            }
            while (t > 0) {
                if ((t & 1) == 1) {
                    for (int k = 0; k < relation.length; ++k) {
                        strs[k]+=relation[k][col];
                    }
                }
                t >>= 1;
                col++;
            }
            Set<String> set = new HashSet<>();
            for (String sb: strs) {
                set.add(sb.toString());
            }
            if (set.size() == strs.length) {
                keys.add(i);
            }
        }
        return keys.size();
    }
    public static void main(String[] args) {
    	String[][] t= {{"3","5","4","3","4","4","2","6"},{"4","4","2","6","8","5","7","2"},{"8","5","7","2","3","4","4","6"},
				{"3","4","4","6","3","5","4","3"},{"3","5","4","4","8","5","3","4"},{"5","4","5","7","4","4","2","6"}};
    	System.out.println(solution(t));
    }
}
