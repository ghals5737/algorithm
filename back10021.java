import java.util.ArrayList;
import java.util.Scanner;

public class back10021 {
    static class Info{
        int from;
        int to;
        int cost;
        public Info(int from,int to,int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }
    static int[] arr=new int[2001];
    static int ans=0;
    static int nn=0;
    
    static int find(int x){
        if(arr[x]==x)return x;
        else return arr[x]=find(arr[x]);
    }

    static void merge(int a,int b,int cost){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(a>b)arr[a]=b;
            else if(a<b)arr[b]=a;
            ans+=cost;
            nn++;
        }
    }


    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int c=sc.nextInt();
         int[] x=new int[n+1];
         int[] y=new int[n+1];
         ArrayList<Info>list=new ArrayList<>();

         for(int i=0;i<2001;i++)arr[i]=i;

         for(int i=0;i<n;i++){
             x[i]=sc.nextInt();
             y[i]=sc.nextInt();
         }

         for(int i=0;i<n;i++){
             for(int j=i+1;j<n;j++){                 
                 int cost=(x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
                 list.add(new Info(i,j,cost));
             }
         }

         list.sort((Info a,Info b)->{
             return a.cost-b.cost;
         });
         ans=0;
         nn=0;

         for(Info el:list){
             if(el.cost>=c){
                 merge(el.from, el.to, el.cost);
                 if(nn==n-1)break;
             }
         }
         if(nn!=n-1){
             System.out.println(-1);
         }
         else{
            System.out.println(ans);
         }
        

    }    
}
