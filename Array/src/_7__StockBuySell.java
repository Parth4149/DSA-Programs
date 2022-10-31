public class _7__StockBuySell {
    public static int maxProfit(int[] price) {  // time : theta(n)
        int profit = 0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                profit += (price[i] - price[i - 1]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
//        int[] arr={1,5,3,8,12};//13
//        int[] arr={30,20,10};//0
//        int[] arr={10,20,30};//20
//        int[] arr={1,5,3,1,2,8};//11
        System.out.println(maxProfit(arr));//7
    }
}
