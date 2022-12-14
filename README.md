 # HillsCiper
The simple Hill's cipher  implementation for English alphabet with building frequency histograms
## A little bit about the algorithm
The Hill's cipher is a polygraphic cipher based on linear algebra.
The cipher algoriyhm for block of T symbols:

C = KP (mod N)

And decipher algorithm for block of T symbols:

P = K^(-1) C (mod N) = K-1 K C (mod N) = P

C and P - a respectively called cipher and plain T-component vectors, N is a number of alphabet characters, K - a key that is TxT matrix. K^(-1) - inverse K matrix by modulo N. 

***In order for the matrix K to be invertible modulo N, it is necessary:***

***1. Determinant is not 0***

***2. Determinant has no common divisors with N***

Also you can read adout algorithm on [Wiki](https://en.wikipedia.org/wiki/Hill_cipher).

## How it works

Starting from the command shell.

```
java main -e 4 test.txt -y
```

 The first argument is an operating mode: "-e" or "-d" (encrypt, decrypt).
 
 The second argumet is a key size (T).
 
 The third argument is a name of file with plain text.
 
 The fourth argument is an operating mode for building histograms for frequency test: "-y" or "-n" (yes, no).
 
Next, you will need to enter the matrix K from the keyboard. If it hasn't an inverse matrix K^(-1) by modulo 26 (number of latin characters) you need run program again. There are must be only latin characters in file. The result of the system operation will be recorded in a file "result.txt".

### Frequency test

A number symbols of cipher text: 

![image](https://user-images.githubusercontent.com/115879518/207670420-8a09da2b-87fa-4609-92d9-533ac2f653e6.png)

A number symbols of plain text: 

![image](https://user-images.githubusercontent.com/115879518/207670581-cb79954c-0e3e-4452-93f0-cd5944e0c475.png)
