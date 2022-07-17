class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
		return 0;
 
	// init an array to track prime numbers
	boolean[] primes = new boolean[n];
	for (int i = 2; i < n; i++)
		primes[i] = true;
 
	for (int i = 2; i <= Math.sqrt(n - 1); i++) {
	// or for (int i = 2; i <= n-1; i++) {
		if (primes[i]) {
			for (int j = i + i; j < n; j += i)
				primes[j] = false;
		}
	}
 
	int count = 0;
	for (int i = 2; i < n; i++) {
		if (primes[i])
			count++;
	}
 
	return count;
        
//           n = n-1;
 
//     ArrayList<Integer> primes = new ArrayList<Integer>();
 
//     if(n<=1) 
//         return 0;
//     if(n==2)
//         return 1;
//     if(n==3)
//         return 2;
 
//     primes.add(2);
//     primes.add(3);
 
//     for(int i=4; i<=n; i++){
//         boolean isPrime = true;
//         for(int p: primes){
//             int m = i%p;
//             if(m==0){
//                 isPrime = false;
//                 break;
//             }
//         }
 
//         if(isPrime){
//             primes.add(i);
//         }
//     }
 
//     return primes.size();
    }
}