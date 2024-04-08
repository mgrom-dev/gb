# Определение массива строк
PACKAGE := book.chapter4.
BINPATH := bin
COMPILE := javac -encoding utf8 -d $(BINPATH)
RUN := java -classpath $(BINPATH) $(PACKAGE)


# Exercise 1
Numbers:
	$(COMPILE) $@.java
	$(RUN)$@

# Exercise 2
RandomNumbers:
	$(COMPILE) $@.java
	$(RUN)$@

# Exercise 3
RandomNumbersInfinite:
	$(COMPILE) $@.java
	$(RUN)$@

# Exercise 4
SimpleNumber:
	$(COMPILE) $@.java
	$(RUN)$@

# Exercise 5
CharBin:
	$(COMPILE) $@.java
	$(RUN)$@

# Exercise 6
IfElse2:
	$(COMPILE) $@.java ..\chapter2\Print.java
	$(RUN)$@

# Exercise 7
BreakContinue:
	$(COMPILE) $@.java Range.java
	$(RUN)$@

# Example label in JAVA
LabeledFor:
	$(COMPILE) $@.java ..\chapter2\Print.java
	$(RUN)$@

# Exercise 8
VowelsAndConsonants:
	$(COMPILE) $@.java ..\chapter2\Print.java
	$(RUN)$@

# Exercise 9
Fibonacci:
	$(COMPILE) $@.java
	$(RUN)$@ 5

clean:
	rm -rf $(BINPATH)