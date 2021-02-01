package edu.grcy.patterns.behavioral.templateMethod;

public class EmaliNewsProvider extends NewsProvider {
    String email;
    
    @Override
    public boolean authorize() {
        return false;
    }

    @Override
    public boolean endConnection() {
        return false;
    }
}
