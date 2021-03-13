# Proyecto realizado por Johann Steven Bogot�
# Laboratorio 05 AREP

En este taller se construira una aplicaci�n con la siguiente arquitectura propuesta que se desplegara en aws  usando EC2 y Docker
![](img/arquitectura.PNG)

En la imagen anterior se tiene que 
- El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una m�quina virtual de EC2
- LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
- La aplicaci�n web APP-LB-RoundRobin est� compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un bot�n y cada vez que el usuario env�a un mensaje, este se lo env�a al servicio REST y actualiza la pantalla con la informaci�n que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.

### Prerequisites

* [Docker](https://www.docker.com/) - Container Manager
* [Maven](https://maven.apache.org/) - Dependency Management
* [Java 8](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) -  Development Environment 
* [Git](https://git-scm.com/) - Version Control System
* [Spark](http://sparkjava.com/) - Micro framework for creating web applications in Java 8

## Compilar programa
- Clonar el repositorio
```
git clone https://github.com/johann9911/AREP-LAB5.git
``` 
- Para compilar (Se tienen dos proyectos por separado, para ejecutar los pasos de maven, ir a las carpetas donde se encuentra el POM)
```
mvn clean install
```
- Para generar la documentaci�n
```
mvn javadoc:javadoc o mvn javadoc:jar (generar jar)
```
- Para usar la aplicaci�n desplegada en AWS ir al siguiente enlace
```
http://ec2-35-172-193-175.compute-1.amazonaws.com:8000/
```

## Test de ejecuci�n
Insertar un log
![img1](img/arep.PNG)
Obtener un log ingresado
![img1](img/arep2.PNG)
Obtener los 10 ultimos logs
![img1](img/arep3.PNG)
## Documentaci�n

Mirar RoundRobin [Documentacion](https://github.com/johann9911/AREP-LAB5.git/apidocs_r/)

Mirar ServicesLog [Documentacion](https://github.com/johann9911/AREP-LAB5.git/apidocs_s/)

## Licencia
Ver licencia en LICENCE.txt para más detalles.