class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> capitalizationMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);
            
            String lowerCase = word.toLowerCase();
            capitalizationMap.putIfAbsent(lowerCase, word);
            
            String devoweled = lowerCase.replaceAll("[aeiou]", "*");;
            vowelMap.putIfAbsent(devoweled, word);
        }
        

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }

            String lower = query.toLowerCase();
            if (capitalizationMap.containsKey(lower)) {
                result[i] = capitalizationMap.get(lower);
                continue;
            }

            String devoweled = lower.replaceAll("[aeiou]", "*");
            if (vowelMap.containsKey(devoweled)) {
                result[i] = vowelMap.get(devoweled);
                continue;
            }
            

            result[i] = "";
        }
        
        return result;
    }
}