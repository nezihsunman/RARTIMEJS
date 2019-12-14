package main.java.FactoryMethod;

public abstract class JobFactory {
    public void getJob(String type){
        AbstractJob J = createJob(type);
    }

    protected abstract AbstractJob createJob(String type);
}

