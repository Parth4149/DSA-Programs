public class _15__findMajority {
/*
    // Basic approach
    public static int findMajority(int[] arr){ // TC : O(n^2)
        for(int i = 0; i <= arr.length / 2; i++){
            int count = 1;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > arr.length / 2){
                return i;
            }
        }
        return -1;

    }

    // Hash Table
    public static int findMajority(int[] arr){ // TC : O(n) , SC : O(n)
        HashMap<Integer,Integer> m = new HashMap<>();
                // here value indicate how many times the key appear in the array
        for(int i = 0; i < arr.length; i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i], 0);
            }
            m.put(arr[i], m.get(arr[i]) + 1);
        }

        for(int i = 0; i < arr.length; i++){
            if(m.get(arr[i]) > (arr.length / 2)){
                return i;
            }
        }
        return -1;
    }

    // Sorting
    public static int findMajority(int[] arr){ // TC : insertion sort
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++){
            int count = 1;
            if(arr[i - 1] == arr[i]){
                while(i < arr.length && arr[i - 1] == arr[i]){
                    i++;
                    count++;
                }
                if(count > arr.length / 2){
                    return (i - 1); // we need to return any index of majority element , count should be more than n/2
                }
            }
        }
        return -1;
    }
*/

    // Moris motion algorithm
    // find majority element which is appeared more than n/2 times and return any index of majority element

    // here we increment count if duplicate ele comes. otherwise decrement count
    //e.g. size of array is 9 if eny x element appear 5 times, count inc 5 time and dec 4 time ,after finishing loop count >= 2 not 0
    public static int findMajority(int[] arr) { // TC : O(n) , [Moris motion algorithm]
        int res = 0, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        // check if the candidate is actually a majority
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[res] == arr[i]) {
                count++;
            }
        }
        if (count > arr.length / 2) {
            return res;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {8,3,4,8,8}; // any index of 8
//        int[] arr = {3,7,4,7,7,5}; // no majority
        int[] arr = {50, 30, 40, 50, 5, 50, 50}; // any index of 50
//        int[] arr = {2,5,5,7,10,5,5,7,5}; // any index of 5
//        int ans = findMajority(arr);
        int ans = findMajority(arr);
        System.out.println(ans);
    }
}
