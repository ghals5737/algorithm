import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back3665 {
    static int n,t,m;
    static int[] order,in;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());        
        t=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            order=new int[n+1];
            in=new int[n+1];
            st=new StringTokenizer(bf.readLine());
            for(int i=1;i<=n;i++){
                order[i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(bf.readLine());
            m=Integer.parseInt(st.nextToken());
            map=new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    map[order[i]][order[j]]=1;
                    in[order[j]]++;
                }
            }
            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine());
                int a=Integer.parseInt(st.nextToken());                
                int b=Integer.parseInt(st.nextToken());
                if(map[a][b]==1){
                    map[a][b]=0;
                    map[b][a]=1;
                    in[b]--;in[a]++;
                }else{
                    map[b][a]=0;
                    map[a][b]=1;
                    in[a]--;in[b]++;
                }
            }
            Queue<Integer>q=new LinkedList<>();
            for(int i=1;i<=n;i++){
                if(in[i]==0)q.add(i);
            }
            ArrayList<Integer>list=new ArrayList<>();
            boolean flag=false;            
            while(!q.isEmpty()){
                if(q.size()>1){                   
                    flag=true;
                    break;
                }
                int now=q.poll();
                list.add(now);
                for(int i=1;i<=n;i++){
                    if(map[now][i]==1){
                        in[i]--;
                        if(in[i]==0)q.add(i);
                    }                    
                }
            }
            if(flag)sb.append("?\n");
            else if(list.size()==n){
                for(int el:list)sb.append(el+" ");
                sb.append("\n");
            }
            else{
                sb.append("IMPOSSIBLE\n");
            }            
        } 
        System.out.println(sb);       
    }    
}
