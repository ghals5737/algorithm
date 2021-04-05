import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak14675 {
    static class Pair{
        int from;
        int to;
        Pair(int from,int to){
            this.from=from;
            this.to=to;
        }        
    }
    static int n,m,cnt,num;    
    static ArrayList<Pair>list=new ArrayList<>();
    static ArrayList<Pair>isC=new ArrayList<>();
    static ArrayList<Integer>[] node;
    static boolean[] isCut;
    static int[] dicoverd;

    static int dfs(int now,boolean isRoot){
             dicoverd[now]=++num;
             int ret=dicoverd[now];
             int child=0;
             for(int next:node[now]){
                 if(dicoverd[next]>0){
                     ret=Math.min(ret,dicoverd[next]);
                     continue;
                 }
                 int prev=dfs(next,false);
                 if(!isRoot&&prev>=dicoverd[now])isCut[now]=true;
                 ret=Math.min(ret,prev);
             }
             if(isRoot)isCut[now]=(child>=2);
             return ret;
    }
    static int dfs1(int now,int p){
        dicoverd[now]=++num;
        int ret=dicoverd[now];       
        for(int next:node[now]){
            if(next==p)continue;
            if(dicoverd[next]>0){
                ret=Math.min(ret,dicoverd[next]);
                continue;
            }
            int prev=dfs1(next,now);
            if(prev>dicoverd[now])isC.add(new Pair(Math.min(now,p),Math.max(now,p)));
            ret=Math.min(ret,prev);
        }        
        return ret;
}
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        isCut=new boolean[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());            
            node[from].add(to);
            node[to].add(from);
            if(from>to){
                int tmp=from;
                from=to;
                to=tmp;
            }
            list.add(new Pair(from, to));
        }
        num=0;
        dicoverd=new int[n+1];
        for(int i=1;i<=n;i++)if(dicoverd[i]==0)dfs(i, true);
        num=0;
        dicoverd=new int[n+1];
        for(int i=1;i<=n;i++)if(dicoverd[i]==0)dfs1(i, 0);
        st=new StringTokenizer(bf.readLine()); 
        m=Integer.parseInt(st.nextToken());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine()); 
            int t=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());            
            if(t==1){
                if(isCut[num])sb.append("yes\n");
                else sb.append("no\n");
            }else{
                Pair now=list.get(num-1);
                boolean flag=false;
                for(Pair p:isC){
                    if(p.from==now.from&&p.to==now.to){
                        flag=true;
                        break;
                    }
                }
                if(flag)sb.append("yes\n");
                else sb.append("no\n");
            }
        }
        System.out.print(sb);
    }    
}
