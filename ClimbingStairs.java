class ClimbingStairs {
    //
    static int fib(int n)
    {
        // Base case: if n is 0 or 1, return n
        if (n <= 1)
            return n;

        // Recursive case: fib(n) is the sum of fib(n-1) and fib(n-2)
        return fib(n - 1) + fib(n - 2);
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s) {
        // The number of ways to reach the s-th stair is the (s+1)-th Fibonacci number
        // We add 1 to s because we start counting from the ground (0) to s-th stair
        return fib(s + 1);
    }

    /* Driver program to test above function */
    public static void main(String args[])
    {
        // Set the stair number
        int s = 9;

        // Print the number of ways to reach the s-th stair
        System.out.println("Number of ways = " + countWays(s));
    }
}