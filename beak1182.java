import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1182 {
	static int n,s;
	static int[] arr;	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		s=Integer.parseInt(st.nextToken());
		arr=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		for(int i=0;i<(1<<n);i++) {
			int sum=0;
			for(int j=0;j<n;j++) {
				if((i&(1<<j))>0) {
					sum+=arr[j];
					//System.out.print(arr[j]+" ");
				}
			}			
			if(sum==s) {
				//System.out.println("!@!@: "+sum);				
				cnt++;
			}
		}			
		if(s==0)cnt--;
		System.out.println(cnt);		
	}
}
