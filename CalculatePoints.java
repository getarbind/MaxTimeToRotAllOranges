import java.util.Arrays;

public class CalculatePoints {
	
	public static void main(String args[]){
		//System.out.println("Hello");
		String[] blocks= {"5","-2","4","Z","X","9","+","+"};
		int n=8;
		
		CalculatePoints cp = new CalculatePoints();
		System.out.println(cp.calPoints(blocks));
	}
	
    int calPoints(String blocks[]){
	 int size = blocks.length;
	 int[] total_score= new int[size]; 
	 int[] currscore= new int[size]; 
	 int score_size=0, curr_score = 0;
	 for (int i=0;i<size;i++){
		 
		 switch(blocks[i])
		 {
		 case "X":
		 //Double the last  score
			 if (score_size > 0){
				 currscore[curr_score] = currscore[curr_score-1]*2;
				 total_score[score_size] = (currscore[curr_score-1]*2) + total_score[score_size-1];
				 score_size++;
				 curr_score++;
			 }
			 break;
			 
		 case "Z":
		 //Remove the last  score
			 if (score_size > 0){
				 score_size--;
			 	 curr_score--;
			 }
			 break;
			 
		 case "+":
		 //Sum of last two  score
			 if (score_size > 1) {
				 currscore[curr_score] = currscore[curr_score-1] + currscore[curr_score-2];
				 total_score[score_size] = total_score[score_size-1] + currscore[curr_score-1] + currscore[curr_score-2];
				 score_size++;
				 curr_score++;
			 }
			 break;
		 
		 default:
			 //if (Character.isDigit(blocks[i].charAt(0))){
				 if (score_size == 0){
					 total_score[score_size] = Integer.parseInt(blocks[i]);
					 currscore[curr_score] = Integer.parseInt(blocks[i]);
				 }
				 else {
					 total_score[score_size] = total_score[score_size-1] + Integer.parseInt(blocks[i]);
				     currscore[curr_score] = Integer.parseInt(blocks[i]);
				 }
				 score_size++;
				 curr_score++;
			 //}
			 break;
			 
		 }
		 
		 //System.out.println(total_score[score_size--]);
	 }
	System.out.println("Current Score : "+Arrays.toString(currscore));
	System.out.println("Total Score : "+Arrays.toString(total_score));
	 return total_score[--score_size];
     }
}
