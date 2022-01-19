decrypt-maven-plugin
=====================
<a href="https://github.com/davidmoten/decrypt-maven-plugin/actions/workflows/ci.yml"><img src="https://github.com/davidmoten/decrypt-maven-plugin/actions/workflows/ci.yml/badge.svg"/></a><br/>
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
    <version>VERSION_HERE</version>
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

