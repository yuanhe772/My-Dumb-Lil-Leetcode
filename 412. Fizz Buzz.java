/**

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

*/


class Solution {
    // // 法一： ✅ 用了求余数的操作，CPU效率极低      99.87%
    // public List<String> fizzBuzz(int n) {
    //     List<String> res = new ArrayList<>();
    //     for(int i=0; i<n; i++){
    //         if((i+1)%3==0 && (i+1)%5!=0) res.add("Fizz");
    //         else if((i+1)%3!=0 && (i+1)%5==0) res.add("Buzz");
    //         else if((i+1)%3==0 && (i+1)%5==0) res.add("FizzBuzz");
    //         else res.add(Integer.toString(i+1));
    //     }
    //     return res;
    // }
    
    // 法二：✅ 不用求余的操作         99.87%
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int buzz = 0; int fizz = 0; 
        for(int i=0; i<n; i++){
            buzz ++;
            fizz ++;
            // fb ++;
            
            if(fizz == 3 && buzz == 5){
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }
            else if(fizz==3) {
                res.add("Fizz");
                fizz = 0;
            }
            else if(buzz==5) {
                res.add("Buzz");
                buzz = 0;
            }
            else res.add(Integer.toString(i+1));
        }
        return res;
    }
}
