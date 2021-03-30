import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class beak1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        String s=st.nextToken();
        s=s.toUpperCase();
        HashMap<Character,Integer>map=new HashMap<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
            ans=Math.max(ans,map.get(c));
        }
        int cnt=0;
        char res='?';
        for(char c:map.keySet()){            
            if(ans==map.get(c)){
                cnt++;
                res=c;
            }
        }
        if(cnt>1)System.out.println('?');
        else System.out.println(res);
    }    
}
