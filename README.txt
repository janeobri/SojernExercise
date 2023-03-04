(Note, change directory into root directory "SojernExercise")

To compile (on Windows) command line:
javac -d bin src\main\java\CompareVersions.java

To compile (on Mac):
javac -d bin src/main/java/CompareVersion.java

(the compiled class file is now in folder 'bin', specified by the d flag)

To run:
java -cp bin main.java.CompareVersions x y

(where x is version1, and y is version2
e.g. java -cp bin main.java.CompareVersions 1.3.3.4 1.3.3
java -cp bin main.java.CompareVersions 1.2 1.3
java -cp bin main.java.CompareVersions 2.3 2.6
separate versions by a space character)

if no arguments are passed in, then default values are used instead.

Alternatively, comment out the first line //package main.java; in CompareVersions.java file and change directory into src/main/java
to compile: javac CompareVersions.java
to run: java CompareVersions 1.3.2 1.4

(This will result in the class file being in the same folder as the java file)
