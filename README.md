# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/spring-tool-extensions/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/spring-tool-extensions/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/spring-tool-extensions/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/spring-tool-extensions)
[![Build Status](https://api.travis-ci.com/astrapi69/spring-tool-extensions.svg?branch=develop)](https://travis-ci.com/github/astrapi69/spring-tool-extensions)
[![Coverage Status](https://coveralls.io/repos/github/astrapi69/spring-tool-extensions/badge.svg?branch=develop)](https://coveralls.io/github/astrapi69/spring-tool-extensions?branch=develop)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/spring-tool-extensions.svg?style=flat)](https://github.com/astrapi69/spring-tool-extensions/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/spring-tool-extensions/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/spring-tool-extensions)
[![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/spring-tool-extensions.svg)](http://www.javadoc.io/doc/de.alpharogroup/spring-tool-extensions)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/spring-tool-extensions)](https://hitsofcode.com/github/astrapi69/spring-tool-extensions/view)

</div>

Project that holds utility classes for the spring framework

> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
<a class="github-button" href="https://github.com/astrapi69/spring-tool-extensions" data-icon="octicon-star" aria-label="Star astrapi69/spring-tool-extensions on GitHub">Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## gradle dependency

Add the following gradle dependency to your project `build.gradle` in the dependencies section if
you want to import the core functionality of spring-tool-extensions:

define version in file gradle.properties

```

springToolExtensionsVersion=1.10.1
```

or in build.gradle ext area

```
    springToolExtensionsVersion = "1.10.1"
```

and than add the dependency to the dependencies area

```
    implementation("de.alpharogroup:spring-tool-extensions:$springToolExtensionsVersion")
```

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~spring-tool-extensions~~~) for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core functionality of spring-tool-extensions:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- SPRING-TOOL-EXTENSIONS VERSION -->
        <spring-tool-extensions.version>1.10.1</spring-tool-extensions.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- SPRING-TOOL-EXTENSIONS DEPENDENCY -->
            <dependency>
                <groupId>de.alpharogroup</groupId>
                <artifactId>spring-tool-extensions</artifactId>
                <version>${spring-tool-extensions.version}</version>
            </dependency>
            ...
        </dependencies>

# Donations

If you like this library, please consider a donation through paypal: <a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this" title="PayPal – The safer, easier way to pay online!" border="0" />
</a>

or over bitcoin or bitcoin-cash with:

36JxRRDfRazLNqUV6NsywCw1q7TK38ukpC

or over ether with:

0x588Aa02De98B1Ef70afeDC3ec5290130a3E5e273

or over flattr:

<a href="http://flattr.com/thing/4067696/astrapi69spring-tool-extensions-on-GitHub" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" style="border: none" />
</a>

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making spring-tool-extensions great for all types of applications.

## Semantic Versioning

The versions of spring-tool-extensions are maintained with the Simplified Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning for this project you can visit this [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Simplified-Semantic-Versioning).

## Want to Help and improve it? ###

The source code for spring-tool-extensions are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/spring-tool-extensions/fork](https://github.com/astrapi69/spring-tool-extensions/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/spring-tool-extensions/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the spring-tool-extensions developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/spring-tool-extensions/issues).

## Credits

|**Travis CI**|
|     :---:      |
|[![Travis CI](https://travis-ci.com/images/logos/TravisCI-Full-Color.png)](https://coveralls.io/github/astrapi69/spring-tool-extensions?branch=master)|
|Special thanks to [Travis CI](https://travis-ci.org) for providing a free continuous integration service for open source projects|
|     <img width=1000/>     |

|**Nexus Sonatype repositories**|
|     :---:      |
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/de.alpharogroup/spring-tool-extensions.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~spring-tool-extensions~~~)|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**coveralls.io**|
|     :---:      |
|[![Coverage Status](https://coveralls.io/repos/github/astrapi69/spring-tool-extensions/badge.svg?branch=develop)](https://coveralls.io/github/astrapi69/spring-tool-extensions?branch=master)|
|Special thanks to [coveralls.io](https://coveralls.io) for providing a free code coverage for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/spring-tool-extensions.svg)](http://www.javadoc.io/doc/de.alpharogroup/spring-tool-extensions)|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |
