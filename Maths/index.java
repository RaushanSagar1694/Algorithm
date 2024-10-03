
package Maths;
class Math{


// calculate negative remender  (a + b) % p = (a % p + b % p) % p;
// int currSum = (currSum - target + p) % p;


// factorial
public static int factorial(int num){
    int result = 1;
    for(int i = 2; i < num; i++){
        result *= i;
    }

    return result;
}


//count digit
public static int countDigit(int num){
    int count = 0;

    while(num != 0){
        num = num/10;
        count++;
    }

    return count;
}


// palindrome number O(n)
public static boolean palindrome(int num){
    int newNum = 0;

    while(num > 0){
        int digit = num%10;
        newNum = newNum * 10 + digit;

        num = num/10;
    }


    return newNum == num;
}


//Trailing Zero in Factorial 0(long n)
public static int countTrailingZero(int n){
    int res = 0;

    for(int i = 5; i < n; i = i*5){
        res = res + n/i;
    }

    return res;
}


// GCD Euclidean Algorithm 
public static int gcd(int a, int b){

    while(a != b){
        if(a > b){
            a = a - b;
        }
        else{
            b = b - a;
        }
    }

    return a;
}


//LCM  
public static int lcm(int a, int b){
    return (a*b) / gcd(a, b);
}




public static void main(String[] args) {
        int result = lcm(12, 4);
        System.out.println(result);
    }
} 