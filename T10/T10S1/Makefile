SRC_DIR := ./
OUT_DIR := ourclasses
DOC_DIR := mydoc
ENC := -encoding utf-8

JC := javac
JDOC := javadoc
JSRC := -sourcepath ./$(SRC_DIR)
JCLASS := -cp ./$(OUT_DIR)
JCDEST := -d $(OUT_DIR)
JDOCDEST := -d $(DOC_DIR)
MAIN_SOURCE := ru/mgrom/Main
MAIN_CLASS := ru.mgrom.Main

all:
	${JC} ${JSRC} ${JCDEST} ${SRC_DIR}/${MAIN_SOURCE}.java

clean:
	rm -R ${OUT_DIR} ${DOC_DIR}

run:
	cd ${OUT_DIR} && java ${MAIN_CLASS}

docs:
	${JDOC} ${JDOCDEST} ${JSRC} ${JCLASS} -subpackages ru ${ENC}