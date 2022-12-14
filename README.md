 # HillsCiper
The Hill's cipher simple implementation for English alphabet with frequency test
## A little bit about the algorithm
The Hill's cipher is a polygraphic[^1] cipher based on linear algebra.
Cipher algoriyhm for block of T symbols:

C = KP (mod N)

And decipher algorithm for block of T symbols:

P = K^(-1) C (mod N) = K-1 K C (mod N) = P

C and P - a respectively called cipher and plain T-component vectors, N is a number of alphabet characters, K - a key that is TxT matrix. K^(-1) - inverse K matrix by modulo N. 
***In order for the matrix K to be invertible modulo N,*** it is necessary:
1. Determinant is not 0
2. Determinant has no common divisors with N

Also you can read adout algorithm on [Wiki](https://en.wikipedia.org/wiki/Hill_cipher).

[^1]: encryption is applied not to a single letter, but to a group
## How it works
