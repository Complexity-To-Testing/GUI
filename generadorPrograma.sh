#!/bin/bash
DIR_PROYECTO_GENERADOR_JAVA='./generadorProgramasJAVA'
NAME_CLASS_GENERATED='Programa.java'
NAME_TEST_GENERATED='Test.java'
FILE_CLASS_GENERATED=$DIR_PROYECTO_GENERADOR_JAVA/ficherosCreados/$NAME_CLASS_GENERATED
FILE_TEST_GENERATED=$DIR_PROYECTO_GENERADOR_JAVA/ficherosCreados/$NAME_TEST_GENERATED
DIR_PROYECTOS_NODE='./public/proyectos'         # Directorio que contiene el fichero de las clases y test que el usuario ha subido
NAME_CLASSES='Classes.zip'                      # Nombre del fichero comprimido de las clases originales
NAME_TESTS='Tests.zip'                          # Nombre del fichero comprimido de los test
FILE_CLASSES=$DIR_PROYECTOS_NODE/$NAME_CLASSES  # Fichero zip que contiene todas las clases originales
FILE_TESTS=$DIR_PROYECTOS_NODE/$NAME_TESTS

cd $DIR_PROYECTO_GENERADOR_JAVA

mvn compile
mvn exec:java -Dexec.mainClass="tfgGroupID.tfgArtefactID.Main" -Dexec.args=" $1 $2 $3 $4 $5 $6 $7 $8 $9 ./ Test Programa ";
cd -
#zip $NAME_CLASSES $FILE_CLASS_GENERATED
#zip $NAME_TESTS $FILE_TEST_GENERATED

mv $FILE_CLASS_GENERATED $DIR_PROYECTOS_NODE
mv $FILE_TEST_GENERATED $DIR_PROYECTOS_NODE

cd $DIR_PROYECTOS_NODE
zip $NAME_CLASSES $NAME_CLASS_GENERATED
zip $NAME_TESTS $NAME_TEST_GENERATED

rm $NAME_CLASS_GENERATED
rm $NAME_TEST_GENERATED

cd -

# Comprimimos la clase
