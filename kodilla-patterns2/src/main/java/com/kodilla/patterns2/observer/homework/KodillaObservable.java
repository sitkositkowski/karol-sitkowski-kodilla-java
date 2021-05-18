package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observer;

public interface KodillaObservable {
    void registerObserver(KodillaObserver observer);

    void notifyObservers();

    void removeObserver(KodillaObserver observer);
}