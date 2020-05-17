## Change log
----------------------

Version 1.6-SNAPSHOT
-------------

ADDED:

- gradle as new build system

CHANGED:

- update of spring dependency to version 5.2.6.RELEASE
- update of spring-data-jpa dependency to version 2.3.0.RELEASE
- update of javax.servlet-api dependency to version 4.0.1
- update of jobj-core dependency to version 3.5

Version 1.5
-------------

ADDED:

- new dependency of swagger-annotations in version 1.5.20 added
- new factory method for FlatFileItemReader
- new factory method for CustomBeanWrapperFieldSetMapper
- new dependency of generic-mapper in version 2.2 added
- new method for expand an url object

CHANGED:

- update of parent version to 5.5
- added swagger documentation to the class AbstractRestController
- moved interface GenericMapper to project generic-mapper
- null safety added to all methods

Version 1.4
-------------

ADDED:

- new factory class created for generate ParameterizedTypeReference for collection types
- new class for create url for the rest template

Version 1.3
-------------

ADDED:

- new custom generator class created from the SequenceStyleGenerator that can be used in the GenericGenerator

Version 1.2
-------------

ADDED:

- new view model bean that holds data for exception representations
- new factory class for create the view model bean for exception representations

Version 1.1.2
-------------

ADDED:

- new methods for map colletions

Version 1.1.1
-------------

CHANGED:

- added getter methods for mapper and service to AbstractRestController

Version 1.1
-------------

ADDED:

- new inteface for map entities to view models and back
- new spring abstract rest controller created
- new service interface created that delegates all calls to the JpaRepository

Version 1
-------------

ADDED:
 
- this changelog file
