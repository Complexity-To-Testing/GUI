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
        <!-- https://mvnrepository.com/artifact/org.mockito/mockito-all -->
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-all</artifactId>
            <version>1.9.5</version>
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
                  <mutators>
<mutator>INCREMENTS</mutator>
<mutator>MATH</mutator>
</mutators>
   <failWhenNoMutations>false</failWhenNoMutations>
   <outputFormats>
       <param>XML</param>
       <param>HTML</param>
       <param>CSV</param>
   </outputFormats>
   <targetClasses>
<param>ClassMath.ControlMath</param>
<param>ClassMath.Ecuaciones</param>
<param>ClassMath.Vista</param>
</targetClasses><targetTests>
<param>ClassMath.TestMath.TestControl</param>
<param>ClassMath.TestMath.TestEcus</param>
<param>ClassMath.TestMath.TestVista</param></targetTests></configuration></plugin></plugins></build></project>
