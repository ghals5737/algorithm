import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back15971 {
    static class Node{
        int to;
        int cost;
        public Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    static int n,r1,r2;
    static ArrayList<Node>[] node; 
    static boolean[] visited;  
    static boolean flag=false;
    static void dfs(int now,int total,int maxCost){
        if(flag)return;
        if(now==r2){
            flag=true;
            System.out.println(total-maxCost);
            return;
        }   
        visited[now]=true;
        for(Node el:node[now]){
            int next=el.to;
            if(!visited[next]){
                dfs(next,total+el.cost,Math.max(el.cost,maxCost));
            }                        
        }     
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
                        
        n=Integer.parseInt(st.nextToken());
        r1=Integer.parseInt(st.nextToken());
        r2=Integer.parseInt(st.nextToken());

        node=new ArrayList[n+1];
        visited=new boolean[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            node[a].add(new Node(b,cost));
            node[b].add(new Node(a,cost));
        }  
        dfs(r1,0,0);
    }    
}
