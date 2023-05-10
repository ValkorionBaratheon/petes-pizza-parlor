package Command;

public class Invoker {
    Command comm;
    
    public Invoker(Command c) {
        comm = c;
    }

    public void doCommand() {
        comm.execute();
    }
}
