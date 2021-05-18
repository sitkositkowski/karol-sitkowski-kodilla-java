package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observable;
import com.kodilla.patterns2.observer.forum.Observer;

import java.util.ArrayList;
import java.util.List;

public class HomeworksQueue implements KodillaObservable {
    private final List<KodillaObserver> observers;
    private final List<String> homeworks;
    private final String name;

    public HomeworksQueue(String name) {
        observers = new ArrayList<>();
        homeworks = new ArrayList<>();
        this.name = name;
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyObservers();
    }

    @Override
    public void registerObserver(KodillaObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (KodillaObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(KodillaObserver observer) {
        observers.remove(observer);
    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public String getName() {
        return name;
    }
}
