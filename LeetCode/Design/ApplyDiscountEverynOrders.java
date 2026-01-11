///https://leetcode.com/problems/apply-discount-every-n-orders/description/

class Cashier {
    private short[] mp =  new short[201];
    private int n, dis, count = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n; this.dis = discount;

        for(int i=0; i<products.length; ++i){
            mp[products[i]]=(short)prices[i];
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        ++count;
        double bill = 0;

        for(int i=0; i<product.length; ++i){
            bill += mp[product[i]] * amount[i];
        }

        if(count % n == 0) 
            bill -= bill * (dis/100.d); 
        return bill; 
    }
}