# NLib <a href="https://github.com/Nowaha/NLib/releases/"><img alt="GitHub Workflow Status" src="https://img.shields.io/github/workflow/status/nowaha/nlib/Gradle%20Package"></a> <a href="https://github.com/Nowaha/NLib/packages/1496470"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/nowaha/nlib?display_name=tag"></a>
The Java part of a Java & Kotlin library made for Spigot and any of the forks of it. The Kotlin part can be found [here](https://github.com/Nowaha/NLib-ktx) and contains even more useful utilities, like the ability to create and manage GUIs!

This library contains a bunch of utilities for commonly performed actions, including but not limited to: 
- A simple ItemStack builder which allows you to easily create items with all of the properties you could ever wish to add.
- A nice library for the handling of files, including a basic file and a messages file which lets you load messages and color them and replace any placeholders you want.
- Coloring of messages (including hex codes)
- Generate dynamic progress bars in chat
- Deal with roman numerals

## Documentation
*I am planning to release JavaDocs sometime soon.*

## Installation
I publish the latest build to [GitHub packages](https://github.com/Nowaha/NLib/packages/1496470).

You can add it as a dependency by putting the following in your `build.gradle` file:
```groovy
repositories {
  maven {
      name = "nlib"
      url = uri("https://maven.pkg.github.com/nowaha/nlib")
      credentials(PasswordCredentials)
  }
}
```

```groovy
dependencies {
  implementation('xyz.nowaha:nlib:<latest version>')
}
```
*Note: For the version, do not include the "v" - only put the number (i.e. 1.0.4)*

For the `PasswordCredentials` to be filled in properly, you need to add to your `gradle.properties`
```groovy
nlibUsername=<username>
nlibPassword=ghp_XXXXXXXXXXXXXX
```
