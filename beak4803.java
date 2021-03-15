import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak4803 {
    static int n,m,v,e;
    static ArrayList<Integer>[] node;
    static boolean[] chk;
    static boolean dfs(int now,int before){
        chk[now]=true;                
        for(int next:node[now]){            
            if(next==before)continue;
            if(chk[next])return false;
            if(!dfs(next,now))return false;            
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringBuilder sb=new StringBuilder();        
        int t=1;
        while(true){
            StringTokenizer st=new StringTokenizer(bf.readLine()); 
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            if(n+m==0)break;
            node=new ArrayList[n+1];
            for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine()); 
                int from=Integer.parseInt(st.nextToken());
                int to=Integer.parseInt(st.nextToken());
                node[from].add(to);                           
                node[to].add(from);
            }            
            int ans=0;
            chk=new boolean[n+1];
            for(int i=1;i<=n;i++){
                if(chk[i])continue;    
                if(dfs(i,0))ans++;             
            }            
            
            sb.append("Case "+t+++": ");             
            switch(ans){
                case 0:
                sb.append("No trees.\n");                
                break;
                case 1:
                sb.append("There is one tree.\n");                
                break;
                default:                
                sb.append("A forest of "+ans+" trees.\n");                                
                break;
            }            
        }
        System.out.println(sb);
    }    
}
