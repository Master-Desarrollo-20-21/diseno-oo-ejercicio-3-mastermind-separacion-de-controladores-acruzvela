package cruz.views.graphic;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import cruz.views.Message;

@SuppressWarnings("serial")
public class SecretCombinationView extends JPanel{
    public SecretCombinationView(String messageSecretCombination){
        this.setLayout(new GridBagLayout());
        this.add(new JLabel(Message.SECRET_COMBINATION.getMessage()), new Constraints(0, 0, 3, 1));
        this.add(new JLabel(messageSecretCombination), new Constraints(0, 1, 3, 1));
    }
}
