Criterios de Diseño
==
###### Diseño de José Miguel Ramírez Sanz y José Luis Garrido Labrador

## Arquitectura general
Se ha dividido la aplicación en cuatro capas independientes y relacionadas entre si. Estas son:
* Modelo (model)
* Vista (view)
* Controlador (controller)
* Persistencia (persistence)

De estas capas son extensibles **Vista** **Persistencia** y **Controlador**. EL **Modelo** no tiene bloqueada la extensión pero el uso general de la aplicación se basa en las implementaciones concretas. Esto se eligió así debido a que el modelo es lo más estático en el tiempo, pero no lo son los controladores, las vistas o los sistemas de persistencia utilizado.

Ahora pasamos a explicar la funcionalidad de las tres capas extensibles

### Persistencia
La responsabilidad de la persistencia es la carga y almacenado del modelo, así como las tareas específicas de estas responsabilidades (carga de una lista, carga por identificador, almacenado de un objeto etc)

Se declara en una relación entre una clase **PersistenceFactory** que utiliza el patrón **método fábrica** y la interfaz **Persistence** cuyas implementaciones serán instanciadas por las implementaciones de **PersistenceFactory**, esto se eligió para controlar la creación de los sistemas de persistencia según criterios del implementador. En el caso de nuestra implementación, mediante CSV, no es especialmente complejo la creación del objeto, sin embargo, en sistemas de persistencias más avanzados que tuviesen construcciones internas más complejas si que sería interesante. Esto es debido a que **Persistence** funciona como una **Fachada**.

Como se ha comentado nuestra implementación de la persistencia ha sido mediante CSV en una única clase, sin embargo, en otros sistemas como SQL más avanzados, como *JPA* o *JDBC* podrían tener varias clases dentro de un submodelo aislado, lo que justifica la **Fachada** para simplificar el acceso global del programa así como el **Método fábrica** que implicaría la instancia del subsistema y la **Fachada** asociada.

### Controlador
Los controladores del sistema se encargan de gestionar el funcionamiento interno de las tareas para cumplir los requisitos. Funcionan en familias, según las funcionalidades extras que se les quiera añadir, así como los requisitos que se añadan o se cambien.

También tiene la responsabilidad de gestionar la persistencia, siendo el único objeto del diseño que se encarga de la gestión de la persistencia, es por tanto que replica varias funciones de la persistencia, se podría considerar una especie de **Adaptador**, es decir, adapta una interfaz para que el sistema pueda usarlo sin conocer la de la persistencia, sin embargo funciona como una envoltura a las funcionalidades de la persistencia y no como una adpatación real ya que realmente lo que hace es ejecutar tareas referentes a los requisitos antes de modificar los datos almacenados.

Se construye mediante una **Fábrica abstracta** (*ControllerFactory*) que se encarga de construir a toda la familia de controladores y encargarse de que todos utilicen el mismo controlador de persistencia.

### Vista
