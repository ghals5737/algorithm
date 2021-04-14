class Solution {
    public int reverse(int x) {
        String s=x+"";
        int n=s.length();
        int start=0;
        int end=n-1;
        char[] arr=s.toCharArray();
        if(arr[0]=='-')start=1;
        while(start<=end){
            char tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            end--;
            start++;
        }
        String str=new String(arr);
        int result=0;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        
        }
        return result;
    }
}
