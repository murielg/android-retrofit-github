package com.murielgonzalez.github.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by muriel_gonzalez on 5/23/17.
 */

public class Item {

  //JSON Response Variables
  @SerializedName("name")
  private String name;

  @SerializedName("html_url")
  private String repoUrl;

  @SerializedName("description")
  private String description;

  @SerializedName("default_branch")
  private String branch;

  @SerializedName("owner")
  private RepoOwner owner;

  //Getters and Setters
  public String getName() {
    return name;
  }

  public String getRepoUrl() {
    return repoUrl;
  }

  public String getDescription() {
    return description;
  }

  public String getBranch() {
    return branch;
  }

  public String getAvatarUrl() {

    if (owner != null) {
      return owner.getAvatar_url();
    }

    return null;

  }

  public Item(String name, String repoUrl, String description, String branch) {
    this.name = name;
    this.repoUrl = repoUrl;
    this.description = description;
    this.branch = branch;
  }
}
