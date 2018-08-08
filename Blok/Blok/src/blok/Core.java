package blok;

import interfaces.ICore;
import interfaces.IGameController;
import interfaces.IPluginController;
import interfaces.IUIController;

public class Core implements ICore {
 
    private static Core instance;
    
    private IUIController uiController;
    private IGameController gameController;
    private IPluginController pluginController;
    
    public static Core getInstance(){
        if(instance == null)
            instance = new Core();
        return instance;
    }
    
    private Core(){
        pluginController = new PluginController(this);
        uiController = new UIController(this);
        gameController = new GameController(this);
    }
    
    @Override
    public boolean initialize() {
        boolean run = pluginController.initialize() &&
                    uiController.initialize() &&
                    gameController.initialize();
        
        return run;
    }

    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IGameController getGameController() {
        return gameController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
}
