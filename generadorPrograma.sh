#!/bin/bash
DIR_PROYECTO_GENERADOR_JAVA='./generadorProgramasJAVA'
NAME_CLASS_GENERATED='Programa.java'
NAME_TEST_GENERATED='Test'
FILE_CLASS_GENERATED=$DIR_PROYECTO_GENERADOR_JAVA/ficherosCreados/$NAME_CLASS_GENERATED
FILE_TEST_GENERATED=$DIR_PROYECTO_GENERADOR_JAVA/ficherosCreados/$NAME_TEST_GENERATED
DIR_PROYECTOS_NODE='./public/proyectos'         # Directorio que contiene el fichero de las clases y test que el usuario ha subido
NAME_CLASSES_ZIP='Classes.zip'                      # Nombre del fichero comprimido de las clases originales
NAME_TESTS_ZIP='Tests.zip'                          # Nombre del fichero comprimido de los test
FILE_CLASSES_ZIP=$DIR_PROYECTOS_NODE/$NAME_CLASSES_ZIP  # Fichero zip que contiene todas las clases originales
FILE_TESTS_ZIP=$DIR_PROYECTOS_NODE/$NAME_TESTS_ZIP # Fichero zip que contiene todas las clases originales
NAME_DIR_FICHEROS_CREADOS='ficherosCreados'

if [ -e $DIR_PROYECTOS_NODE ] ; then
  rm -r $DIR_PROYECTOS_NODE;
fi
mkdir $DIR_PROYECTOS_NODE;

cd $DIR_PROYECTO_GENERADOR_JAVA

if [ -e $NAME_DIR_FICHEROS_CREADOS ] ; then
rm -r $NAME_DIR_FICHEROS_CREADOS;
fi
mkdir $NAME_DIR_FICHEROS_CREADOS;

mvn compile
echo "PARAMETROS"
echo " $1 $2 $3 $4 $5 $6 $7 $8 $9  ${10}  ${11} ${12} ${13} ${14} ${15} ${16} ${17}" > parametros
echo "EMPIEZA EJECUCION"
# mvn exec:java -Dexec.mainClass="tfgGroupID.tfgArtefactID.Main" -Dexec.args=" $1 $2 $3 $4 $5 $6 $7 $8 $9 ./$NAME_DIR_FICHEROS_CREADOS Test Programa ${10} ${11} ${12} ${13} ${14}"; #V7
# mvn exec:java -Dexec.mainClass="tfgGroupID.tfgArtefactID.Main" -Dexec.args=" $1 $2 $3 $4 $5 $6 $7 $8 $9 ./$NAME_DIR_FICHEROS_CREADOS Test Programa ${10} ${11} ${12} ${13}"; #V8
 mvn exec:java -Dexec.mainClass="tfgGroupID.tfgArtefactID.Main" -Dexec.args=" $1 $2 $3 $4 $5 $6 $7 $8 $9 ./$NAME_DIR_FICHEROS_CREADOS Test Programa ${10} ${11} ${12} ${13} ${14} ${15} ${16} ${17}"; #V10

cd -

mv  $FILE_CLASS_GENERATED $DIR_PROYECTOS_NODE
mv  $FILE_TEST_GENERATED* $DIR_PROYECTOS_NODE

cd $DIR_PROYECTOS_NODE
zip $NAME_CLASSES_ZIP $NAME_CLASS_GENERATED
zip $NAME_TESTS_ZIP $NAME_TEST_GENERATED*

rm *.java

cd -
