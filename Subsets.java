class Main {
    // Print all subsets of given set[]
    static void printSubsets(int set[]) {
        int n = set.length; // Gets the length of the input array, representing the number of elements in the set

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        // Example set of integers
        int set[] = {1, 2, 3};

        // Print all subsets of the set
        printSubsets(set);
    }
}