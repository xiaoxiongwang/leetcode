/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */
class Solution {
    public boolean isPalindrome(int x) {
        int y=0,z=x;
        if(x<0) return false;

        while(z>0){
            y = y*10 + z%10;
            z = z/10;
        }
        return y==x;



        // int z = x;
        // if(x<0)
        //     return false;
        // int length =0;
        // while(x!=0){
        //     x/=10;
        //     length++;
        // }
        // int high = 1;
        // for(int i=0;i<length-1;i++)
        // {
        //     high *= 10;
        // }
        // int low = 10;
        // int y =z;
        // x = z;
        // int count=0;
        // while(true)
        // // while((x/high==y%low)&&(count<length/2))
        // {
        //     if(x/high!=y%low) return false;
        //     else if(count>=length/2) return true;
        //     else{
        //         count++;
        //         // high = high/10;
        //         // low = low*10;
        //         y = y/10;
        //         x = x-high*(x/high);
        //         high = high/10;
        //     }
            
        // }
    }
}

