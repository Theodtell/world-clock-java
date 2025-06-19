# 🌍 World Clock Converter (Java)

This Java project defines a hierarchy of clock classes for representing and converting time between different regions: Brazil (24-hour format) and the United States (12-hour format with AM/PM).

## 🚀 Features

- Abstract `Clock` superclass:
    - Contains hour, minute, second properties with validation.
    - Provides a method to return time as `HH:MM:SS`.
    - Defines an abstract `convert()` method for converting between clock types.

- `BRLClock` subclass:
    - Implements Brazilian 24-hour time format.
    - Converts from either `USClock` or another `BRLClock`.

- `USClock` subclass:
    - Implements 12-hour format with AM/PM indicators.
    - Converts from either `BRLClock` or another `USClock`.

## 🧠 Concepts Covered

- Inheritance and abstraction in Java
- Sealed classes (Java 17+)
- Method overriding
- Type-safe pattern matching (`switch` with `instanceof`)
- Time format conversion logic

## 🛠 Requirements

- Java 17 or higher

## 📦 Structure

```bash
src/
├── Clock.java
├── BRLClock.java
└── USClock.java
└── Main.java