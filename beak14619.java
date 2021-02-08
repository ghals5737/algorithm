import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak14619 {
    static int n,m,k;
    static int[] arr;
    static int ans;
    static int INF=987654321;
    static ArrayList<Integer>[] node;
    static boolean[] prev;        
    static boolean[] next;
    static void bfs(int start){       
        prev[start]=true;
        for(int i=0;i<k;i++){
            next=new boolean[n+1];
            for(int j=1;j<=n;j++){
                if(prev[j]){
                    for(int nn:node[j]){
                        next[nn]=true;
                    }
                }
            }
            boolean flag=true;
            for(int j=1;j<=n;j++){
                if(prev[j]!=next[j])flag=false;
                prev[j]=next[j];
            }
            if(flag)break;
        }
        for(int j=1;j<=n;j++){
            if(prev[j])ans=Math.min(ans,arr[j]);
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        arr=new int[n+1];
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int to=Integer.parseInt(st.nextToken());
            int from=Integer.parseInt(st.nextToken());
            node[to].add(from);
            node[from].add(to);
        }
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());          
            ans=INF;
            prev=new boolean[n+1];
            bfs(start);
            if(ans==INF)sb.append("-1\n");
            else sb.append(ans+"\n");
        }
        System.out.print(sb);
    }    
}
