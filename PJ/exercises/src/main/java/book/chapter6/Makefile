# Определение массива строк
PACKAGE := book.chapter6.
BINPATH := bin
COMPILE := javac -encoding utf8 -d $(BINPATH)
RUN := java -classpath $(BINPATH) $(PACKAGE)


# Exercise 3
Class3:
	$(COMPILE) $@.java .\debug\Debug.java
	$(RUN)$@

# Exercise 4, 5, 6
Class4:
	$(COMPILE) $@.java .\Cookie3.java .\Cookie4.java .\Cookie2.java .\coockie\Cookie1.java
	$(RUN)$@

# Exercise 7
Class5:
	$(COMPILE) $@.java .\acess\Widget.java .\acess\Utils.java 
	$(RUN)$@

clean:
	rm -rf $(BINPATH)