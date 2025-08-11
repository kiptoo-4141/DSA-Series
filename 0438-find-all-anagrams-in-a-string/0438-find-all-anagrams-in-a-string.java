class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()){
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int left = 0, right = 0;
        int windowSize = p.length();

        while(right < s.length()){
            windowCount[s.charAt(right) - 'a']++;
            right++;

            if(right - left > windowSize){
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left == windowSize && matches(pCount, windowCount)) {
                result.add(left);
            }
        }

        return result;
    }
    private boolean matches(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}