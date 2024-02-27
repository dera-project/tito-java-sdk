{ pkgs, ... }:

{
  packages = [ pkgs.git ];
  languages.nix.enable = true;
  languages.java.enable = true;
  devcontainer.enable = true;
}
