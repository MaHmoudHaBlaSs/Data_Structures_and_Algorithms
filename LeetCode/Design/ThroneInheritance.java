/// https://leetcode.com/problems/throne-inheritance/description/


class ThroneInheritance {
    private HashMap<String, ArrayList<String>> mp = new HashMap<>();
    private HashSet<String> dead = new HashSet<>();
    private String king; 
    public ThroneInheritance(String kingName) {
        king = kingName;
    }
    
    public void birth(String parentName, String childName) {
        if(!mp.containsKey(parentName)) mp.put(parentName, new ArrayList<>()); 

        mp.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);     
    }
    
    public List<String> getInheritanceOrder() {
        ArrayList<String> ans = new ArrayList<>();
        successor(king, ans); 
        return ans;
    }

    private void successor(String name, List<String> order){
        if(!dead.contains(name)) order.add(name); 

        if(mp.containsKey(name)){
            for(String child : mp.get(name)) 
                successor(child, order); 
        }
    }
}
