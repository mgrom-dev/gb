# Определение массива строк
SOURCES := Prg1.java HelloWorld.java

all: compile

compile:
	javac $(SOURCES)

Prg1:
	java $@

HelloWorld:
	java $@

# пример создания документации к файлу
javadoc:
	javadoc -encoding UTF-8 -d ./javadoc Prg1.java

clean:
	rm -rf *.class *.js *.css *.html ./javadoc/ ./legal/ ./resources/ ./script-dir/ ./element-list