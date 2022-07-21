# wordcounter
Application finds max count of words from user input that corresponds input file.

To run application follow steps
  - download files from github
  - open comandline terminal interface in that folder
  - run command: ./gradlew bootJar
  - navigate from that folder to created /build/libs
  - copy input.txt from project resources folder to /build/libs or other .txt file that have same word structure as in input.txt
  - run command: java -jar wordcounter-0.0.1-SNAPSHOT.jar "input.txt"
  - in place of "input.txt" can be name of Your provided input file.
