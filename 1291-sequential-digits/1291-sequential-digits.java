class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int l1 =getLen(low), l2 =getLen(high);
        for(int len=l1; len <=l2; len++) {
            for(int i=1; i<=9; i++) {
                long val = makeDigit(i, len);
                if(val >= low && val <= high) ans.add((int)val);
            }
        }
        return ans;
    }
    long makeDigit(int first, int len) {
        long val = 0;
        // System.out.print(first+" "+len+" ");
        while(len >= 1) {
            if(first > 9) return -1;
            val = val * 10 + first;
            first++;
            len--;
        }
        // System.out.println(val);
        return val;
    }
    int getLen(int num) {
        if(num >= 1000000000) return 10;
        else if(num >= 100000000) return 9;
        else if(num >= 10000000) return 8;
        else if(num >= 1000000) return 7; 
        else if(num >= 100000) return 6; 
        else if(num >= 10000) return 5; 
        else if(num >= 1000) return 4; 
        else if(num >= 100) return 3; 
        else if(num >= 10) return 2; 
        return 1;
    }
}