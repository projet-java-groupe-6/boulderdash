package model;

import contract.IScore;

public class Score implements IScore {
    
    private int nbrDiamonds;
  
    	public Score (){
    		this.nbrDiamonds=0;
    	}

	
    	public int getNbrDiamonds(){
    		return nbrDiamonds;
    	}

    	public void setScore (int score) {
    		this.nbrDiamonds=score;
    	}


		@Override
		public int getScore() {	
			return this.nbrDiamonds;
		}
    	
}
