import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak16987 {
	static class Pair{
		int c;
		int w;
		public Pair(int c,int w) {
			this.c=c;
			this.w=w;
			
		}
	}
	static int n,ans;
	static Pair[] arr;
	static void dfs(int idx) {
		if(n==idx) {
			int count=0;
			for(int i=0;i<n;i++) {
				if(arr[i].c<=0)count++;
			}
			ans=Math.max(ans,count);
			return;
		}		
		if(arr[idx].c>0) {
			boolean flag=false;
			for(int i=0;i<n;i++) {
				if(idx==i)continue;
				if(arr[i].c>0) {
					arr[i].c-=arr[idx].w;
					arr[idx].c-=arr[i].w;
					flag=true;
					dfs(idx+1);
					arr[i].c+=arr[idx].w;
					arr[idx].c+=arr[i].w;
				}
			}
			if(!flag)dfs(n);
		}else {
			dfs(idx+1);			
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		arr=new Pair[n];
		ans=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			arr[i]=new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));			
		}
		dfs(0);
		System.out.println(ans);
	}

}
