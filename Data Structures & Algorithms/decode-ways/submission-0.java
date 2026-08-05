class Solution {
    public int numDecodings(String s) {

        if(s.length() ==1){
            if(s.charAt(0) == '0')return 0;
            return 1;
        }
        int[] dp = new int[s.length()];
        if(s.charAt(0)== '0'){
            dp[0]= 0;
            dp[1]= 0;
        }
        else if(s.charAt(1)== '0'){
            if(Integer.parseInt(s.substring(0,1)) <3){
                dp[0]= 1;
                dp[1] = 1;
            }  
        }
        else{
            dp[0] = 1;
            if(Integer.parseInt(s.substring(0,2)) <27){
                dp[1] = 2;
            }
            else{
                dp[1] = 1;
            }
            
        }

        for(int i = 2; i <dp.length;i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '0'){
                    dp[i] = 0;
                }
                else if(Integer.parseInt(s.substring(i-1,i)) > 2){
                    dp[i] = 0;
                }
                else{
                    dp[i] = dp[i-2];
                }
              
            }
            else if(s.charAt(i-1) == '0'){
                dp[i] = dp[i-1];
            }
            else if(Integer.parseInt(s.substring(i-1,i+1)) > 26){
                dp[i]= dp[i-1];
            }
            else{
                dp[i]= dp[i-1] +dp[i-2];
            }
        }

        return dp[dp.length-1];
    }
}






// f(i) = number of ways to decode the string till ith index;

// f(0) =  s(0) == 0?0:1
// f(1) =  s(0) == 0?0:2

// f(i) = if(!s(i-1,i+1)) ->f(i-1)
//         else f(i-1) +f(i-2)

//         if i-1 ==0 then f(i)=f(i-1)





