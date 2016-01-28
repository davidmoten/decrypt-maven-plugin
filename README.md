decrypt-maven-plugin
=====================

Decrypts a server password in `.m2/settings.xml` and writes it to a file.

Usage
------------

Add this to your `pom.xml` in the `<build><plugins>` section:

```xml
 <plugin>
    <groupId>com.github.davidmoten</groupId>
    <artifactId>decrypt-maven-plugin</artifactId>
    <version>0.1</version>
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

