package ruin;

import interfaces.IBlocks;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Blocks implements IBlocks{
    
    @Override
    public Image loadBlocks() {
        return new ImageIcon(this.getClass().getResource("resources/brick1.png")).getImage();
    }
}
