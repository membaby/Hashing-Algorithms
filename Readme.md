# Perfect Hashing Data Structure

This project is a programming assignment where you will be implementing a perfect hashing data structure. A hash function is considered perfect for a set S if all lookups require O(1) operations. The project includes designing, analyzing, and implementing a perfect hash table using two methods described in sections 3 and 4.

## Background - Universal Hashing
A hash function probability distribution H over hash functions from U to {1, ..., M} is considered universal if the probability that h(x) equals h(y) for any x=y in U is less than or equal to 1/M. This is stated as:
```
P r[h(x) = h(y)] ≤ 1/M (1)
```
If H is universal, then for any set S ⊂ U, for any x ∈ U (that we might want to insert or lookup), for a random h taken from H, the expected number of collisions between x and other elements in S is at most N/M.

## Constructing a Universal Hash Family: The Matrix Method
The keys are u-bits long, and the table size M is a power of 2. An index is b-bits long, where M = 2^b. A random b-by-u 0/1 matrix h is picked, and h(x) = hx, where addition is done mod 2. 

## O(N^2) - Space Solution
If we are willing to have a table size quadratic in the size N of our dictionary S, we can use this method. Let H be universal and M = N^2. A random h is selected from H, and everything in S is hashed using h. If collisions occur, a new h is tried. Typically, this only needs to be done twice on average.

## O(N) - Space Solution
The idea is to use universal hash functions in a 2-level scheme. The first level uses a hash function h and table A of size N. The second level uses N hash functions h1, ..., hN and N tables A1, ..., AN. To look up an element x, we first compute i = h(x) and then find the element in Ai[hi(x)]. This method is used to rehash each bin using Method 1, squaring the size of the bin to get zero collisions.

## Conclusion
This project involves designing, analyzing, and implementing a perfect hashing data structure using the two methods described above. You will need to implement the methods and evaluate their performance on different sets of keys.
