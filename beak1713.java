import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak1713 {
    static class Pair{
        int num;
        int time;
        int cnt;
        Pair(int num,int time,int cnt){
            this.num=num;
            this.time=time;
            this.cnt=cnt;
        }
    }
    static PriorityQueue<Pair>pq=new PriorityQueue<>((Pair a,Pair b)->{
        if(a.cnt==b.cnt)return b.time-a.time;
        else return a.cnt-b.cnt;
    });
    static Queue<Pair>q=new LinkedList<>();
    static boolean[] check=new boolean[101];
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<k;i++){
            int num=Integer.parseInt(st.nextToken());
            boolean flag=false;
            while(!pq.isEmpty()){
                Pair p=pq.poll();
                p.time+=1;
                if(p.num==num){
                    flag=true;
                    p.cnt+=1;
                }                
                q.add(new Pair(p.num,p.time,p.cnt));
            }
            while(!q.isEmpty()){
                Pair p=q.poll();
                pq.add(new Pair(p.num, p.time, p.cnt));
            }
            if(flag)continue;
            if(pq.size()<n){
                check[num]=true;
                pq.add(new Pair(num,1,1));                
            }else{
                Pair p=pq.poll();
                check[p.num]=false;
                check[num]=true;
                pq.add(new Pair(num,1,1));                
            }
        }
        PriorityQueue<Integer> pq1=new PriorityQueue<>();         
        while(!pq.isEmpty()){
            Pair p=pq.poll();            
            pq1.add(p.num);
        }
         
        while(!pq1.isEmpty()){
            int num=pq1.poll();
            sb.append(num+" ");
        }
        System.out.println(sb);
    }    
}
