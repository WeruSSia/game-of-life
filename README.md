# Game of life

Program simulates Conway's Game of Life (more: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life). 

User is able to put his own settings, regarding:
* gameboard width,
* gameboard height,
* cell resolution - determines the size of a cell (in pixels),
* background color,
* cell color,
* percentage of random filling - determines the percentage of the board that will be randomly filled with cells.
* set of patterns (on specific positions) - patterns can be either chosen from predefined patterns or defined by user,
* game variation code - syntax: B[0-8]*[/]S[0-8]* (more: https://en.wikipedia.org/wiki/Life-like_cellular_automaton),
* refreshing period (in ms),
* refreshing frequency.

Predefined patterns (see: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Examples_of_patterns):
BLINKER, TOAD, BEACON, PULSAR, PENTADECATHLON, GLIDER, LIGHTWEIGHT SPACESHIP, MIDDLEWEIGHT SPACESHIP, HEAVYWEIGHT SPACESHIP

## Usage example:

### Default settings:
* gameboard width: 1000px,
* gameboard height: 800px,
* cell resolution: 5px,
* background color: black,
* cell color: green,
* percentage of random filling: 50%,
* game variation code: B23/S3 (Conway's),
* refreshing period: 100ms.

### Defining own set of patterns:

Create patterns set:

```
Set<PatternOnPosition> patterns = new HashSet<>();
```
Create new pattern from predefined patterns on position:

```
PatternOnPosition newPattern = new PatternOnPosition(Pattern.BLINKER, new Position(2,2));
```
Create new own pattern:

```
boolean[][] myPattern = {{true,true,true},{false,true,false},{true,true,true}};
```
It would look like this:

Add those patterns to the set:

```
patterns.add(newPattern);
patterns.add(new PatternOnPosition(myPattern,new Position(10,2)));
```
Create an instance of GameSettings:

```
GameSettings gameSettings = new GameSettings();
```
Add your patterns set:

```
gameSettings.setPatternsOnPositions(patterns);
```
Now it's also possible to change other settings by calling set methods on `gameSettings` object.

Finally, play:

```
new GameOfLife(gameSettings).play();
```


Press enter to close the window.