package com.github.davidmoten.aws.maven;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.settings.Server;
import org.apache.maven.settings.Settings;
import org.apache.maven.settings.crypto.DefaultSettingsDecryptionRequest;
import org.apache.maven.settings.crypto.SettingsDecrypter;
import org.apache.maven.settings.crypto.SettingsDecryptionRequest;
import org.apache.maven.settings.crypto.SettingsDecryptionResult;

@Mojo(name = "decrypt")
public final class DecryptMojo extends AbstractMojo {

    @Parameter(name = "serverId", required = true)
    private String serverId;

    @Parameter(name = "outputFile", required = true)
    private File outputFile;

    @Component
    private Settings settings;

    @Component
    private SettingsDecrypter decrypter;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        SettingsDecryptionRequest request = new DefaultSettingsDecryptionRequest();
        request.setServers(settings.getServers());
        SettingsDecryptionResult result = decrypter.decrypt(request);
        for (Server server : result.getServers()) {
            if (server.getId().equals(serverId)) {
                String password = server.getPassword();
                try {
                    Files.write(outputFile.toPath(), password.getBytes(Charset.forName("UTF-8")));
                    return;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new MojoExecutionException("serverId not found in settings: " + serverId);
    }

}
