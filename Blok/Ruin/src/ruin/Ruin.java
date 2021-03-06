package ruin;

import interfaces.*;

public class Ruin extends IPlugin implements IUIFactory{
    
    private IBackground background ;
    private IGround ground ;
    private IBlocks block ;
    private IPlayer player ;
    
    public Ruin(){
        this.background = new Background();
        this.block = new Blocks();
        this.ground =  new Ground();
        this.player = new Player();
    }
    
    @Override
    public IBackground createBackground() {
        return this.background;
    }

    @Override
    public IGround createGround() {
        return this.ground;
    }

    @Override
    public IBlocks createBlocks() {
        return this.block;
    }
    
    @Override
    public IPlayer createPlayer() {
        return this.player;   
    }
}
