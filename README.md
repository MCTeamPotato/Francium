# Francium
Francium is a Forge optimization mod that replaces some `Random` fields with `ThreadLocalRandom` for better performance and higher fps.

This is inspired by [Faster Random](https://modrinth.com/mod/faster-random) (But Francium doesn't change world generation). However, Francium's implementation is wider and more rooted.

ThreadLocalRandom has a property: its `setSeed` method is not a supported operation, Thus, as long as a Random field is not calling `setSeed`, Francium can replace it with ThreadLocalRandom.

Client side: Optional

Server side: Optional
# Benchmark Info
```
The below benchmark is outdated due to the security improvement in 1.0.0.
```

```
Details: In Francium 1.0.0, To completely avoid the UnsupportedOperationException crash (and this is the only crash Francium may cause) of `ThreadLocalRandom#setSeed`, I did some security improvement so that if a Random field is setSeed, next it will no longer call ThreadLocalRandom. 
```

```
For players, this security brings down performance improvement for a little bit, in my test my fps improvement dropped to 100 from 150.
```

Minecraft version: 1.16.5

Java version: Azul Zulu Java 17 (highly recommended, check out [ModernFix's wiki](https://github.com/embeddedt/ModernFix/wiki/1.16---required-arguments-for-Java-17)!)

Weather: None

Difficulty: Peaceful

Seed: -963323667424106092

Position: -139.746 102.0 -658.997

ModList:
![img.png](https://github.com/MCTeamPotato/Francium/blob/1165/images/modlist.png?raw=true)

Entities and item entities have been cleared by [Cuneiform](https://www.curseforge.com/minecraft/mc-mods/cuneiform) commands /killall and /killitems

You can see my play time is 4:29 below, and in these 269 seconds, I have never moved or change my mouse too much (almost completely still).

This has been tested for three times, and the images below are from the third test.
## With Francium Installed
Average FPS: 780 ~ 800
![img.png](https://github.com/MCTeamPotato/Francium/blob/1165/images/francium.png?raw=true)
## Without Francium Installed
Average FPS: 630 ~ 650
![img.png](https://github.com/MCTeamPotato/Francium/blob/1165/images/vanilla.png?raw=true)

# 1.19.2 ~ 1.20.1?
Not currently. 

In 1.19.2+, Mojang overhauled random number generation from Java's own Random to a custom RandomSource class. 

So if Francium is to support higher versions, it may only be able to undergo simple replacements in specific classes much like Faster Random, and may not be conducive to fundamental reforms like it be in 1.16.5 and 1.18.2, optimization will also be much less effective.

# Issue Report
https://github.com/MCTeamPotato/Kasualix-Issue-Tracker
