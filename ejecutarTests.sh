#!/bin/bash
DIR_TESTSPOMS='./testsPoms'
DIR_TESTSPOMS_UNIQUE='./testsPomsUnique'
FILE_RESULTADOS='resultados.txt'

cd ./proyectoJAVA
rm $FILE_RESULTADOS

for testFile in $(ls  $DIR_TESTSPOMS)
do
    cp  $DIR_TESTSPOMS/$testFile pom.xml;
    echo " $testFile $(sh run.sh) " >> $FILE_RESULTADOS;
done
echo "Terminado"
cd -
