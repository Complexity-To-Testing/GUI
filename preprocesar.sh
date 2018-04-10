#!/bin/bash
PROYECTOS='./public/proyectos'
NAME_CLASSES='Classes.zip'
NAME_TESTS='Tests.zip'
FILE_CLASSES='./public/proyectos/'$NAME_CLASSES
FILE_TESTS='./public/proyectos/'$NAME_TESTS
FOLDER_PROYECTOJAVA_SRC='./proyectoJAVA/src/main/java'
FOLDER_PROYECTOJAVA_TEST='./proyectoJAVA/src/test/java'
FILE_POM='./proyectoJAVA/pom.xml'
FILE_POM_TEMP='./proyectoJAVA/tempPom/pom.xml'
FOLDER_TESTS_POMS='./proyectoJAVA/testsPoms'
FOLDER_TESTS_POMS_UNIQUE='./proyectoJAVA/testsPomsUnique'
FOLDER_UPLOADS='./uploads'

if [ -e $FOLDER_TESTS_POMS ] ; then
  rm -r $FOLDER_TESTS_POMS;
fi
if [ -e $FOLDER_TESTS_POMS_UNIQUE ] ; then
  rm -r $FOLDER_TESTS_POMS_UNIQUE;
fi

rm -r $FOLDER_TESTS_POMS
rm -r $FOLDER_TESTS_POMS_UNIQUE

mkdir $FOLDER_TESTS_POMS
mkdir $FOLDER_TESTS_POMS_UNIQUE

rm -r $FOLDER_PROYECTOJAVA_SRC
rm -r $FOLDER_PROYECTOJAVA_TEST

mKdir $FOLDER_PROYECTOJAVA_SRC
mKdir $FOLDER_PROYECTOJAVA_TEST


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
        echo "$(cat ${FILE_POM})</targetTests></configuration></plugin></plugins></build></project>" > $FOLDER_TESTS_POMS/$nameFile
        echo "$(cat ${FILE_POM_TEMP}) $NEW_PARAM </targetTests></configuration></plugin></plugins></build></project>" > $FOLDER_TESTS_POMS_UNIQUE/$nameFile
        cd -
        #cd $FOLDER_PROYECTOJAVA_TEST
    else
        nameFile=$(echo "${file}"| rev | cut -d"/" -f1 | rev)
        if [[ ! ${nameFile} = "__MACOSX" ]]; then
          recorridoRecursivoTest "${file}"
        fi
    fi
done
}
cp $FILE_POM_TEMP $FILE_POM

if [ -f $FILE_CLASSES ]; then
   echo "File $FILE_CLASSES exists."
   unzip -o $FILE_CLASSES -d $FOLDER_PROYECTOJAVA_SRC
   NEWPARAMS=''
   OLDPARAMS='PARAM_CLASS'

   for name in $(ls  $FOLDER_PROYECTOJAVA_SRC)
   do
     if [[ $name = "__MACOSX" ]]; then
       echo "ES __MACOSX"
     else
       NEWPARAMS="<param>$name*</param>"
       echo $NEWPARAMS >> $FILE_POM
     fi
   done
   echo "</targetClasses><targetTests>" >> $FILE_POM
   #sed -i -e "s/$OLDPARAMS/${NEWPARAMS}/g" $FILE_POM
else
 echo "File $FILE_CLASSES does not exist."
fi

echo "====================="
if [ -f $FILE_TESTS ]; then
   echo "File $FILE_TESTS exists."
   unzip -o $FILE_TESTS -d $FOLDER_PROYECTOJAVA_TEST

   cd $FOLDER_PROYECTOJAVA_TEST
   recorridoRecursivoTest  "."
   cd -
   echo "</targetTests></configuration></plugin></plugins></build></project>" >> $FILE_POM
else
 echo "File $FILE_TESTS does not exist."
fi

rm -r $FOLDER_UPLOADS
mkdir $FOLDER_UPLOADS
echo "Terminado"
