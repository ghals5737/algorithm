import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak14238 {
    static int n;
    static String s;
    static int[] check;
    static boolean flag;
    static boolean[][][][][] dp=new boolean[51][51][51][51][51];
    static void dp(int a,int b,int c,int back1,int back2,String ans){
        if(a==check[0]&&b==check[1]&&c==check[2]){
            flag=true;
            System.out.println(ans);
            return;
        }
        if(flag)return;        
        if(dp[a][b][c][back1][back2])return;
        dp[a][b][c][back1][back2]=true;
        if(a+1<=check[0]){
            dp(a+1,b,c,back2,0,ans+"A");
        }        
        if(b+1<=check[1]&&back2!=1){
            dp(a,b+1,c,back2,1,ans+"B");            
        }        
        if(c+1<=check[2]&&back1!=2&&back2!=2){
            dp(a,b,c+1,back2,2,ans+"C");            
        }        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        s=st.nextToken();
        n=s.length();
        check=new int[3];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            check[c-'A']++;
        }     
        flag=false;
        dp(0,0,0,0,0,"");
        if(!flag)System.out.println(-1);
    }    
}
