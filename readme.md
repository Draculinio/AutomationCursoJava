# Como bajar el código:

- En el directorio donde se quiera tener el código: 

git clone https://github.com/Draculinio/AutomationCursoJava.git

# Como ver el código:

### pom.xml En el encontrarán todos los paquetes que vamos a usar en el código.

En el van a encontrar dependencias y plugins

1. **Plugins**

	1. maven-compiler-plugin: Para poder usar maven
	2. maven-surefire-report-plugin: Para la generación de reportes
	
2. **Dependencias**

	1. selenium-java: Para usar selenium
	2. testng: El que se encarga de hacer las pruebas
	
### Carpeta Drivers

En esta carpeta van a estar los webdrivers que utilicemos. En este momento solo está el Chromedriver pero puede ir cualquier otro.

### src/test/java

En esta carpeta vamos a encontrar todo nuestro código. Dentro vamos a encontrar los siguientes paquetes:

1. test: Donde vamos a poner todas nuestras pruebas

2. pageObjects: Donde vamos a poner todos los page objects.

3. extras: Donde pondremos todo lo que nos ayude a hacer nuestras pruebas

**TODO EL CÓDIGO TIENE COMENTARIOS**

#Ejecutando las pruebas

Dentro del directorio donde está el proyecto tipear:

*mvn test*

**Formas de ejecutar pruebas por separado**

*mvn -Dtest=OtherTests test*

*mvn -Dtest=OtherTests#testTrue test*

*mvn -Dtest=*Tests test*

*mvn -Dtest=OtherTests#*True test*
	  