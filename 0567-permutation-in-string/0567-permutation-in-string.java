class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int left = 0, right = 0;
        int windowSize = s1.length();

        while (right < s2.length()) {
            windowCount[s2.charAt(right) - 'a']++;
            right++;

            if (right - left > windowSize) {
                windowCount[s2.charAt(left) - 'a']--;
                left++;
            }

            if (right - left == windowSize && matches(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }

    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}