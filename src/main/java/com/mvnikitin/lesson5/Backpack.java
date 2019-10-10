package com.mvnikitin.lesson5;

class Thing {
    private int weight;
    private int value;

    public Thing(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}

public class BackpackProblem {

    private Thing[] stuff;
    private int maxTotalWeight;

    public BackpackProblem(Thing[] stuff, int weight) {
        this.stuff = stuff;
        this.maxTotalWeight = weight;
    }

    public static void main(String[] args) {

        Thing[] setOfThings = new Thing[4];
        setOfThings[0] = new Thing(5, 3);
        setOfThings[0] = new Thing(10, 5);
        setOfThings[0] = new Thing(6, 4);
        setOfThings[0] = new Thing(2, 2);


    }
}
