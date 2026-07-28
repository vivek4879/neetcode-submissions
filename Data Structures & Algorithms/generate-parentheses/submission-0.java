class Solution {
    public void generate(int leftCount, int rightCount, StringBuilder sb, int target, int n, List<String> res){
        if(sb.length() == target){
            res.add(sb.toString());
            return;
        }
        if(leftCount < n){
            sb.append("(");
            generate(leftCount+1,rightCount,sb,target,n,res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(rightCount < leftCount){
            sb.append(")");
            generate(leftCount,rightCount+1,sb,target,n,res);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(0,0,sb, n*2,n,res);
        return res;
    }
}