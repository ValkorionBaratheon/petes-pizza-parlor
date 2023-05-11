package Command;

public class Invoker {
    private Command comm;
    
    public Invoker(Command c) {
        comm = c;
    }

    public void doCommand() {
        comm.execute();
    }
}
