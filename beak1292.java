import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1292 {
    static int[] arr=new int[1001];
    static int a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        int idx=1;
        for(int i=1;i<=1000;i++){
            if(idx>1000)break;
            for(int j=0;j<i;j++){
                if(idx>1000)break;
                arr[idx]=arr[idx-1]+i;
                idx++;
            }
        }
        System.out.println(arr[b]-arr[a-1]);
    }
}
