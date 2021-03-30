import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak1781 {
    static class Pair{
        int dead;
        int cup;
        Pair(int dead,int cup){
            this.dead=dead;
            this.cup=cup;
        }
    }
    static PriorityQueue<Pair>pq=new PriorityQueue<>((Pair a,Pair b)->{
       return a.dead-b.dead;
    }); 
    static PriorityQueue<Pair>pq1=new PriorityQueue<>((Pair a,Pair b)->{
        return a.cup-b.cup;
     });

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        int n=Integer.parseInt(st.nextToken());       
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            int dead=Integer.parseInt(st.nextToken());
            int cup=Integer.parseInt(st.nextToken());
            pq.add(new Pair(dead,cup));
        }
        int now=0;
        int ans=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            pq1.add(p);
            while(p.dead<pq1.size()){
                pq1.poll();
            }
        }
        while(!pq1.isEmpty()){
            ans+=pq1.poll().cup;
        }
        System.out.println(ans);
    }    
}
