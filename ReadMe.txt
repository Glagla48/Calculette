Nous avons terminé la partie obligatoire sujet et validé tout les BMs.
Nous avons donc aussi validé le support normal des flottants ainsi que les casts entre les ints, les floats et les booléens.
Nos conditions supportent des identifiants et des entiers.
De plus, nous avons implémenter le IDENTIFIANT '++' pour les floats et les ints.

Nous avons essayé de faire fonctionner "break" et "continue" pour la boucle while.
Cependant ces instructions ne marchent pas si elles sont dans un if.



Utilitaire:
Ordre d'exécution:
	- antlr4 Calculette.g4
	- javac *.java
	- antlr4-grun Calculette start test.txt (-gui)

./home/etudiants/data/l3/compil/AutoCor.sh Calculette.g4 *.java

java -cp ".:/usr/share/java/*:MVaP.jar" MVaPAssembler add.mvap
java -jar MVaP.jar -d add.mvap.cbap


