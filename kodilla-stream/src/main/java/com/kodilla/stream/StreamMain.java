package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        /*
        System.out.println("Welcome to module 7 - Stream");

        System.out.println("SaySomething");
        System.out.println("1st method");
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        System.out.println("2nd method");
        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        System.out.println("3rd method");
        Processor processor2 = new Processor();                                  // [6]
        Executor codeToExecute = () -> System.out.println("This is an example text.");  // [7]
        processor2.execute(codeToExecute);

        System.out.println("Math Execute");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
        */

        /*
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("uglyText", (text) -> "ABC" + text);
        poemBeautifier.beautify("uglyText", String::toUpperCase);
        poemBeautifier.beautify("uglyText", (text) -> text.replaceFirst("ugly","beautiful"));
        poemBeautifier.beautify("uglyText", (text) -> {
            char[] textChat = text.toUpperCase().toCharArray();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i<text.length(); i++){
                result.append("*").append(textChat[i]);
            }
            return result.toString() + "*";
        });

        */

        /*System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);*/

        /*People.getList().stream()                         // [1]
                .forEach(System.out::println);

        People.getList().stream()
                .map(s -> s.toUpperCase())                      // [1]
                .forEach(System.out::println);

        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);

        People.getList().stream()
                .map(String::toUpperCase)                             // [1]
                .filter(s -> s.length() > 11)                         // [2]
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")   // [3]
                .filter(s -> s.substring(0, 1).equals("M"))           // [4]
                .forEach(System.out::println);*/

        /*BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()   // [1]
                .filter(book -> book.getYearOfPublication() > 2005)                  // [2]
                .collect(Collectors.toList());                                       // [3]

        System.out.println("# elements: " + theResultListOfBooks.size());       // [4]
        theResultListOfBooks.stream()                                           // [5]
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));             // [1]

        System.out.println("# elements: " + theResultMapOfBooks.size());             // [2]
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
                .forEach(System.out::println);

        theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

        System.out.println(theResultStringOfBooks);*/

        Forum theForum = new Forum();

        Map<Integer, ForumUser> theResultMapOfUsers = theForum.getList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getBirthDate().plusYears(20L).isBefore(LocalDate.now()))
                .filter(forumUser -> forumUser.getNumberOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        System.out.println("# elements: " + theResultMapOfUsers.size());
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
