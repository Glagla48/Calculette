#Resume
Small calculator using ASM-like language. 
It implements basic operations such as ADD, DIV, MOD, ..., and loops.


#How to Launch
```
	antlr4 Calculette.g4
	javac *.java
	antlr4-grun Calculette start test.txt (-gui)
	
	AutoCor.sh Calculette.g4 *.java

	java -cp :MVaP.jar MVaPAssembler add.mvap
	java -jar MVaP.jar -d add.mvap.cbap
```


