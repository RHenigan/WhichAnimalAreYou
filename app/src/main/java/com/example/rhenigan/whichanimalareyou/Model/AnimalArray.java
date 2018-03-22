package com.example.rhenigan.whichanimalareyou.Model;

import com.example.rhenigan.whichanimalareyou.R;

import java.util.ArrayList;

/**
 * Created by henig on 3/19/2018.
 * ------------------------------
 */

public class AnimalArray{

    public ArrayList<Animal> animalArray = new ArrayList<>();

    public AnimalArray() {
        Animal dolphin = new Animal("Dolphin", new int[] {-5, -10, 10, -10, 0, 5, -10, 10}, R.drawable.dolphin);
        animalArray.add(dolphin);
        Animal elephant = new Animal("Elephant", new int[] {10, -5, 0, -10, -10, 0, -10, 10}, R.drawable.elephant);
        animalArray.add(elephant);
        Animal flamingo = new Animal("Flamingo", new int[] {-10, 10, 5, -5, -5, 10, 10, -5}, R.drawable.flamingo);
        animalArray.add(flamingo);
        Animal giraffe = new Animal("Giraffe", new int[] {10, 10, 0, -10, -10, 5, 5, 0}, R.drawable.giraffe);
        animalArray.add(giraffe);
        Animal jellyfish = new Animal("Jellyfish", new int[] {-10, -10, 10, -10, 0, 10, 10, -10}, R.drawable.jellyfish);
        animalArray.add(jellyfish);
        Animal monkey = new Animal("Monkey", new int[] {0, 0, 0, 10, 10, 5, 5, 10}, R.drawable.monkey);
        animalArray.add(monkey);
        Animal redpanda = new Animal("Red Panda", new int[] {-10, -5, 0, 10, 5, 5, 5, 10}, R.drawable.redpanda);
        animalArray.add(redpanda);
        Animal snake = new Animal("Snake", new int[] {-10, -10, 5, 5, 10, -10, 10, -10}, R.drawable.snake);
        animalArray.add(snake);
        Animal tiger = new Animal("Tiger", new int[] {5, 0, -10, 5, 10, 0, 10, 10}, R.drawable.tiger);
        animalArray.add(tiger);
        Animal wolf = new Animal("Wolf", new int[] {5, 0, 0, -5, 5, 10, -10, -10}, R.drawable.wolf);
        animalArray.add(wolf);
    }
}
