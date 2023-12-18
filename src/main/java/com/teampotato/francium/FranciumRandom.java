package com.teampotato.francium;

import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FranciumRandom extends Random {
    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    private @Nullable /* blame Java field initialization */ Random random = null;
    private boolean seedSet;

    public void setSeed(long seed) {
        if (this.random == null) this.random = new Random();
        this.seedSet = true;
        this.random.setSeed(seed);
    }

    public void nextBytes(byte[] bytes) {
        if (this.seedSet) {
            if (this.random == null) this.random = new Random();
            this.random.nextBytes(bytes);
        } else {
            this.threadLocalRandom.nextBytes(bytes);
        }
    }

    public int nextInt() {
        if (this.seedSet) {
            if (this.random == null) this.random = new Random();
            return this.random.nextInt();
        } else {
            return this.threadLocalRandom.nextInt();
        }
    }

    public int nextInt(int bound) {
        if (this.seedSet) {
            if (this.random == null) this.random = new Random();
            return this.random.nextInt(bound);
        } else {
            return this.threadLocalRandom.nextInt(bound);
        }
    }

    public long nextLong() {
        if (this.seedSet) {
            if (this.random == null) this.random = new Random();
            return this.random.nextLong();
        } else {
            return this.threadLocalRandom.nextLong();
        }
    }

    public boolean nextBoolean() {
        if (this.seedSet) {
            if (this.random == null) this.random = new Random();
            return this.random.nextBoolean();
        } else {
            return this.threadLocalRandom.nextBoolean();
        }
    }

    public float nextFloat() {
        if (this.seedSet) {
            if (this.random == null) this.random = new Random();
            return this.random.nextFloat();
        } else {
            return this.threadLocalRandom.nextFloat();
        }
    }

    public double nextDouble() {
        if (this.seedSet) {
            if (this.random == null) this.random = new Random();
            return this.random.nextDouble();
        } else {
            return this.threadLocalRandom.nextDouble();
        }
    }

    public double nextGaussian() {
        if (this.seedSet) {
            if (this.random == null) this.random = new Random();
            return this.random.nextGaussian();
        } else {
            return this.threadLocalRandom.nextGaussian();
        }
    }
}