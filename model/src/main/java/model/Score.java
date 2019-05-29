package model;

import contract.IScore;

public class Score implements IScore {

	/**
	 * number of diamonds
	 */
	private int nbrDiamonds;

	/**
	 * The Constructor of the score
	 */
	public Score (){
    		this.nbrDiamonds=0;
    	}

	/**
	 * Method to get the Number of diamonds
	 * @return number of diamonds
	 */
	public int getNbrDiamonds(){
    		return nbrDiamonds;
    	}

	/**
	 * Method to set the score
	 * @param score
	 * 		score instance
	 */
	public void setScore (int score) {
    		this.nbrDiamonds=score;
    	}


	/**
	 * Method to get the score
	 * @return numbre of diamonds
	 */
	@Override
		public int getScore() {	
			return this.nbrDiamonds;
		}
    	
}
