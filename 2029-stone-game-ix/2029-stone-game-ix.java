class Solution {
    public boolean stoneGameIX(int[] stones) {
        int zero=0, one=0, two=0;
        for(int stone : stones) {
            if(stone%3==0) zero++;
            else if(stone%3==1) one++;
            else two++;
        }

         System.out.println(zero+" "+one+" "+two);
        if(one==0 && two==0)  return false;
        return (
            (zero%2==1 &&( (one==0 && two>2) || (two==0 && one>2) ) ) ||
            ((zero%2==0 && one!=0 && two!=0) && ((one==1&&two>0) || (two==1&&one>0) || (one==2&&two>1) || (two==2&&one>1) || (one >= two+2) || (two >= one+2) || (one == two) )) ||
            (zero!=1 && zero%2==1 && ( (one > two+2) || (two > one+2)))
        );
    }
}

