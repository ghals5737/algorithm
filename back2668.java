import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2668 {
    static int n,ans;
    static int[] arr=new int[101];
    static int[] result=new int[101];
    static boolean[] visited;
    
    static void dfs(int idx,int start){
        if(visited[idx]){
            if(idx==start)result[ans++]=idx;         
        }else{
            visited[idx]=true;
            dfs(arr[idx],start);
        }        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());    
        n=Integer.parseInt(st.nextToken());       
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            arr[i+1]=Integer.parseInt(st.nextToken());
        }
        ans=0;
        for(int i=1;i<=n;i++){
            visited=new boolean[n+1];
            dfs(i,i);
        }        
        StringBuilder sb=new StringBuilder();
        sb.append(ans+"\n");
        for(int i=0;i<ans;i++){
            sb.append(result[i]+"\n");
        }
        System.out.println(sb);
    }    
}
