package model;

import contract.IScore;

public class Score implements IScore {
    
    private final int NBR_TOTAL_DIAMONDS = 12;
    private int nbrDiamonds;
  
    	public Score (){
    		this.nbrDiamonds=0;
    	}

	
    	public int getNbrDiamonds(){
    		return nbrDiamonds;
    	}
    	public int getNbrTotalDiamonds(){
    		return NBR_TOTAL_DIAMONDS;
    	}
    	public void setScore (int score) {
    		this.nbrDiamonds=score;
    	}


		@Override
		public int getScore() {	
			return this.nbrDiamonds;
		}
    	
}
