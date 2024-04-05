# Определение массива строк
PACKAGE := book.chapter2.
BINPATH := bin
DOCPATH := javadoc
COMPILE := javac -encoding utf8 -d $(BINPATH)
RUN := java -classpath $(BINPATH) $(PACKAGE)
JAVADOC := javadoc -private -encoding utf8 -d $(DOCPATH)

all: compile

compile: Prg1.java HelloWorld.java ATypeName.java DataOnly.java Storage.java Incrementable.java Pack.java Args.java AllTheColorsOfTheRainbow.java
	$(COMPILE) $^

# Exercise 1
Prg1:
	$(RUN)$@

# Exercise 2
HelloWorld:
	$(RUN)$@

# Exercise 3
ATypeName:
	$(RUN)$@

# Exercise 4, 5
DataOnly:
	$(RUN)$@

# Exercise 6
Storage:
	$(RUN)$@

# Exercise 7, 8
Incrementable:
	$(RUN)$@

# Exercise 9
Pack:
	$(RUN)$@

# Exercise 10
Args:
	$(RUN)$@ First_param Second_param Third_param

# Exercise 11
AllTheColorsOfTheRainbow:
	$(RUN)$@

# Exercise 12
HelloDate:
	$(COMPILE) $@.java
	$(RUN)$@
	$(JAVADOC)/$@ $@.java

# Exercise 13
Documentation:
	$(JAVADOC)/$@ $@*.java

# Exercise 14
DocumentationHTML:
	$(JAVADOC)/$@ $@.java

# Exercise 15
HelloWorldJavaDoc:
	$(COMPILE) $@.java
	$(RUN)$@
	$(JAVADOC)/$@ $@.java

# Exercise 16
Overloading: Print.java
	$(COMPILE) $@.java $^
	$(RUN)$@
	$(JAVADOC)/$@ $@.java $^

# пример создания документации к файлу
javadoc:
	javadoc -encoding UTF-8 -d ./javadoc Prg1.java

clean:
	rm -rf $(BINPATH) $(DOCPATH)