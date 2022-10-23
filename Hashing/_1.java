package Hashing;

/**
  It is mainly used to implement dictionary where you have <key,value> pairs
          and also       "       set where you have a set of keys


 * not used for  -> finding the closest value     (in 1st 2  we use AVL or Red-Black Tree)
                 -> sorted data

                 -> prefix searching     ( Trie - provide quick prefix search)

 * Hash Table (Hashing Technique) is one of the most used Data structure after Array in Computer science

 * Application
    - dictionary
    - database indexing
    - cryptography
    - caches : url becomes key and data becomes value to store our browser
    - symbol table : compiler & interpreter (C sends I to find out is it valid var)
    - router :
    - getting data from databases
 */


// [NOTE] DirectAddressTable : it cannot handle large value
                            // does not handle Floating point numbers, String so that we use Hashing technique

class DirectAddressTable {
    boolean[] table = new boolean[1000];

    int search(int key) {
        return (table[key] == true) ? 1 : 0;
    }
    void insert(int key) {
        table[key] = true;
    }
    void delete(int key) {
        table[key] = false;
    }


    public static void main(String[] args) {
        DirectAddressTable ht = new DirectAddressTable();
        ht.insert(124);
        ht.insert(20);
        ht.insert(50);
        System.out.println(ht.search(124));

        System.out.println((char)('a' - 'A')+" "+('a' - 'A'));
        System.out.println((char)('c' - 'A')+" "+('c' - 'A'));
    }
}
