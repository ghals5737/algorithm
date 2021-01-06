import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back10800 {
    static class Ball{
        int id;
        int color;
        int w;
        public Ball(int id,int color,int w){
            this.id=id;
            this.color=color;
            this.w=w;
        }
    }
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        ArrayList<Ball>list=new ArrayList<>();
        int[] arr1=new int[n];
        int[] arr2=new int[n+1];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int color=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list.add(new Ball(i, color, w));
        }
        int sum=0;
        list.sort((Ball a,Ball b)->{
            return a.w-b.w;
        });
        for(int i=0,j=0;i<n;i++){
            Ball a=list.get(i);
            Ball b=list.get(j);
            while(b.w<a.w){
                sum+=b.w;
                arr2[b.color]+=b.w;
                b=list.get(++j);
            }
            arr1[a.id]=sum-arr2[a.color];
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(arr1[i]+"\n");
        }
        System.out.println(sb);
    }    
}
