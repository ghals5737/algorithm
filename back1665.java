import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back1665 {
    static int n;
    static PriorityQueue<Integer>maxPq=new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer>minPq=new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int num=Integer.parseInt(st.nextToken());
            if(maxPq.size()==minPq.size()){
                maxPq.add(num);
            }else{
                minPq.add(num);
            }
            if(!maxPq.isEmpty()&&!minPq.isEmpty()&&maxPq.peek()>minPq.peek()){
                int a=maxPq.poll();
                int b=minPq.poll();
                maxPq.add(b);
                minPq.add(a);
            }
            sb.append(maxPq.peek()+"\n");
        }
        System.out.println(sb);
    }    
}
