#!/bin/sh
FILE_LOG='logMutantes.txt'
salida=$(cd ./generadorMutantesJAVA; mvn clean verify org.pitest:pitest-maven:mutationCoverage > ../logMutantes.txt ; cd -)
#cd -

listNumbers=$(cat logMutantes.txt | grep -i 'mutations Killed' |  sed -e 's/[^0-9 ]//g')
arr=($listNumbers)

numMutanst=${arr[0]}
killed=${arr[1]}
percent=${arr[2]}
time=$(cat logMutantes.txt | grep -i 'Total time' | sed 's/[^0-9.]*//g')

echo $numMutanst $killed $percent $time #> $FILE_RESULTADO
