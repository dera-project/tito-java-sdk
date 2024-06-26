{ pkgs, ... }:

{
  packages = [ pkgs.git ];
  languages.nix.enable = true;
  languages.java.enable = true;
  languages.java.jdk.package = pkgs.jdk21;
  devcontainer.enable = true;
  difftastic.enable = true;

  pre-commit.hooks = {
    actionlint.enable = true;
    commitizen.enable = true;
    markdownlint.enable = true;
    nixpkgs-fmt.enable = true;
  };
}
