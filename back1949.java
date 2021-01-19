import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back1949 {    
        static int[] w;
        static boolean[] visited;
        static int[][] dp;
        static ArrayList<Integer>[] node;
        static int n;

        static int dfs(int now,int state){
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
                        result+=dfs(next,0);
                    }else{
                        result+=Math.max(dfs(next,1),dfs(next,0));
                    }                    
                }
            }
            visited[now]=false;
            dp[now][state]=result;
            return result;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer(bf.readLine());      

            n=Integer.parseInt(st.nextToken());
            w=new int[n+1];
            st=new StringTokenizer(bf.readLine());
            for(int i=1;i<=n;i++){                
                w[i]=Integer.parseInt(st.nextToken());
            }

            node=new ArrayList[n+1];
            visited=new boolean[n+1];
            dp=new int[n+1][2];
            for(int i=0;i<=n;i++)for(int j=0;j<2;j++)dp[i][j]=-1;
            for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
            for(int i=0;i<n-1;i++){
                st=new StringTokenizer(bf.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                node[a].add(b);
                node[b].add(a);
            }
            int ans1=dfs(1,0);
            int ans2=dfs(1,1);
            System.out.println(ans1>ans2?ans1:ans2);
        }    
}
