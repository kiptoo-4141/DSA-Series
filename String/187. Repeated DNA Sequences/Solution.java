class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedSeq = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        frdsHelper(s, repeatedSeq, map, 0);
        return repeatedSeq;
    }

    private void frdsHelper(String s, List<String> repeatedSeq, Map<String, Integer> map,     
    int start){
        if(s.length() - start < 10){
            return; 
        }

        String sub = s.substring(start, start + 10);

        map.put(sub, map.getOrDefault(sub,0) + 1);

        if(map.get(sub) == 2){
            repeatedSeq.add(sub);
        }

        frdsHelper(s,repeatedSeq, map, start + 1);
    }
}
