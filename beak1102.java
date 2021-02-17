import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak1102 {
     static int n,p;
     static int[][] map;
     static int[] dp;
     static int INF=987654321;
     static int dp(int cnt,int stat){
         if(cnt==p)return 0;
         if(dp[stat]!=-1)return dp[stat];
         dp[stat]=INF;
         for(int from=1;from<=n;from++){             
                if((stat&(1<<from))>0){
                    for(int to=1;to<=n;to++){
                     if(to==from)continue;
                     if((stat&(1<<to))==0){
                         dp[stat]=Math.min(dp[stat],dp(cnt+1, stat|(1<<to))+map[from][to]);
                     }
                 }
             }
         }
         return dp[stat];         
     }         
     public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        map=new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            for(int j=1;j<=n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(bf.readLine()); 
        String s=st.nextToken();
        int stat=1;
        dp=new int[(1<<(n+1))+1];
        for(int i=0;i<=(1<<(n+1));i++)dp[i]=-1;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!='N'){
                stat|=(1<<(i+1));
                cnt++;
            }            
        }       
        st=new StringTokenizer(bf.readLine()); 
        p=Integer.parseInt(st.nextToken());    
        if(cnt==0){
            if(p==0)System.out.println(0);
            else System.out.println(-1);
        }
        else if(cnt>=p)System.out.println(0);
        else{
            System.out.println(dp(cnt, stat));
        }      
     }   
}
