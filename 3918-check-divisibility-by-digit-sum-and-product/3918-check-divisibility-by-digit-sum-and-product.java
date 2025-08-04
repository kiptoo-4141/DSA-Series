class Solution {
    public boolean checkDivisibility(int n) {
        int copy = n;
        int sum = 0;
        int mul = 1;
        while(n > 0){
            int ele = n%10;
            sum += ele;
            mul *= ele;
            n = n/10;
        }

        if((copy % (sum + mul)) == 0){
            return true;
        }
        return false;
    }
}