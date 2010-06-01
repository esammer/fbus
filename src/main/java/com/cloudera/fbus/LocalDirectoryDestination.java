package com.cloudera.fbus;

import java.io.File;

import org.springframework.integration.message.MessageBuilder;

/**
 * A Spring Integration message end point suitable for delivering messages with
 * a {@link File} payload to a local file system directory.
 * 
 */
public class LocalDirectoryDestination {

  private File directory;
  private boolean autoCreateDirectory;

  private void ensureDirectory() {
    if (directory == null) {
      throw new IllegalStateException("No configured destination directory");
    } else if (directory.exists()) {
      if (!directory.isDirectory()) {
        throw new IllegalStateException("Destination " + directory
            + " is not a directory");
      }
    } else {
      if (autoCreateDirectory) {
        if (!directory.mkdirs()) {
          throw new IllegalStateException(
              "Unabled to create destination directory " + directory);
        }
      } else {
        throw new IllegalStateException("Directory " + directory
            + " does not exist and allowCreateDirectory is disabled");
      }
    }
  }

  public void deliver(File file) throws DeliveryException {
    File destFile;

    try {
      ensureDirectory();
    } catch (Throwable t) {
      throw DeliveryException.newWith(MessageBuilder.withPayload(file).build(),
          t);
    }

    destFile = new File(directory + File.separator + file.getName());

    if (!file.renameTo(destFile)) {
      throw new IllegalStateException("Unable to rename " + file + " to "
          + destFile);
    }

  }

  public File getDirectory() {
    return directory;
  }

  public void setDirectory(File directory) {
    this.directory = directory;
  }

  public boolean getAutoCreateDirectory() {
    return autoCreateDirectory;
  }

  public void setAutoCreateDirectory(boolean autoCreateDirectory) {
    this.autoCreateDirectory = autoCreateDirectory;
  }

}
