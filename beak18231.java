import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak18231 {
    static int n,m,k;
    static ArrayList<Integer>[] node;
    static boolean[] v,v1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        v=new boolean[n+1];
        v1=new boolean[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine()); 
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            node[from].add(to);
            node[to].add(from);
        }
        st=new StringTokenizer(bf.readLine()); 
        k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<k;i++){
            v[Integer.parseInt(st.nextToken())]=true;            
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int now=1;now<=n;now++){
            boolean flag=false;
            if(!v[now])continue;
            for(int next:node[now]){
                if(!v[next]){
                    flag=true;
                    break;
                }
            }
            if(!flag)list.add(now);
        }
        for(int now:list){
            v1[now]=true;
            for(int next:node[now]){
                v1[next]=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++)if(v[i]!=v1[i]){System.out.println(-1); return;}
        sb.append(list.size()+"\n");
        for(int num:list)sb.append(num+" ");
        sb.append("\n");
        System.out.println(sb);
    }    
}
