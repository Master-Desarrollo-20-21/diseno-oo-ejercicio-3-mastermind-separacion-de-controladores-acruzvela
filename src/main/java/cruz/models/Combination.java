package cruz.models;

import cruz.types.Color;

public abstract class Combination {
	protected final int LENGTH = 4;
	protected Color[] colors;

	protected Combination() {
		this.colors = new Color[LENGTH];
	}

	@Override
	public String toString() {
		String textColors = "";

		for (Color color : this.colors) {
			textColors = textColors.concat(color.toString());
		}
		return textColors;
	}

	public void createCombination(String combinationString){
        for (int i=0;i<LENGTH;i++) {
			this.colors[i]=Color.getColorByChar(combinationString.charAt(i));
		}
	}
	
	public int getWidth(){
		return this.LENGTH;
	}
}
