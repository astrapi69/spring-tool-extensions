## Change log
----------------------

Version 2
-------------

ADDED:

- new generic class AuthenticationPrincipalResolver for resolve the current user
- new generic class GenericPrincipal that implements the spring interface UserDetails
- new enum class ApplicationHeaderKeyName for the header key names

CHANGED:

- update of jdk to version 11
- update gradle to new patch version 7.5.1
- update of lombok version to 1.18.24

Version 1.12
-------------

ADDED:

- new enum for base rest path values
- new enum for base action that follows after base rest paths

CHANGED:

- update of gradle plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.3.0
- update of gradle plugin dependency 'io.freefair.gradle:lombok-plugin' to new version 6.4.1
- update of dependency spring to new version 5.3.16
- update of dependency spring-data to new version 2.6.2
- update of spring-batch dependency to version 4.3.5

Version 1.11
-------------

ADDED:

- new gradle plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.2.2
- new dependency data-api in major version 3

CHANGED:

- update gradle to new version 7.4
- remove of dependency ent-api (replaced with new dependency data-api)
- update of dependency spring to new version 5.3.15
- update of dependency spring-data to new version 2.6.1
- update of dependency jobj-core to new version 5.3
- update of test dependency mockito-core to new version 4.3.1

Version 1.10.1
-------------

CHANGED:

- method names in class AbstractSwaggerConfiguration from getter to factory methods with new prefix

Version 1.10
-------------

CHANGED:

- update of gradle-plugin com.github.ben-manes.versions to version 0.41.0
- update of jobj-core dependency version to 5.2
- remove of jobj-copy dependency
- remove of jobj-merge dependency
- update of bean-mapper-api dependency version to 1.2
- update of generic-mapper dependency version to 2.6

Version 1.9
-------------

CHANGED:

- update of ent-api dependency version to 2.1
- update of spring dependency to version 5.3.14
- update of spring-batch dependency to version 4.3.4
- update of hibernate dependency to version 5.4.28.Final
- update of lombok dependency to version 1.18.22
- update of spring-data dependency to version 2.6.0
- update of test dependency mockito to version 4.2.0
- update of test dependency junit-jupiter-api to version 5.8.2
- update of gradle-plugin com.github.ben-manes.versions to version 0.39.0

Version 1.8
-------------

ADDED:

- new abstract class AbstractSwaggerConfiguration created
- new method newBaseUrl in class UrlExtensions created

CHANGED:

- update of ent-api dependency version to 2
- update of spring dependency to version 5.3.0
- update of hibernate dependency to version 5.4.22.Final
- update of spring-data dependency to version 2.4.0
- update of lombok dependency to version 1.18.16
- adapted NameEntityService to the new ent-api version 2
- update of dependency commons-lang3 to version 3.11
- update of test dependency mockito to version 3.6.0
- update of gradle-plugin com.github.ben-manes.versions to version 0.34.0
- update of build.gradle file for be more generic

Version 1.7.1
-------------

CHANGED:

- update of dependency ent-api version to 1.8
- adapted NameEntityService to the ent-api version
- update of dependency commons-lang3 to version 3.11
- update of test dependency mockito to version 3.4.3
- update of gradle-plugin com.github.ben-manes.versions to version 0.29.0

Version 1.7
-------------

ADDED:

- new test-dependency junit-jupiter (junit 5) in version 5.6.2
- new class ControllerExceptionHandler

CHANGED:

- update gradle to new version 6.5.1
- update of spring version to 5.2.7
- update of spring-data version to 2.3.1
- update of throw-able dependency to version 1.4
- update of generic-mapper dependency to version 2.4

Version 1.6
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
