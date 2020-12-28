import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back1765 {
    static int n,m;
    static ArrayList<Integer>[] enemy,friend;
    static int[] check;
    static int cnt;
    static void dfs(int num){
        for(int next:friend[num]){
            if(check[next]==0){
                check[next]=cnt;
                dfs(next);
            }            
        }
        for(int next:enemy[num]){
            for(int nnext:enemy[next]){
                if(check[nnext]==0){
                    check[nnext]=cnt;
                    dfs(nnext);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        enemy=new ArrayList[n+1];
        friend=new ArrayList[n+1];
        check=new int[n+1];
        for(int i=0;i<=n;i++){
            enemy[i]=new ArrayList<>();
            friend[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());           
            String c=st.nextToken();
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(c.equals("E")){
                enemy[a].add(b);
                enemy[b].add(a);
            }else{
                friend[a].add(b);
                friend[b].add(a);
            }            
        }
        cnt=1;
        for(int i=1;i<=n;i++){
            if(check[i]==0){
                check[i]=cnt;
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt-1);
    }    
}
