package main.java.FactoryMethod;

//public abstract class AbstractJob implements Comparable<AbstractJob>{
public abstract class AbstractJob extends Thread implements Comparable<AbstractJob> {

    public abstract boolean getStatus();
    public abstract void setStatus(boolean status);
    public abstract int getSize();

    @Override
    //pop lowest priority first
    public int compareTo(AbstractJob j) {
        if (this.getSize() > j.getSize()) {
            return 1;
        } else if (this.getSize() < j.getSize()) {
            return -1;
        }

        return 0;
    }

}
