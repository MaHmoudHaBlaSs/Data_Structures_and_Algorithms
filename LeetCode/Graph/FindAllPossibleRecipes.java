///     https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/


class Solution {
    private List<String> res;
    private HashMap<String,List<String>> adj; 
    final int UNSEEN = 0, PASSED = 1, SUCCESS = 2, FAILED= 3;
    private HashMap<String, Integer> state;

    private boolean dfs(String cur) {
        if(state.get(cur) == FAILED) return false;
        if(state.get(cur) == SUCCESS) return true;

        state.put(cur, PASSED);
        
        for(String next : adj.get(cur)){
            if(!state.containsKey(next) || state.get(next) == PASSED || !dfs(next)) {
                state.put(cur, FAILED);
                return false;
            }
        }
        
        state.put(cur, SUCCESS);
        return true;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        res = new ArrayList<>(); 
        adj = new HashMap<>();
        state = new HashMap<>();
        
        int n = recipes.length;
        for(int i=0; i<n; i++) {           
            adj.put(recipes[i], ingredients.get(i));
            state.put(recipes[i], UNSEEN);
        }
        
        for(String s : supplies)
            state.put(s, SUCCESS);
        
        
        for(String recipe : recipes){
            if(state.get(recipe) == UNSEEN) 
                dfs(recipe);

            if(state.get(recipe) == SUCCESS) 
                res.add(recipe);
        }

        return res; 
    }

}