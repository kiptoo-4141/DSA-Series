class Solution {
    public String decodeString(String s) {
        Stack<Integer> stackInt = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
                // stackInt.push(Character.getNumericValue(ch));
            }
            else if(ch == '['){
                // insert current number and string into stack
                stackInt.push(k);
                stackStr.push(current.toString());

                // for new string and number
                current = new StringBuilder();
                k = 0;
            }
            else if(ch == ']'){
                StringBuilder decoded = new StringBuilder(stackStr.pop());
                int currentNum = stackInt.pop();
                
                for (int i = 0; i < currentNum; i++) {
                    decoded.append(current);
                }
                current = decoded;
            }
            else {
                current.append(ch);
            }

        }
       
        return current.toString();
    }
}