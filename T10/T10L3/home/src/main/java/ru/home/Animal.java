package ru.home;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Animal {
    private String name;
    private String type;
    private float maxRun;
    private float maxJump;
    private float maxSwim;

    {
        maxRun = 100f;
        maxJump = 20f;
        maxSwim = 50f;
    }

    public Animal(String name, String type) {
        Random random = new Random();
        float jumpDiff = random.nextFloat() * maxJump - (maxJump / 2);
        float runDiff = random.nextFloat() * maxRun - (maxRun / 2);
        float swimDiff = random.nextFloat() * maxSwim - (maxSwim / 2);
        this.type = type;
        this.name = name;
        this.maxJump = maxJump + jumpDiff;
        this.maxRun = maxRun + runDiff;
        this.maxSwim = maxSwim + swimDiff;
    }

    boolean run(float barrier) {
        return maxRun >= barrier;
    }

    boolean jump(float barrier) {
        return maxJump >= barrier;
    }

    boolean swim(float barrier) {
        return maxSwim >= barrier;
    }
}
