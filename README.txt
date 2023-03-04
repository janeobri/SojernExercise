To compile:
javac -d bin src\main\java\CompareVersions.java

(the compiled class file is now in folder 'bin', specified by the d flag)

To run:
java -cp bin main.java.CompareVersions x y

(where x is version1, and y is version2
e.g. java -cp bin main.java.CompareVersions 1.3.3.4 1.3.3
java -cp bin main.java.CompareVersions 1.2 1.3
java -cp bin main.java.CompareVersions 2.3 2.6
and the compiled class in found in bin folder
)

if no arguments are passed in, then default values are used instead.