import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak12851 {
    static int a,b;
    static boolean[] v=new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        Queue<Integer>q=new LinkedList<>();
        q.add(a);
        int cnt=0;
        int ans=0;
        boolean flag=false;
        v[a]=true;
        while(!q.isEmpty()){
            int qSize=q.size();
            for(int i=0;i<qSize;i++){
                int now=q.poll();
                v[now]=true;
                if(now==b){
                    flag=true;
                    ans++;                    
                }
                if(now-1>=0&&!v[now-1]){
                    q.add(now-1);
                    //v[now-1]=true;
                }
                if(now+1<=100000&&!v[now+1]){
                    q.add(now+1);
                    //v[now+1]=true;
                }
                if(now*2<=100000&&!v[now*2]){
                    q.add(now*2);
                    //v[now*2]=true;
                }
            }
            if(flag)break;
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(ans);
    }    
}
