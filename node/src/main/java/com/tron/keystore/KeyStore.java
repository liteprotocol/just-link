package com.tron.keystore;

import org.springframework.stereotype.Component;

@Component
public class KeyStore {

  private byte[] privateKey;

  private byte[] publicKey;

  private String address;

  public KeyStore() {
    init();
  }

  /**
   * Init from the config file.
   */
  public void init() {
  }
}
