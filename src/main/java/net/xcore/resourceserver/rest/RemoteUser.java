package net.xcore.resourceserver.rest;

import lombok.Data;

@Data
public class RemoteUser {
  private String username;
  private String password;
  private String role;
}
