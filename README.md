# Francium
Francium is a Forge optimization mod that replaces some `Random` fields with `ThreadLocalRandom` for better performance and higher fps.

This is inspired by [Faster Random](https://modrinth.com/mod/faster-random). However, Francium's implementation is wider and more rooted.

ThreadLocalRandom has a property: its `setSeed` method is not a supported operation, Thus, as long as a Random field is not calling `setSeed`, Francium can replace it with ThreadLocalRandom.

Client side: Optional

Server side: Optional
# Benchmark Info
Minecraft version: 1.16.5

Java version: Azul Zulu Java 17 (highly recommended, check out [ModernFix's wiki](https://github.com/embeddedt/ModernFix/wiki/1.16---required-arguments-for-Java-17)!)

Weather: None

Difficulty: Peaceful

Seed: -963323667424106092

Position: -139.746 102.0 -658.997

ModList:
![img.png](https://github.com/MCTeamPotato/Francium/blob/1182/images/modlist.png?raw=true)

Entities and item entities have been cleared by [Cuneiform](https://www.curseforge.com/minecraft/mc-mods/cuneiform) commands /killall and /killitems

You can see my play time is 4:29 below, and in these 269 seconds, I have never moved or change my mouse too much (almost completely still).

This has been tested for three times, and the images below are from the third test.
## With Francium Installed
Average FPS: 780 ~ 800
![img.png](https://github.com/MCTeamPotato/Francium/blob/1165/images/francium.png?raw=true)
## Without Francium Installed
Average FPS: 630 ~ 650
![img.png](https://github.com/MCTeamPotato/Francium/blob/1165/images/vanilla.png?raw=true)

# Compatibility
Although there are currently no known compatibility issues, considering the slightly intrusive nature of the adjustments made by Francium, this mod may be incompatible with some other mods.

Francium has tweaked your crash report so that if there is a crash caused by this mod, the header of the crash report will have this phrase: "This crash is most likely caused by Francium, please bring this crash report with you to report it!"

# Issue Report
https://github.com/MCTeamPotato/Kasualix-Issue-Tracker