#!/bin/bash
DIR_PROYECTO_GENERADOR_JAVA='./tfgArtefactID'
cd $DIR_PROYECTO_GENERADOR_JAVA

mvn compile
mvn exec:java -Dexec.mainClass="tfgGroupID.tfgArtefactID.Main" -Dexec.args="2 1 1 1 5 2 2 2 1,2,3,4,5,6,7,8,9,10,11,12,13, ./ nombreTest nombrePrograma";
cd -
