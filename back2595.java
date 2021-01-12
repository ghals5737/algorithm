import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class back2595 {
	static String[] arr= {"000000","001111","010011","011100","100110","101001","110101","111010"};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String s=st.nextToken();
		String ans="";
		for(int i=0;i<n;i++) {
			String sub=s.substring(i*6,(i+1)*6);
			boolean flag=false;
			for(int j=0;j<8;j++) {
				int cnt=0;
				flag=false;
				for(int k=0;k<6;k++) {
					char c=arr[j].charAt(k);
					char cc=sub.charAt(k);
					if(c!=cc)cnt++;
				}
				if(cnt<2) {
					ans+=(char)(j+'A')+"";
					flag=true;
				}
				if(flag)break;
			}
			if(!flag) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(ans);		
	}
}
