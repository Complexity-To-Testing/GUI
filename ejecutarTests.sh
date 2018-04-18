#!/bin/bash
DIR_PROYECTO_JAVA='./proyectoJAVA'
DIR_TESTSPOMS=$DIR_PROYECTO_JAVA/testsPoms                # Directorio que contiene todos los ficheros de configuracion por tests (Acumulado)
DIR_TESTSPOMS_UNIQUE=$DIR_PROYECTO_JAVA/testsPomsUnique   # Directorio que contiene todos los ficheros de configuracion por tests (Unico)
FILE_RESULTADOS=$DIR_PROYECTO_JAVA/resultados.txt         # Fichero que contiene los resultados de los test
DIR_CLASSES=$DIR_PROYECTO_JAVA/classes                    # Directorio que contiene los resultados de los test por classes
DIR_REPORTS=$DIR_PROYECTO_JAVA/target/pit-reports         # Directorio que contiene los resultados de los mutantes
FILE_NAME_CLASSES=$DIR_CLASSES/namesClasses.txt           # Fichero que contiene todas los nombres de las classes originales
FILE_POM=$DIR_PROYECTO_JAVA/pom.xml                       # Fichero de configuracion de maven para ejecutar PIT
FILE_RUN=$DIR_PROYECTO_JAVA/run.sh                        # Fichero que ejecuta la generacion de mutantes con PIT

cd ./proyectoJAVA

# 1. Recorremos todos los ficheros de configuracion de los tests
for testFilePom in $(ls  $DIR_TESTSPOMS)
do
    # 2. Copiamos un fichero de configuracion al proyecto
    cp  $DIR_TESTSPOMS/$testFilePom $FILE_POM;

    # 3. Ejecutamos pit para el fichero de configuracion
    echo " $testFilePom $(sh $FILE_RUN) " >> $FILE_RESULTADOS;

    # 4. Creamos la carpeta con el nombre del test para guardar los mutantes de cada clase origninal
    mkdir $DIR_CLASSES/$testFilePom

    # 5. Para cada clase guardamos los resultados de los mutantes
    for class in $(cat  $FILE_NAME_CLASSES)
    do
      # 6. Guardamos los mutantes por classes
      for file in $(ls  $DIR_REPORTS)
      do
          cat $DIR_REPORTS/${file}/mutations.csv | grep $class | sed 's/org.pitest.mutationtest.engine.gregor.mutators.//g'| cut -d "," -f 1,3,6 > $DIR_CLASSES/$testFilePom/${class}
      done
    done
done
echo "Terminado"
cd -
