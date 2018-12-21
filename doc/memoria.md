MEMORIA DE LA PRÁCTICA
==
###### Diseño de José Miguel Ramírez Sanz y José Luis Garrido Labrador
###### **Profesor:** Jesús Alonso Abad

## Introducción
KanBan es una aplicación de gestión de SCRUM. Altamente extensible, como se explicará a continuación y adaptable a muchos entornos, incluso a sistemas con reglas diferentes. Funciona de manera desacoplada en diversas capas que facilitan la inclusión de nuevas funcionalidades, adaptación de las reglas de negocio.

## Arquitectura general
Se ha dividido la aplicación en cuatro capas independientes y relacionadas entre si. Estas son:
* Modelo (model)
* Vista (view)
* Controlador (controller)
* Persistencia (persistence)

De estas capas son extensibles **Vista** **Persistencia** y **Controlador**. EL **Modelo** no tiene bloqueada la extensión pero el uso general de la aplicación se basa en las implementaciones concretas. Esto se eligió así debido a que el modelo es lo más estático en el tiempo, pero no lo son los controladores, las vistas o los sistemas de persistencia utilizado.

Ahora pasamos a explicar la funcionalidad de las tres capas extensibles

### **Persistencia**
La responsabilidad de la persistencia es la carga y almacenado del modelo, así como las tareas específicas de estas responsabilidades (carga de una lista, carga por identificador, almacenado de un objeto etc)

Se declara en una relación entre una clase **PersistenceFactory** que utiliza el patrón **método fábrica** y la interfaz **Persistence** cuyas implementaciones serán instanciadas por las implementaciones de **PersistenceFactory**, esto se eligió para controlar la creación de los sistemas de persistencia según criterios del implementador. Actualmente, contamos con dos sistemas de Persistencia, uno primero implementado en el primer Release persistencia en CSV, y en este segundo Release con persistenca en SQLite (Base de Datos).

En el Release 1.0 utilizamos para el manejo de la Persistencia una **Fachada**, pero al darnos cuenta que las dos implementaciones de Persistencia compartian gran parte de su código, a excepción de la carga y el almacenado al cerrar la aplicación, decidimos eliminar este patrón y convertir la interfaz en una clase abstracta para poder implementar únicamente las funciones iguales para ambas persistencias. Esta implementación es semejante a un **Método Plantilla** debido a que muchas de las funciones de carga y de almacenado de los datos son propias de cada implementación, sin embargo no utilizamos métodos final en la clase abstracta para permitir la extensión con otros métodos de persistencia dinámicos, como los que ponemos en el fichero adjunto "ejemplo_sqlite_din.md".

Las dos fábricas de persistencias concretas son **Singleton** aunque el contrato con la interfaz no lo obliga, esto se ha decidido así porque nuestras persistencias son muy simples, pero sistemas más complejos que necesiten una construcción más detallada puede no ser necesario.

### **Controlador**
Los controladores del sistema se encargan de gestionar el funcionamiento interno de las tareas para cumplir los requisitos. Funcionan en familias, según las funcionalidades extras que se les quiera añadir, así como los requisitos que se añadan o se cambien.

También tiene la responsabilidad de gestionar la persistencia, siendo el único objeto del diseño que se encarga de la gestión de la persistencia, es por tanto que replica varias funciones de la persistencia, se podría considerar una especie de **Adaptador**, es decir, adapta una interfaz para que el sistema pueda usarlo sin conocer la de la persistencia, sin embargo funciona como una envoltura a las funcionalidades de la persistencia y no como una adaptación real ya que realmente lo que hace es ejecutar tareas referentes a los requisitos antes de modificar los datos almacenados.

Se construye mediante una **Fábrica abstracta** (*ControllerFactory*) que se encarga de construir a toda la familia de controladores y asegurar de que todos utilicen el mismo controlador de persistencia.

### **Vista**
Las vistas crean una guía de implementación de la interacción, en semejanza a **MVC** se encarga de comunicarse con el usuario, derivar las peticiones al controlador y mostrar el modelo, aunque en vez de usar un **Observador** para mostrar los cambios continuos en el modelo simplemente muestra a demanda las representaciones de este. 

La vista se ha definido de manera semejante al controlador, es decir, una clase abstracta con un atributo y un conjunto de abstracciones para cada uno de los individuos del modelo. 

Esto se ha hecho para que todas las vistas tengan la misma **Fábrica Abstracta** de controladores y toda la vista utilice la misma familia de controladores. Sin embargo, estas clases hacen más de guía que de contrato ya que la única clase que se utiliza por el *main* es la clase Menu que debe tener la función *start* que devuelve *boolean* (según se desee guardar o no los cambios en el sistema). En la práctica serán las implementaciones de Menú que haran de **Mediador** entre las clases de submodelo de interfaz, siendo incluso posible que no se utilicen las otras implementaciones de las vistas.

Las opciones del menú (incluido este) han sido gestionadas mediante **Estado** que permite un flujo más normal y fácil de expandir. Cada estado devuelve un nuevo estado sobre el que se seguirá la ejecución hasta que sea nulo. La mayoría vuelve al MenuState a excepción de modificar que puede repetirse.

Las vistas al uso han sido convertidas en **Singleton** ya que solamente muestran información en pantalla.

### **Modelo**
El modelo sigue el diseño debatido en clase. Con el **Backlog** siendo singleton.
