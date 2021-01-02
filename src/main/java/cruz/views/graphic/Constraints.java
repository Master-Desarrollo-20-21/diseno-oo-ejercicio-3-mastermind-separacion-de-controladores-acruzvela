package cruz.views.graphic;

import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class Constraints extends GridBagConstraints{
    public Constraints(int gridX, int gridY, int gridWidth, int gridHeight) {
		this.gridx = gridX;
		this.gridy = gridY;
		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;
		this.fill = GridBagConstraints.BOTH;
	}
}
