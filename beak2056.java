import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak2056 {
    static int n;    
    static int[] indegree;
    static ArrayList<Integer>[] node;
    static int[] cost;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        indegree=new int[n+1];
        node=new ArrayList[n+1];
        cost=new int[n+1];
        time=new int[n+1];

        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            cost[i]=Integer.parseInt(st.nextToken());
            time[i]=cost[i];
            int m=Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++){
                int num=Integer.parseInt(st.nextToken());
                indegree[i]++;
                node[num].add(i);
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0)q.add(i);
        }
        int ans=0;
        while(!q.isEmpty()){
            int now=q.poll();
            for(int next:node[now]){
                if(time[next]<time[now]+cost[next]){
                    time[next]=time[now]+cost[next];
                }
                indegree[next]--;
                if(indegree[next]==0)q.add(next);
            }
        }
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,time[i]);
        }
        System.out.println(ans);
    }    
}
