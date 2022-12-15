 # HillsCipher
A simple Hill's cipher implementation for encrypting Latin characters with an additional function of constructing frequency histograms
## A little bit about the algorithm
The Hill's cipher is a polygraphic cipher based on linear algebra.
This is the cipher algorithm for block of T symbols:

C = KP (mod N)

And decipher algorithm for block of T symbols looks like:

P = K^(-1) C (mod N) = K-1 K C (mod N) = P

C and P - a respectively called ciphertext and plaintext vectors of T components, N is a number of alphabet characters, K - a key that is matrix of TxT elements. K^(-1) - inverse by modulo N matrix K. 

***In order for the matrix K to be invertible modulo N, it is necessary:***

***1. Determinant is not 0***

***2. Determinant has no common divisors with N***

Also you can read adout the algorithm at [Wiki](https://en.wikipedia.org/wiki/Hill_cipher).

## How it works

Starting from the command shell.

```
java main -e 4 test.txt -y
```

 The first argument is an operating mode: "-e" or "-d" (encrypt, decrypt).
 
 The second argument is a key size (T).
 
 The third argument is a name of file with plaintext.
 
 The fourth argument is an operating mode that determines whether frequency histograms will be built or not: "-y" or "-n" (yes, no).
 
Next, you will need to enter the matrix K from the keyboard. If K does not have an inverse by modulo 26 (number of latin characters) matrix K^(-1) you need run program again. There are must be only latin characters in file. The result of the system operation will be recorded in a file "result.txt".

### Frequency histograms

A number symbols of ciphertext: 

![image](https://user-images.githubusercontent.com/115879518/207670420-8a09da2b-87fa-4609-92d9-533ac2f653e6.png)

A number symbols of plaintext: 

![image](https://user-images.githubusercontent.com/115879518/207670581-cb79954c-0e3e-4452-93f0-cd5944e0c475.png)
