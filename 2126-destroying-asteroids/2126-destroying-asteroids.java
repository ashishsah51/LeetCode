class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long tm = mass;
        for(int a : asteroids) {
            if(a > tm) return false;
            tm += a;
        }
        return true;
    }
}