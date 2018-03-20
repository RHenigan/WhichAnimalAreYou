package com.example.rhenigan.whichanimalareyou;

import java.util.ArrayList;

/**
 * Created by henig on 3/19/2018.
 * ------------------------------
 */

public class AnimalArray {

    public ArrayList<Animal> animalArray = new ArrayList<>();

    public AnimalArray() {
        Animal dolphin = new Animal("Dolphin");
        animalArray.add(dolphin);
        Animal elephant = new Animal("Elephant");
        animalArray.add(elephant);
        Animal flamingo = new Animal("Flamingo");
        animalArray.add(flamingo);
        Animal giraffe = new Animal("Giraffe");
        animalArray.add(giraffe);
        Animal jellyfish = new Animal("Jellyfish");
        animalArray.add(jellyfish);
        Animal monkey = new Animal("Monkey");
        animalArray.add(monkey);
        Animal redpanda = new Animal("Red Panda");
        animalArray.add(redpanda);
        Animal snake = new Animal("Snake");
        animalArray.add(snake);
        Animal tiger = new Animal("Tiger");
        animalArray.add(tiger);
        Animal wolf = new Animal("Wolf");
        animalArray.add(wolf);
    }
}
