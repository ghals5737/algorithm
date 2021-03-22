import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak1774 {
    static class Pair{
        int from;
        int to;
        double cost;
        Pair(int from,int to,double cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }
    static int n,m;
    static boolean[][] v;
    static ArrayList<Pair>node=new ArrayList<>();
    static ArrayList<Pair>list=new ArrayList<>();
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
        StringBuilder sb=new StringBuilder();  
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());        
        v=new boolean[n+1][n+1];
        arr=new int[n+1];        
        list.add(new Pair(1,1,1));
        for(int i=0;i<=n;i++)arr[i]=i;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0));
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine()); 
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            v[a][b]=true;
            v[b][a]=true;
            node.add(new Pair(a,b,0.0));
        }
        for(int i=1;i<=n;i++){            
            for(int j=1;j<=n;j++){
                if(i!=j&&!v[i][j]){
                    Pair a=list.get(i);
                    Pair b=list.get(j);
                    double cost=Math.sqrt((a.from-b.from)*(a.from-b.from)+(a.to-b.to)*(a.to-b.to));
                    node.add(new Pair(i,j,cost));
                }
            }
        }
        ans=0.0;
        DecimalFormat df = new DecimalFormat("#######.00");
        node.sort((Pair a,Pair b)->Double.compare(a.cost,b.cost));
        for(Pair p:node){
            merge(p.from,p.to,p.cost);
        }
        System.out.println(df.format(ans));        
    }
}
