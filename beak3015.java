import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class beak3015 {
    static int n;
    static Stack<Pair>stack=new Stack<>();
    static int[] arr;
    static class Pair{
        int h;
        int cnt;
        Pair(int h,int cnt){
            this.h=h;
            this.cnt=cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        long ans=0;       
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            int h=Integer.parseInt(st.nextToken());
            int cnt=1;
            while(!stack.isEmpty()){
                if(stack.peek().h<=h){
                    if(stack.peek().h==h)cnt+=stack.peek().cnt;
                    ans+=stack.peek().cnt;                    
                    stack.pop();
                }else if(!stack.isEmpty()){
                    ans+=1;
                    break;
                }
            }
            stack.push(new Pair(h,cnt));
        }       
        System.out.println(ans);
    }    
}
