import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak16437 {
    static int[] costs;
    static int n;
    static long ans;
    static ArrayList<Integer>[]node;    
    static long dfs(int now){        
        long sum=0;
        for(int next:node[now]){
            sum+=dfs(next);
        }
        sum+=costs[now];
        if(sum<0)return 0;
        else return sum;   
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        n=Integer.parseInt(st.nextToken());   
        node=new ArrayList[n+1];
        costs=new int[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();        
        for(int i=2;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            String t=st.nextToken();
            int cost=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            if(t.equals("W"))cost*=-1; 
            costs[i]=cost;
            node[to].add(i);
        }           
        System.out.println(dfs(1));
    }    
}
