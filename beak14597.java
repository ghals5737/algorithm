import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak14597 {
	static int n,m;
	static int[][] arr1,arr2;
	// static long dfs(int h,int a,int b,long sum) {
	// 	long num=(arr1[h][a]-arr2[h][b])*(arr1[h][a]-arr2[h][b]);
	// 	if(h==n-1) {
	// 		return sum;
	// 	}
	    
	// }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr1=new int[n][m];
		arr2=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr1[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr2[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
