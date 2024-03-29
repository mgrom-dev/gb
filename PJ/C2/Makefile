# Определение массива строк
SOURCES := Prg1.java HelloWorld.java ATypeName.java DataOnly.java Storage.java Incrementable.java Pack.java Args.java AllTheColorsOfTheRainbow.java

all: compile

compile:
	javac $(SOURCES)

# Exercise 1
Prg1:
	java $@

# Exercise 2
HelloWorld:
	java $@

# Exercise 3
ATypeName:
	java $@

# Exercise 4, 5
DataOnly:
	java $@

# Exercise 6
Storage:
	java $@

# Exercise 7, 8
Incrementable:
	java $@

# Exercise 9
Pack:
	java $@

# Exercise 10
Args:
	java $@ First_param Second_param Third_param

# Exercise 11
AllTheColorsOfTheRainbow:
	java $@

# Exercise 12
HelloDate:
	javac -encoding utf8 $@.java
	java $@
	javadoc -encoding utf8 -d ./$@ $@.java

# Exercise 13
Documentation:
#	javadoc -encoding utf8 -d ./$@ $@1.java
#	javadoc -encoding utf8 -d ./$@ $@2.java
	javadoc -encoding utf8 -d ./$@ $@3.java

# пример создания документации к файлу
javadoc:
	javadoc -encoding UTF-8 -d ./javadoc Prg1.java

clean:
	rm -rf *.class *.js *.css *.html ./Documentation/ ./javadoc/ ./HelloDate/ ./legal/ ./resources/ ./script-dir/ ./element-list