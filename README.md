# Strategy Pattern Calculator

Madi Talgat  
SE-2537

Repository: https://github.com/Feruum/sdp67

A Java console calculator using the Strategy pattern. The interactive program supports addition, subtraction, and multiplication. A separate demo adds division and switches between all four algorithms on one calculator.

## Requirements

JDK 17 or newer. No external libraries are needed.

## Build and run

Run these commands from the project folder:

```bash
javac -d out src/*.java
java -cp out Main
```

Choose an operation, enter two numbers, and choose another operation. Enter `0` at the menu to exit. Use a dot for decimal numbers, such as `2.5`.

Example input, one value per line:

```text
1
12
4
2
12
4
3
12
4
0
```

The results are `16.0`, `8.0`, and `48.0`. The program reuses the same `Calculator` object and replaces its strategy after each valid choice.

## Extension and runtime switching demo

```bash
java -cp out ExtensionDemo
```

Output:

```text
12 + 4 = 16.0
12 - 4 = 8.0
12 * 4 = 48.0
12 / 4 = 3.0
```

## Structure

| File | Responsibility |
| --- | --- |
| `src/OperationStrategy.java` | Strategy interface with the common `execute` method |
| `src/AddStrategy.java` | Addition algorithm |
| `src/SubtractStrategy.java` | Subtraction algorithm |
| `src/MultiplyStrategy.java` | Multiplication algorithm |
| `src/Calculator.java` | Context that stores a strategy and delegates calculation |
| `src/Main.java` | Interactive client with a menu, input validation, and strategy selection |
| `src/DivideStrategy.java` | Extra strategy used to demonstrate extension |
| `src/ExtensionDemo.java` | Client that demonstrates runtime switching and the extra strategy |

`Calculator` depends only on `OperationStrategy`. It contains no `if` or `switch` for choosing an algorithm. `Main` selects a strategy through a map. Its conditions handle invalid input and exiting, not arithmetic operation types.

## Add a strategy

1. Create a new class that implements `OperationStrategy`.
2. Implement `execute(double firstNumber, double secondNumber)`.
3. Select that class in a client with `calculator.setStrategy(new YourStrategy())`.

`DivideStrategy` and `ExtensionDemo` show this extension using new files without changing `Calculator`, the existing strategies, or `Main`. To offer a new operation in the existing interactive menu, also update the menu text and add an entry to its map.

Division by zero throws `IllegalArgumentException`. The interactive client accepts finite `double` values; arithmetic follows Java floating-point behavior.

## Report

`Assignment_5_Madi_Talgat.md` is the Markdown report requested for Moodle. `Assignment_5_Madi_Talgat.pdf` is the same report in black and white. The `docs` folder contains the UML diagram as PNG, SVG, and Mermaid source.

## GitHub

The complete ZIP includes local Git history prepared during this session. The commits are attributed to ChatGPT, and the report acknowledges this assistance. No commits have been pushed to GitHub.

After reviewing the project, extract the whole ZIP, open a terminal inside its `sdp67` folder, and push the included history to your repository:

```bash
git log --oneline
git push -u origin main
```

Sign in to GitHub using your normal credentials if Git asks. The remote is `https://github.com/Feruum/sdp67.git`. Upload the Markdown report and the repository link to Moodle as required by the assignment.
