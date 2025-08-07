class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] firstIndex = new int[26]; 
        boolean[] seen = new boolean[26]; 

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';

            if (!seen[charIndex]) {
                firstIndex[charIndex] = i;
                seen[charIndex] = true;
            } else {
                int actualDistance = i - firstIndex[charIndex] - 1;
                if (actualDistance != distance[charIndex]) {
                    return false;
                }
            }
        }

        return true;
    }
}