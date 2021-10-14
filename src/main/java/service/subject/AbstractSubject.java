package service.subject;

import entity.MusicState;
import service.observer.AbstractObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubject {
    private List<AbstractObserver> observers = new ArrayList<AbstractObserver>();
    private MusicState state;

    public MusicState getState() {
        return state;
    }

    public void setState(MusicState state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(AbstractObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (AbstractObserver observer: observers) {
            observer.update();
        }
    }


}
