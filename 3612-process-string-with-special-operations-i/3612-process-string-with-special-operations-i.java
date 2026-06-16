class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c=='#') sb.append(sb);
            else if(c=='%') sb = sb.reverse();
            else if(c=='*') {
                if(!sb.isEmpty())sb.deleteCharAt(sb.length()-1);
            }
            else sb.append(c);
        }
        return sb.toString();
    }
}