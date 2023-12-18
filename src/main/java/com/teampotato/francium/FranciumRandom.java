package com.teampotato.francium;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FranciumRandom extends Random {
    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    private Random random = /* blame Java field initialization qwq */null;
    private volatile boolean seedSet;

    public void setSeed(long seed) {
        if (this.random == null) this.random = new Random();
        this.random.setSeed(seed);
        this.seedSet = true;
    }

    public void nextBytes(byte[] bytes) {
        if (this.seedSet) {
            this.random.nextBytes(bytes);
        } else {
            this.threadLocalRandom.nextBytes(bytes);
        }
    }

    public int nextInt() {
        if (this.seedSet) {
            return this.random.nextInt();
        } else {
            return this.threadLocalRandom.nextInt();
        }
    }

    public int nextInt(int bound) {
        if (this.seedSet) {
            return this.random.nextInt(bound);
        } else {
            return this.threadLocalRandom.nextInt(bound);
        }
    }

    public long nextLong() {
        if (this.seedSet) {
            return this.random.nextLong();
        } else {
            return this.threadLocalRandom.nextLong();
        }
    }

    public boolean nextBoolean() {
        if (this.seedSet) {
            return this.random.nextBoolean();
        } else {
            return this.threadLocalRandom.nextBoolean();
        }
    }

    public float nextFloat() {
        if (this.seedSet) {
            return this.random.nextFloat();
        } else {
            return this.threadLocalRandom.nextFloat();
        }
    }

    public double nextDouble() {
        if (this.seedSet) {
            return this.random.nextDouble();
        } else {
            return this.threadLocalRandom.nextDouble();
        }
    }

    public double nextGaussian() {
        if (this.seedSet) {
            return this.random.nextGaussian();
        } else {
            return this.threadLocalRandom.nextGaussian();
        }
    }
}