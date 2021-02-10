import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak18235 {
    static class Ori{
        int a;
        int b;
        int cnt;
        public Ori(int a,int b,int cnt){
            this.a=a;
            this.b=b;
            this.cnt=cnt;
        }
    }
    static int n,aa,bb;    
    static int[] dx={-1,1};
    static HashSet<String>set=new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());   
        n=Integer.parseInt(st.nextToken());
        aa=Integer.parseInt(st.nextToken());
        bb=Integer.parseInt(st.nextToken());
        PriorityQueue<Ori>pq=new PriorityQueue<>((Ori a,Ori b)->{return a.cnt-b.cnt;});
        pq.add(new Ori(aa,bb,0));      
        set.add((aa+"")+(bb+""));
        while(!pq.isEmpty()){
            Ori o=pq.poll();
            if(o.a==o.b){
                System.out.println(o.cnt);
                return;
            }
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    int na=o.a+dx[i]*(1<<o.cnt);
                    int nb=o.b+dx[j]*(1<<o.cnt);                    
                    if(na>0&&na<=n&&nb<=0&&nb>n){
                        String sa=na+"";
                        String sb=nb+"";
                        if(!set.contains(sa+sb)){
                            set.add(sa+sb);
                            pq.add(new Ori(na,nb,o.cnt+1));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
