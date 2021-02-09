import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class beak20547 {
    static class Info{
        String name;
        int start;
        int end;
        public Info(String name,int start,int end){
            this.name=name;
            this.start=start;
            this.end=end;
        }
    }
    static int n,m;
    static int[][] dp;
    static int INF=987654321;
    static int ans=0;
    static HashMap<String,Integer>map=new HashMap<>();
    static ArrayList<Info>node=new ArrayList<>();
    static int convert(String str){
        return Integer.parseInt(str.substring(0,2))*60+Integer.parseInt(str.substring(3,5));
    }
    static void solve(int now,int idx){
        Info el=node.get(idx);
        if(now<el.start)now=el.start;
        ans+=el.end-now;
        now=el.end;
        int nIdx=idx;
        while(true){            
            nIdx++;
            if(nIdx==n)return;
            Info next=node.get(nIdx);
            if(next.end>now+dp[idx][nIdx])break;
        }
        solve(now+dp[idx][nIdx],nIdx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String name=st.nextToken();
            String s=st.nextToken();
            String e=st.nextToken();
            map.put(name,i);
            node.add(new Info(name,convert(s),convert(e)));
        }
        for(int i=0;i<n;i++)for(int j=0;j<n;j++)if(i!=j)dp[i][j]=INF;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int s=map.get(st.nextToken());
            int e=map.get(st.nextToken());
            int c=convert(st.nextToken());
            dp[s][e]=c;
            dp[e][s]=c;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dp[i][j]>dp[i][k]+dp[k][j]){
                        dp[i][j]=dp[i][k]+dp[k][j];                        
                    }
                }
            }
        }
        node.sort((Info a,Info b)->{
            if(a.start<b.start){
                return -1;
            }else if(a.start>b.start){
                return 1;
            }else{
                return a.name.compareTo(b.name);
            }
        });
        solve(node.get(0).start,0);
        int h=ans/60;
        int m=ans%60;
        System.out.println(String.format("%02d",h) + ":" + String.format("%02d",m));
    }    
}
