class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);
        // Check against all powers of two
        for (int i = 0; i < 31; i++) { 
            if (target.equals(sortDigits(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private String sortDigits(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}