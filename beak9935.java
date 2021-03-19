import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class beak9935 {
    static String str,bomb;
    static Stack<Character>stack=new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        str=st.nextToken();
        st=new StringTokenizer(bf.readLine()); 
        bomb=st.nextToken();
        for(int i=0;i<str.length();i++){
            stack.add(str.charAt(i));
            if(stack.size()>=bomb.length()){
                int idx=stack.size()-1;
                boolean flag=false;
                for(int j=0;j<bomb.length();j++)if(stack.get(idx-j)!=bomb.charAt(bomb.length()-1-j)){flag=true;break;}
                if(!flag)for(int j=0;j<bomb.length();j++)stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
            return;
        }
        for(int i=0;i<stack.size();i++)sb.append(stack.get(i)+"");
        System.out.println(sb);
    }    
}
