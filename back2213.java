import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back2213 {    
    static int n;
    static int[] w;
    static int[] chk;
    static int[][] dp;    
    static ArrayList<Integer>[] node;
    static ArrayList<Integer>ans=new ArrayList<>();
    static boolean[] visited;

    static int solve(int now,int state){
        int result=dp[now][state];
        if(result!=-1)return result;
        visited[now]=true;
        if(state==1){
            result=w[now];
        }else{
            result=0;
        }
        for(int next:node[now]){
            if(!visited[next]){               
                if(state==1){
                    result+=solve(next,0);                    
                }else{
                    result+=Math.max(solve(next,1),solve(next,0));                    
                }
            }
        }
        dp[now][state]=result;
        visited[now]=false;       
        return result;
    }
    static void tracking(int now,int state){
        visited[now]=true;
        if(state==1){
            ans.add(now);
            for(int next:node[now]){
                if(!visited[next]){
                   tracking(next,0);
                }
            }
        }else{
            for(int next:node[now]){
                if(!visited[next]){
                    if(dp[next][0]>dp[next][1]){
                        tracking(next,0);
                    }else{
                        tracking(next,1);
                    }
                }
            }
        }
        visited[now]=false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        n=Integer.parseInt(st.nextToken());
        w=new int[n+1];
        chk=new int[n+1];
        node=new ArrayList[n+1];
        dp=new int[n+1][2];
        visited=new boolean[n+1];

        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<=n;i++)for(int j=0;j<2;j++)dp[i][j]=-1;
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++){
            w[i]=Integer.parseInt(st.nextToken());            
        }
        for(int i=1;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }
        int ans1=solve(1,0);               
        int ans2=solve(1,1);
        int total=0;
        if(ans1>ans2){
            total=ans1;
            tracking(1,0);
        }else{
            total=ans2;
            tracking(1,1);
        }              
        ans.sort((a,b)->{return a-b;});  
        System.out.println(total);
        for(int num:ans)System.out.print(num+" ");
        System.out.println();
    }    
}
