class Solution {
    static int maxPlus = 0;
    static int maxPrice = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] sales = new int[emoticons.length];
        bfs(users,emoticons,sales,0);
        answer[0] = maxPlus;
        answer[1] = maxPrice;
        
        return answer;
    }
    
    
    public void bfs(int[][] users, int[] emoticons, int[] sales, int idx){
        int plus = 0;
        int price = 0;
        for(int[] u : users){
            int sum = 0;
            for(int i=0;i<emoticons.length;i++){
                if(sales[i]>=u[0]){
                    sum+=emoticons[i]*(100-sales[i])/100;
                }
            }
            if(sum>=u[1]) plus++;
            else price+=sum;
        }
        
        if(maxPlus<plus){
            maxPlus = plus;
            maxPrice = price;
        }
        else if(maxPlus==plus) {
            maxPrice = Math.max(maxPrice,price);
        }
        
        if(idx>=sales.length) return;
        for(int i=10;i<=40;i+=10){
            int[] salesClone = sales.clone();
            salesClone[idx]+=i;
            bfs(users,emoticons,salesClone,idx+1);
        }
    }
}