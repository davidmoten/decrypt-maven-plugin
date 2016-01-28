decrypt-maven-plugin
=====================
<a href="https://travis-ci.org/davidmoten/decrypt-maven-plugin"><img src="https://travis-ci.org/davidmoten/decrypt-maven-plugin.svg"/></a><br/>
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.davidmoten/decrypt-maven-plugin/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.github.davidmoten/decrypt-maven-plugin)<br/>
<!--[![Dependency Status](https://gemnasium.com/com.github.davidmoten/decrypt-maven-plugin.svg)](https://gemnasium.com/com.github.davidmoten/decrypt-maven-plugin)-->

Decrypts a server password in `.m2/settings.xml` and writes it to a file.

Status: *released to Maven Central*

[Maven site](http://davidmoten.github.io/decrypt-maven-plugin/index.html)

Usage
------------

Add this to your `pom.xml` in the `<build><plugins>` section:

```xml
 <plugin>
    <groupId>com.github.davidmoten</groupId>
    <artifactId>decrypt-maven-plugin</artifactId>
    <version>0.1.1</version>
    <configuration>
        <serverId>container</serverId>
        <outputFile>${project.build.directory}/pass.txt</outputFile>
    </configuration>
</plugin>
```

To call:

```bash
mvn decrypt:decrypt
```

