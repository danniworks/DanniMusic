package service.observer;

import service.subject.AbstractSubject;

public abstract class AbstractObserver {
    protected AbstractSubject subject;
    public abstract void update();
}

