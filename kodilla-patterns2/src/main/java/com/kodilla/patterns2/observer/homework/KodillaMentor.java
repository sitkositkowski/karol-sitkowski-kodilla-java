package com.kodilla.patterns2.observer.homework;

public class KodillaMentor implements KodillaObserver {
    private final String username;
    private int updateCount;

    public KodillaMentor(String username) {
        this.username = username;
    }

    @Override
    public void update(HomeworksQueue homeworksQueue) {
        System.out.println(username + ": New homeworks in queue " + homeworksQueue.getName() + "\n" +
                " (total: " + homeworksQueue.getHomeworks().size() + " homeworks to check)");
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
