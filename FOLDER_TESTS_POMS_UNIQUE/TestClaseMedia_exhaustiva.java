<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>es.tfg</groupId>
    <artifactId>mutationTesting</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>

        <dependency>
            <groupId>org.easytesting</groupId>
            <artifactId>fest-assert-core</artifactId>
            <version>2.0M10</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.easytesting</groupId>
            <artifactId>fest-reflect</artifactId>
            <version>1.4</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.pitest</groupId>
                <artifactId>pitest-maven</artifactId>
                <version>1.1.5</version>
                <configuration>
                    <failWhenNoMutations>false</failWhenNoMutations>
                    <outputFormats>
                        <param>XML</param>
                        <param>HTML</param>
                        <param>CSV</param>
                    </outputFormats>
                    <targetClasses>
<param>claseNodo*</param>
</targetClasses><targetTests>
<param>TestClaseNodo_otras.Prueba</param>
<param>TestClaseNodo_otras.TestCoche</param>
<param>TestClaseNodo_otras.TestHouse</param>
<param>TestClaseNodo_otras.TestPosicion</param>
<param>TestClaseNodo_otras_exhaustiva.TestCoche_exhaustiva</param>
<param>TestClaseNodo_otras_exhaustiva.TestHouse_exhaustiva</param>
<param>TestClaseNodo_otras_exhaustiva.TestPosicion_exhaustiva</param>
<param>TestFigura2D.Test2D</param>
<param>TestFigura2D_exhauxtivo.Test2D_con_valor_aleatorio</param>
<param>TestFigura2D_exhauxtivo.Test2D_exhaustiva</param>
<param>TestFigura3D.Test3D</param>
<param>TestFigura3D_exhauxtivo.Test3D_con_valor_aleatorio</param>
<param>TestFigura3D_exhauxtivo.Test3D_exhaustiva</param>
<param>TestPersonaje.TestClaseAlta</param>
<param>TestPersonaje.TestClaseBaja</param>
<param>TestPersonaje.TestClaseMedia</param>
<param>TestPersonaje.TestVagabundo</param>
<param>TestPersonaje_exhaustiva.TestClaseAlta_exhaustiva</param>
<param>TestPersonaje_exhaustiva.TestClaseBaja_exhaustiva</param>
<param>TestPersonaje_exhaustiva.TestClaseMedia_exhaustiva</param></targetTests></configuration></plugin></plugins></build></project>
