import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back4386 {
    static class Pair{
        double x;
        double y;
        public Pair(double x,double y){
            this.x=x;
            this.y=y;
        }
    }
    static class Info{
        int a;
        int b;
        double d;
        public Info(int a,int  b,double d){
            this.a=a;
            this.b=b;
            this.d=d;
        }
    }
    static int n;
    static ArrayList<Pair>node=new ArrayList<>();
    static ArrayList<Info>list=new ArrayList<>();
    static int[] arr;
    static double ans;
    static int find(int x){
        if(arr[x]==x)return x;
        else return arr[x]=find(arr[x]);
    }
    static void merge(int a,int b,double cost){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(a>b){
                int tmp=a;
                a=b;
                b=tmp;
            }
            arr[b]=a;
            ans+=cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        n=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            double x=Double.parseDouble(st.nextToken());
            double y=Double.parseDouble(st.nextToken());
            node.add(new Pair(x,y));
        }
        arr=new int[n+1];
        for(int i=0;i<=n;i++)arr[i]=i;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Pair a=node.get(i);
                Pair b=node.get(j);
                double d=Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
                list.add(new Info(i+1,j+1,d));
            }
        }
        list.sort((Info a,Info b)->{
            if(a.d>b.d)return 1;
            else return -1;
        });
        for(Info el:list){
            merge(el.a,el.b,el.d);
        }
        System.out.println(Math.round(ans*100)/100.0);
    }    
}
