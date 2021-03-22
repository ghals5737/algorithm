import java.util.HashMap;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak7785 {
    static HashMap<String,String>map=new HashMap<>();    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String a=st.nextToken();
            String b=st.nextToken();
            map.put(a,b);
        }
        PriorityQueue<String>pq=new PriorityQueue<>((a,b)->b.compareTo(a));
        for(String key:map.keySet()){
            if(map.get(key).equals("enter")){
                pq.add(key);
            }
        }
        
        while(!pq.isEmpty()){
            sb.append(pq.poll()+"\n");
        }
        System.out.print(sb);
    }    
}
