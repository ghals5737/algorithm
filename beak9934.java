import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak9934 {
    static int k;
    static int[] arr;
    static ArrayList<Integer>[] arr1;
    static void dq(int l,int r,int level){
        int mid=(l+r)/2;
        arr1[level].add(arr[mid]);
        if(l>=r)return;
        dq(l, mid-1, level+1);
        dq(mid+1,r, level+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        k=Integer.parseInt(st.nextToken());
        arr=new int[1<<k];
        arr1=new ArrayList[k];
        for(int i=0;i<k;i++)arr1[i]=new ArrayList<>();
        st=new StringTokenizer(bf.readLine()); 
        for(int i=1;i<1<<k;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dq(1,(1<<k)-1,0);
        for(int i=0;i<k;i++){
            for(int num:arr1[i]){
                sb.append(num+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }    
}
