# NLib <a href="http://nowaha.xyz:8081/repository/nowaha-releases/"><img alt="Last release" src="https://img.shields.io/github/v/tag/Nowaha/NLib?label=latest%20release"></a>
The Java part of a Java & Kotlin library made for Spigot and any of the forks of it. The Kotlin part can be found [here](https://github.com/Nowaha/NLib-ktx) and contains even more useful utilities, like the ability to create and manage GUIs!

This library contains a bunch of utilities for commonly performed actions, including but not limited to: 
- A simple ItemStack builder which allows you to easily create items with all of the properties you could ever wish to add.
- A nice library for the handling of files, including a basic file and a messages file which lets you load messages and color them and replace any placeholders you want.
  - There is also a type that allows you to just create a class with static variables, and load these in keeping the current values as the defaults (reflection magic)
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
      name = "nowaha"
      url = uri("https://nexus.nowaha.xyz/repository/nowaha-releases/")
  }
}

dependencies {
  implementation 'xyz.nowaha:nlib:<latest version>'
}
```
*Note: For the version, do not include the "v" - only put the number (i.e. 1.1.0)*
