package interfaces;

public interface IGameController {
    public enum State {INITIAL, RUNNING, YOUWON, YOULOST};
    public void setState(State state);
    public State getState();
    public boolean initialize();
    public IUIFactory getCurrentUIFactory();
    public void setCurrentUIFactory(IUIFactory factory);
    public ISimulator getCurrentPhysicsFactory();
    public void setCurrentPhysicsFactory(String factory);
}
