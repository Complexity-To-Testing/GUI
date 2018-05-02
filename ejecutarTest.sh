#!/bin/bash
DIR_PROYECTO_JAVA='./generadorMutantesJAVA'
DIR_TESTSPOMS=$DIR_PROYECTO_JAVA/testsPoms                # Directorio que contiene todos los ficheros de configuracion por tests (Acumulado)
DIR_TESTSPOMS_UNIQUE=$DIR_PROYECTO_JAVA/testsPomsUnique   # Directorio que contiene todos los ficheros de configuracion por tests (Unico)
FILE_RESULTADOS=$DIR_PROYECTO_JAVA/resultados.txt         # Fichero que contiene los resultados de los test
FILE_RESULTADO=$DIR_PROYECTO_JAVA/resultado.txt           # Fichero que contiene los resultados de los test
DIR_REPORTS=$DIR_PROYECTO_JAVA/target/pit-reports         # Directorio que contiene los resultados de los mutantes
FILE_POM=$DIR_PROYECTO_JAVA/pom.xml                       # Fichero de configuracion de maven para ejecutar PIT
FILE_RUN=$DIR_PROYECTO_JAVA/run.sh                        # Fichero que ejecuta la generacion de mutantes con PIT
FILE_MUTANTES=$DIR_PROYECTO_JAVA/mutantes.txt

# 2. Copiamos un fichero de configuracion al proyecto
cp  $DIR_TESTSPOMS/$1 $FILE_POM;

# 3. Ejecutamos pit para el fichero de configuracion
echo " $1 $( sh $FILE_RUN ) " > $FILE_RESULTADO;

# 4. Obtenemos los mutantes
  for file in $(ls  $DIR_REPORTS)
  do
      cat $DIR_REPORTS/${file}/mutations.csv | sed 's/org.pitest.mutationtest.engine.gregor.mutators.//g'| cut -d "," -f 1,3,6 > $FILE_MUTANTES
  done
echo "Terminado"
