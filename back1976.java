import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back1976 {
    static int n,m;
    static int[] arr;
    static int find(int x){
        if(arr[x]==x)return x;
        else return find(arr[x]);
    }
    static void merge(int a,int b){
        a=find(a);
        b=find(b);        
        if(a!=b){
            if(a>b){
                arr[a]=b;
            }else{
                arr[b]=a;
            }            
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n+1];
        for(int i=0;i<=n;i++)arr[i]=i;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                int num=Integer.parseInt(st.nextToken());
                if(num==1){
                    merge(i+1,j+1);
                }
            }
        }
        st=new StringTokenizer(bf.readLine());
        int prev=0;
        for(int i=0;i<m;i++){
            int num=Integer.parseInt(st.nextToken());
            if(i==0)prev=find(num);
            else{
                int now=find(num);
                if(now!=prev){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");        
    }
}
