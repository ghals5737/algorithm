import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back8981 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        arr=new int[n];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++)arr[i]=Integer.parseInt(st.nextToken());
        int now=0;
        int cnt=0;
        int value=0;
        int[] ans=new int[n];
        while(cnt<n){           
            value=arr[cnt];
            while(ans[now]!=0){                
                now=(now+1)%n;
            }
            arr[cnt]=0;
            ans[now]=value;           
            now=(now+value)%n;              
            cnt++;            
        }
        System.out.println(n);
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();

    }    
}
