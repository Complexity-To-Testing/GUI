#!/bin/bash
DIR_PROYECTOS_NODE='./public/proyectos'         # Directorio que contiene el fichero de las clases y test que el usuario ha subido
DIR_PROYECTO_JAVA='./proyectoJAVA'              # Directorio que contiene todo el proyecto java
NAME_CLASSES='Classes.zip'                      # Nombre del fichero comprimido de las clases originales
NAME_TESTS='Tests.zip'                          # Nombre del fichero comprimido de los test
FILE_CLASSES=$DIR_PROYECTOS_NODE/$NAME_CLASSES  # Fichero zip que contiene todas las clases originales
FILE_TESTS=$DIR_PROYECTOS_NODE/$NAME_TESTS      # Fichero zip que contiene todas los tests
DIR_PROYECTOJAVA_SRC=$DIR_PROYECTO_JAVA/src/main/java   # Directorio donde se descomprimiran las classes originales
DIR_PROYECTOJAVA_TEST=$DIR_PROYECTO_JAVA/src/test/java  # Directorio donde se descomprimiran los tests
FILE_POM=$DIR_PROYECTO_JAVA/pom.xml                     # Fichero de configuracion para la creacion de mutantes
FILE_POM_TEMP=$DIR_PROYECTO_JAVA/tempPom/pom.xml        # Fichero base de configuracion de mutantes
DIR_TESTS_POMS=$DIR_PROYECTO_JAVA/testsPoms             # Directorio donde se guardaran todos los ficheros de configuracion de los test que se van a ejecutar (de manera acumulativa)
DIR_TESTS_POMS_UNIQUE=$DIR_PROYECTO_JAVA/testsPomsUnique  # Directorio donde se guardaran todos los ficheros de configuracion de los tests que se van a ejecutar (de manera unica)
DIR_UPLOADS_NODE='./uploads'                              # Directorio que contiene los ficheros que el usuario a subido a la aplicacion node
DIR_CLASSES_NAMES=$DIR_PROYECTO_JAVA/classes              # Directorio que contiene los resultados de todas las clases segun el test aplicado
FILE_NAME_CLASSES='namesClasses.txt'                      # Fichero que contiene los nombres de todas las clases del programa original

if [ -e $DIR_TESTS_POMS ] ; then
  rm -r $DIR_TESTS_POMS;
fi
mkdir $DIR_TESTS_POMS;
if [ -e $DIR_TESTS_POMS_UNIQUE ] ; then
  rm -r $DIR_TESTS_POMS_UNIQUE;
fi
mkdir $DIR_TESTS_POMS_UNIQUE;
if [ -e $DIR_PROYECTOJAVA_SRC ] ; then
  rm -r $DIR_PROYECTOJAVA_SRC;
fi
mkdir $DIR_PROYECTOJAVA_SRC;
if [ -e $DIR_PROYECTOJAVA_TEST ] ; then
  rm -r $DIR_PROYECTOJAVA_TEST;
fi
mkdir $DIR_PROYECTOJAVA_TEST;
if [ -e $DIR_CLASSES_NAMES ] ; then
  rm -r $DIR_CLASSES_NAMES;
fi
mkdir $DIR_CLASSES_NAMES;

function recorridoRecursivoTest() {
  for file in "$1"/*
  do
      if [ ! -d "${file}" ] ; then
          # primero quita la extension, sgundo cambia el / por ., tercero quita el primer caracter .
          pathfile=$(echo $file | cut -f 2 -d '.' | sed 's/\//./g' | sed -e 's/^.//')
          nameFile=$(echo "${file}"| rev | cut -d"/" -f1 | rev )
          #cd -
          cd -
          # Añadimos el pathFile al fichero de configuracion
          NEW_PARAM="<param>${pathfile}</param>"
          echo $NEW_PARAM >> $FILE_POM
          echo "$(cat ${FILE_POM})</targetTests></configuration></plugin></plugins></build></project>" > $DIR_TESTS_POMS/$nameFile
          echo "$(cat ${FILE_POM_TEMP}) $NEW_PARAM </targetTests></configuration></plugin></plugins></build></project>" > $DIR_TESTS_POMS_UNIQUE/$nameFile
          cd -
          #cd $DIR_PROYECTOJAVA_TEST
      else
          nameFile=$(echo "${file}"| rev | cut -d"/" -f1 | rev)
          if [[ ! ${nameFile} = "__MACOSX" ]]; then
            recorridoRecursivoTest "${file}"
          fi
      fi
  done
}

function recorridoRecursivoClasses() {
  for file in "$1"/*
  do
      if [ ! -d "${file}" ] ; then
          # primero quita la extension, sgundo cambia el / por ., tercero quita el primer caracter .
          pathfile=$(echo $file | cut -f 2 -d '.' | sed 's/\//./g' | sed -e 's/^.//')
          nameFile=$(echo "${file}"| rev | cut -d"/" -f1 | rev )
          #cd -
          cd -
          NEWPARAMS="<param>$pathfile</param>"
          echo $NEWPARAMS >> $FILE_POM
          echo "${nameFile}" >> $DIR_CLASSES_NAMES/$FILE_NAME_CLASSES
          cd -
      else
          nameFile=$(echo "${file}"| rev | cut -d"/" -f1 | rev)
          if [[ ! ${nameFile} = "__MACOSX" ]]; then
            recorridoRecursivoClasses "${file}"
          fi
      fi
  done
}

cp $FILE_POM_TEMP $FILE_POM

if [ -f $FILE_CLASSES ]; then
   echo "File $FILE_CLASSES exists."
   unzip -o $FILE_CLASSES -d $DIR_PROYECTOJAVA_SRC

   # Guardamos los ficheros java en file_names
   rm $DIR_CLASSES_NAMES/$FILE_NAME_CLASSES
   echo "" > $DIR_CLASSES_NAMES/$FILE_NAME_CLASSES
   cd $DIR_PROYECTOJAVA_SRC
   recorridoRecursivoClasses "."
   cd -
   echo "</targetClasses><targetTests>" >> $FILE_POM
else
 echo "File $FILE_CLASSES does not exist."
fi

echo "====================="
if [ -f $FILE_TESTS ]; then
   echo "File $FILE_TESTS exists."
   unzip -o $FILE_TESTS -d $DIR_PROYECTOJAVA_TEST

   cd $DIR_PROYECTOJAVA_TEST
   recorridoRecursivoTest  "."
   cd -
   echo "</targetTests></configuration></plugin></plugins></build></project>" >> $FILE_POM
else
 echo "File $FILE_TESTS does not exist."
fi

rm -r $DIR_UPLOADS_NODE
mkdir $DIR_UPLOADS_NODE
echo "Terminado"
