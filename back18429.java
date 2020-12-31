import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back18429 {
    static int n,k;
    static int[] arr;
    static boolean[] check;
    static int ans;
    static void dfs(int w,int cnt){
        if(cnt==n){
            ans++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!check[i]){
                check[i]=true;
                if(w-k+arr[i]>=500){
                    dfs(w-k+arr[i],cnt+1);
                }
                check[i]=false;
            }
        }        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n];
        check=new boolean[n];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++)arr[i]=Integer.parseInt(st.nextToken());
        ans=0;
        dfs(500,0);
        System.out.println(ans);
    }
}
