package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Yulia on 09.09.2018.
 */
public class GithubTests {
  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("2df4c69fe4cb6d8329f0243cea65f8247e6eb0ff");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("Coriolan8", "java_pft")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
