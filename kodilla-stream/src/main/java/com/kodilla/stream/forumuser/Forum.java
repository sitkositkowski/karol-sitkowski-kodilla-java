package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(1,"user1", 'M',
                LocalDate.of(1980,11,12) , 1));

        theUserList.add(new ForumUser(2,"user2", 'F',
                LocalDate.of(1980,11,12) , 1));

        theUserList.add(new ForumUser(3,"user3", 'F',
                LocalDate.of(1980,11,12) , 0));

        theUserList.add(new ForumUser(4,"user4", 'M',
                LocalDate.of(1999,11,12) , 0));

        theUserList.add(new ForumUser(5,"user5", 'M',
                LocalDate.of(2001,11,12) , 1));

        theUserList.add(new ForumUser(6,"user6", 'M',
                LocalDate.of(2005,11,12) , 8));

        theUserList.add(new ForumUser(7,"user7", 'M',
                LocalDate.of(2000,12,12) , 0));

        theUserList.add(new ForumUser(8,"user8", 'M',
                LocalDate.of(1988,11,12) , 1));

        theUserList.add(new ForumUser(9,"user9", 'M',
                LocalDate.of(1990,11,12) , 9));

        theUserList.add(new ForumUser(10,"user10", 'M',
                LocalDate.of(1950,11,12) , 1));
    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theUserList);
    }

}
