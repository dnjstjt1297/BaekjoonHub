class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0;i<balls.length;i++){
            int endX = balls[i][0];
            int endY = balls[i][1];
            
            //각 모서리 좌표
            double leftX = (double)(endY*startX+startY*endX)/(endY+startY);
            double rightX = (double)((n-endY)*startX+(n-startY)*endX)/((n-endY)+(n-startY));
            double upY = (double)(endY*startX+startY*endX)/(endX+startX);
            double downY = (double)(endY*(m-startX)+startY*(m-endX))/((m-endX)+(m-startX));
            
            
            //거리
            double left = Math.pow(Math.sqrt((startX-leftX)*(startX-leftX)+startY*startY)+
                Math.sqrt((endX-leftX)*(endX-leftX)+endY*endY),2);
            
            double right = Math.pow(Math.sqrt((startX-rightX)*(startX-rightX)+(n-startY)*(n-startY))+
                Math.sqrt((endX-rightX)*(endX-rightX)+(n-endY)*(n-endY)),2);
            
            double up = Math.pow(Math.sqrt((startY-upY)*(startY-upY)+startX*startX)+
                Math.sqrt((endY-upY)*(endY-upY)+endX*endX),2);
            
            double down = Math.pow(Math.sqrt((startY-downY)*(startY-downY)+(m-startX)*(m-startX))+
                Math.sqrt((endY-downY)*(endY-downY)+(m-endX)*(m-endX)),2);
            
            if(startX == endX){
                if(startY>endY) left = Integer.MAX_VALUE;
                else right = Integer.MAX_VALUE;
            }
            if(startY == endY){
                if(startX>endX) up = Integer.MAX_VALUE;
                else down = Integer.MAX_VALUE;
            }
            double min = Math.min(left,right);
            min = Math.min(min,up);
            min = Math.min(min,down);
            
            double tmp = (int)min;
            tmp+=0.5;
            if(tmp<=min){
                min = tmp+1;
            }
            else min = (int)min;
            
            answer[i] = (int)min;
        }
        
        
        return answer;
    }
}