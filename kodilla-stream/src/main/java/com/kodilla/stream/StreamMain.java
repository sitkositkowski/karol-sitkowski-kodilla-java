package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

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

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
