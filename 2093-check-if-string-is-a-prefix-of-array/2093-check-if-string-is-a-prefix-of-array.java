class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder prefix = new StringBuilder();

        for(String str : words){
            prefix.append(str);
            if(prefix.length() > s.length()){
                return false;
            }

            if(prefix.toString().equals(s)){
                return true;
            }
        }

        return false;
    }
}