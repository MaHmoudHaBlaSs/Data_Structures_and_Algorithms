///   https://leetcode.com/problems/reward-top-k-students/description/

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> pstv = new HashSet<>(), ngtv = new HashSet<>();

        for(String word : positive_feedback){
            pstv.add(word);
        }
        for(String word : negative_feedback){
            ngtv.add(word);
        }

        HashMap<Integer, Integer> scores = new HashMap<>();

        for(int i=0; i<report.length; ++i){
            String[] words = report[i].split(" ");
            int score = 0;

            for(String word : words){
                if(pstv.contains(word)) score += 3;
                else if(ngtv.contains(word)) score -= 1;
            }

            scores.put(student_id[i], score);
        }

        List<Integer> ids = new ArrayList<>(scores.keySet());
        Collections.sort(ids, (a,b) ->{
            int s1 = scores.get(a), s2 = scores.get(b);

            if(s1 != s2){
                return s2-s1;
            }

            return a-b;
        });

        ArrayList<Integer> ans = new ArrayList<>(k);
        for(int i=0; i<k; ++i){
            ans.add(ids.get(i));
        }

        return ans;
    }
}