### A library for editing Beatblock levels with Java
Currently only chart is editable, events and other level properties will be added later.

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

### Note Types and Properties
![image](https://github.com/user-attachments/assets/d81331c4-dc7c-4524-9c91-f424c415fcd6)
You can use `.getX()` and `.setX()` to get or set each property. All Note constructors have the bare minimum data for the note to work.

### Download
Maven
```
<repository>
  <id>machinemc-repository-releases</id>
  <name>MachineMC Repository</name>
  <url>https://repo.machinemc.org/releases</url>
</repository>

<dependency>
  <groupId>me.eren</groupId>
  <artifactId>beatblockeditor</artifactId>
  <version>1.0.0</version>
</dependency>
```
Gradle
```
maven {
    name "machinemcRepositoryReleases"
    url "https://repo.machinemc.org/releases"
}

implementation "me.eren:beatblockeditor:1.0.0"
```
JAR downloads can be found in [MachineMC Repository](https://repo.machinemc.org/#/releases/me/eren/beatblockeditor)
