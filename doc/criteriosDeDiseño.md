Criterios de Diseño
==
###### Diseño de José Miguel Ramírez Sanz y José Luis Garrido Labrador
###### **Profesor:** Jesús Alonso Abad

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

Se declara en una relación entre una clase **PersistenceFactory** que utiliza el patrón **método fábrica** y la interfaz **Persistence** cuyas implementaciones serán instanciadas por las implementaciones de **PersistenceFactory**, esto se eligió para controlar la creación de los sistemas de persistencia según criterios del implementador. En el caso de nuestra implementación, mediante CSV, no es especialmente complejo la creación del objeto, sin embargo, en sistemas de persistencias más avanzados que tuviesen construcciones internas más complejas si que sería interesante. Esto es debido a que **Persistence** funciona como una **Fachada**.

Como se ha comentado nuestra implementación de la persistencia ha sido mediante CSV en una única clase, sin embargo, en otros sistemas como SQL más avanzados, como *JPA* o *JDBC* podrían tener varias clases dentro de un submodelo aislado, lo que justifica la **Fachada** para simplificar el acceso global del programa así como el **Método fábrica** que implicaría la instancia del subsistema y la **Fachada** asociada.

En el caso particular de la implementación **CSVFactory** se ha considerado **Singleton** ya que no es necesario tener más de una instancia de esta clase.

### **Controlador**
Los controladores del sistema se encargan de gestionar el funcionamiento interno de las tareas para cumplir los requisitos. Funcionan en familias, según las funcionalidades extras que se les quiera añadir, así como los requisitos que se añadan o se cambien.

También tiene la responsabilidad de gestionar la persistencia, siendo el único objeto del diseño que se encarga de la gestión de la persistencia, es por tanto que replica varias funciones de la persistencia, se podría considerar una especie de **Adaptador**, es decir, adapta una interfaz para que el sistema pueda usarlo sin conocer la de la persistencia, sin embargo funciona como una envoltura a las funcionalidades de la persistencia y no como una adpatación real ya que realmente lo que hace es ejecutar tareas referentes a los requisitos antes de modificar los datos almacenados.

Se construye mediante una **Fábrica abstracta** (*ControllerFactory*) que se encarga de construir a toda la familia de controladores y encargarse de que todos utilicen el mismo controlador de persistencia.

### **Vista**
Las vistas crean una guía de implementación de la interacción, en semejanza a **MVC** se encarga de comunicarse con el usuario, derivar las peticiones al controlador y mostrar el modelo, aunque en vez de usar un **Observador** para mostrar los cambios continuos en el modelo simplemente muestra a demanda las representaciones de este. 

La vista se ha definido de manera semejante al controlador, es decir, una clase abstracta con un atributo y un conjunto de abstracciones para cada uno de los individuos del modelo. 

Esto se ha hecho para que todas las vistas tengan la misma **Fábrica Abstracta** de controladores y toda la vista utilice la misma familia de controladores. Sin embargo, estas clases hacen más de guía que de contrato ya que la única clase que se utiliza por el *main* es la clase Menu que debe tener la función *start* que devuelve *boolean* (según se desee guardar o no los cambios en el sistema). En la práctica serán las implementaciones de Menú que haran de **Mediador** entre las clases de submodelo de interfaz, siendo incluso posible que no se utilicen las otras implementaciones de las vistas.

### **Modelo**
El modelo sigue el diseño debatido en clase. Con el **Backlog** siendo singleton.
