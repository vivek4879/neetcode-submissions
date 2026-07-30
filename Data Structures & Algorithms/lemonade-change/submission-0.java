class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int returnAmount = 0;
        
        for(int bill:bills){
            returnAmount = bill - 5;
            if(returnAmount == 5){
                if(five >0){
                    five --;
                }
                else{
                    return false;
                }
            }
            else if(returnAmount == 15){
                if(ten > 0 && five >0){
                    ten--;
                    five--;
                }
                else if(five <3)return false;
                else{
                    five-=3;
                }
            }
            if(bill == 5){
                five++;
            }
            else if(bill == 10){
                ten++;
            }
        }
        return true;
    }
}