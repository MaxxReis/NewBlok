package city;

import interfaces.IGround;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ground implements IGround{
    
    @Override
    public Image loadGround() {
        return new ImageIcon(this.getClass().getResource("resources/ground2.png")).getImage();
    }
}
