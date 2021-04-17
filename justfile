all: build test

build:
    mkdir -p target
    ${JAVA_HOME}/bin/javac -cp src/ src/com/deepmesa/examples/*.java -d target

test:
    ${JAVA_HOME}/bin/java -ea -cp target/ com.deepmesa.examples.DualIndexMap