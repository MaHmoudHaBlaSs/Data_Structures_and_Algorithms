///   https://leetcode.com/problems/online-stock-span/

//Store the answers to avoid o(n^2) 
//If the last price is <= the current price then the last answer will be added to the current answer

class StockSpanner {
    private List<Integer> prices; 
    private List<Integer> answers; 
    
    public StockSpanner() {
        prices = new ArrayList<>(); 
        answers = new ArrayList<>(); 
    }
    
    public int next(int price) {
        int c = 1; 
        int i = prices.size() - 1; 
        
        while(i >= 0 && prices.get(i) <= price) {
            c += answers.get(i);
            i -= answers.get(i); 
        }       

        prices.add(price); 
        answers.add(c);
        return c; 
    }
}