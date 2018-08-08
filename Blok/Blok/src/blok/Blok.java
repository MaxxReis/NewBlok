package blok;

import interfaces.ICore;

public class Blok {

    public static void main(String[] args) {
        ICore core = Core.getInstance();
        core.initialize();
    }
}
