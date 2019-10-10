package com.mvnikitin.lesson5;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "{w:" + weight + ", v:" + value + '}';
    }
}

class Link<T> {
    private Link<T> prev;
    private T pointer;

    public Link() {
        prev = null;
        pointer = null;
    }

    public Link(Link<T> prev, T val) {
        this.prev = prev;
        pointer = val;
    }

    public void link(Link<T> other) {
        prev = other;
    }

    public Link<T> previous() {
        return prev;
    }

    public T getVal() {
        return pointer;
    }

    public void setVal(T val) {
        pointer = val;
    }
}

public class Backpack {

    private List<Thing> content;
    private int maxWeight;
    private int value;
    private int weight;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
        content = new ArrayList<>();
    }

    public static void main(String[] args) {

        Backpack backpack = new Backpack(14);

        Thing[] stuff = new Thing[4];
        stuff[0] = new Thing(5, 3);
        stuff[1] = new Thing(10, 5);
        stuff[2] = new Thing(6, 4);
        stuff[3] = new Thing(5, 2);

        backpack.fill(stuff);
        System.out.println(backpack);
    }

    public void fill(Thing[] stuff) {
        //value = populate(stuff, 0, 0);
        populate(stuff, 0, 0, 0, new Link<>(null, null));
    }

    @Override
    public String toString() {
        return "Value:" + value + ", Weight: " + weight +
                ", Content: " + content;
    }

    /**
     * Receives an array of things, evaluates and fills the backpack
     * to maximize the overall value.
     * @param stuff - an array of things to put into the backpack.
     * @param thingNumber - the index of the next thing to check and store.
     * @accumulatedWeight -
     * @accumulatedValue -
     * @trace -
     * @return current accumulated vaule of the backpack.
     */
    private void populate(Thing[] stuff, int thingNumber,
                              int accumulatedWeight, int accumulatedValue,
                              Link<Thing> trace) {
        // Check the weight limit conditions
        if(accumulatedWeight > maxWeight) {
            return;
        }

        // take the next thing
        if (thingNumber < stuff.length) {
            // Compare the things value with the currently stored value
            if(thingNumber > 0 && accumulatedValue >= value) {
                changeContent(trace);
            }

            //Option 1: do not deposit the current thing
            populate(stuff, thingNumber + 1, accumulatedWeight,
                    accumulatedValue, new Link<>(trace, null));

            //Option 2: deposit the current thing
            populate(stuff, thingNumber + 1,
                    accumulatedWeight + stuff[thingNumber].getWeight(),
                    accumulatedValue + stuff[thingNumber].getValue(),
                    new Link<>(trace, stuff[thingNumber]));
        }
    }

    private void changeContent(Link<Thing> trace) {
        content.clear();
        weight = 0;
        value = 0;

        Link<Thing> item = trace;
        while (item != null) {
            if(item.getVal() != null) {
                content.add(item.getVal());
                weight += item.getVal().getWeight();
                value += item.getVal().getValue();
            }
            item = item.previous();
        }
    }
}

// Результат:
// Value:7, Weight: 11, Content: [{w:6, v:4}, {w:5, v:3}]