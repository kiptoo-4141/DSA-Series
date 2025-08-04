class Solution {
    public char processStr(String s, long k) {
        // LinkedList<Character> deque = new LinkedList<>();
        // boolean reversed = false;

        // for(char ch : s.toCharArray()){
        //     if(Character.isLowerCase(ch)){
        //         if(reversed){
        //             deque.addFirst(ch);
        //         }
        //         else{
        //             deque.addLast(ch);
        //         }
        //     }
        //     else if(ch == '*'){
        //         if (!deque.isEmpty()) {
        //             if (reversed) {
        //                 deque.removeFirst();
        //             } else {
        //                 deque.removeLast();
        //             }
        //         }
        //     }
        //     else if(ch == '%'){
        //         reversed = !reversed;
        //     }
        //     else if(ch == '#'){
        //         int size = deque.size();
        //         List<Character> copy = new ArrayList<>(deque);
        //         if (reversed) {
        //             Collections.reverse(copy);
        //         }

        //         for(int i = 0; i < size; i++){
        //             if (reversed) {
        //                 deque.addFirst(copy.get(i));
        //             } else {
        //                 deque.addLast(copy.get(i));
        //             }
        //         }

        //     }
        // }

        // if (k < 0 || k >= deque.size()) return '.';

        // if (reversed) {
        //     return deque.get(deque.size() - 1 - (int)k);
        // } else {
        //     return deque.get((int)k);
        // }







        long len = 0;

        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)){
                len++;
            }
            else if(ch == '*' && len > 0){
                len--;
            }
            else if(ch == '#'){
                len *= 2;
            }
        }
        if(k >= len){
            return '.';
        }


        for(int i=s.length() - 1; i >= 0; --i){
            char c = s.charAt(i);

            if(Character.isLowerCase(c)){
                if(k == len-1){
                    return c;
                }
                len--;
            }
            else if(c == '*'){
                len++;
            }
            else if(c == '#'){
                len /= 2;
                if(k >= len){
                    k -= len;
                }
            }
            else if(c == '%'){
                k = len - 1 - k;
            }
        }

        return '.';
    }
}