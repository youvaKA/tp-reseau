all: exo1 exo2 exo3

exo1: 
	javac -sourcepath src -d classes/exercice1 src/exercice1/*.java

exo2: 
	javac -sourcepath src -d classes/exercice2 src/exercice2/*.java

exo3: exo3
	javac -sourcepath src -d classes src/exercice3/*.java

runExo3 : exo3
	java -classpath classes exercice3.ChatAPP


