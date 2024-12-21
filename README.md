### A library for editing Beatblock levels with Java

### Example Usage
```java
// load the level
Level level = Level.fromFolder(folder);

// delete all Side notes
level.getChart().removeIf(note -> note instanceof Side);

// delete all notes past the 50th beat
level.getChart().removeIf(note -> note.getTime() > 50);

// add new notes
for (int i = 0; i < 10; i++) {
  int angle = i * 10;
  int time = i;
  Block block = new Block(time, angle);
  level.getChart().add(block);
}

// save the changes
level.save();
```

### Download
Maven
```
<dependencies>
  <dependency>
    <groupId>me.eren.beatblockeditor</groupId>
    <artifactId>beatblockeditor</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```
JAR downloads can be found in [packages](https://github.com/erenkarakal/BeatblockEditor/packages/2353027)
