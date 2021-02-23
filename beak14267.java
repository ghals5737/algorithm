import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak14267 {
    static int n,m;
    static ArrayList<Integer>[] node;
    static int[] cost;
    static boolean[] v;
    static void dfs(int now){
        v[now]=true;        
        for(int next:node[now]){
            if(!v[next]){
                cost[next]+=cost[now];
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        cost=new int[n+1];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=1;i<=n;i++){
            int num=Integer.parseInt(st.nextToken());
            node[i]=new ArrayList<>();
            if(i==1)continue;
            node[num].add(i);            
        }        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine()); 
            int now=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());  
            cost[now]+=c;          
        }
        v=new boolean[n+1];
        dfs(1);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++)sb.append(cost[i]+" ");
        System.out.println(sb);
    }    
}
