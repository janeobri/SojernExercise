To compile (on Windows):
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
separate versions by a space character 
)

if no arguments are passed in, then default values are used instead.