#!/bin/sh
# Si existe el directorio lo borramos

DIA=`date +"%d/%m/%Y"`
HORA=`date +"%H:%M"`
DIR_RESULT="results"

#
if [ -e ./$DIR_RESULT ] ; then
    rm -r ./$DIR_RESULT;
fi

# Creamos el nuevo directorio
mkdir $DIR_RESULT;

# Ejecutamos el programa y redirigimos la salida a results
salida=$(mvn clean verify org.pitest:pitest-maven:mutationCoverage)  #> ./$DIR_RESULT/result.txt;

listNumbers=$(echo "${salida}"| grep -i 'mutations Killed' |  sed -e 's/[^0-9 ]//g')
arr=($listNumbers)

numMutanst=${arr[0]}
killed=${arr[1]}
percent=${arr[2]}
time=$(echo "${salida}"| grep -i 'Total time' | sed 's/[^0-9.]*//g')

echo $numMutanst $killed $percent $time
#mvn verify org.pitest:pitest-maven:mutationCoverage >> ./$DIR_RESULT/result_$HORA.txt;
