package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String uglyText, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(uglyText);
        System.out.println("Result equals: " + result);
    }
}
