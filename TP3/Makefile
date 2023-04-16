all: exo1 exo2

exo1:
	javac -d classes/exercice1 src/exercice1/*.java

runServerSingleCo: exo1
	java -classpath classes/exercice1 ServerTcpSingleCo

runServerMultiCo : exo1
	java -classpath classes/exercice1 ServerTcpMultiCo

runClient : exo1
	java -classpath classes/exercice1 Client