import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak1024 {
    static int n,l;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        for(int i=l;i<=100;i++){
            int num=n-i*(i+1)/2;
            if(num%i==0){
                int a=num/i+1;
                if(a>=0){
                    for(int j=0;j<i;j++)System.out.print((a+j)+" ");
                    System.out.println();
                    return;
                }              
            }
        }
        System.out.println(-1);
    }    
}
