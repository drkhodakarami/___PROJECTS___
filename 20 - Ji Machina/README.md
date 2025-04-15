<p align="center">
<a href="https://discord.gg/jEtwguzZ4R"><img alt="" src="https://img.shields.io/badge/Discord-Channel-blue" height="20"/></a>
<a href="https://www.youtube.com/@YourTradeMaster"><img alt="" src="https://img.shields.io/badge/Youtube-Channel-db2e73" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/github/commit-activity/t/drkhodakarami/JiMachina" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/github/last-commit/drkhodakarami/JiMachina" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/github/downloads/drkhodakarami/JiMachina/total" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/github/license/drkhodakarami/JiMachina" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/badge/Maintained-YES-31ad31" height="20"/></a>
	</p>

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#thelibrary)

## ➤ What is this library?

This is a simple yet useful library for any mod that may want advance machines which has energy, fluid, or inventory in themselves. The library provides
abstract classes carrying some boiler plate functionality.

The library is depending on Energy API from tech reborn team, JiraLib, JInventory, JiFluid, and JiEnergy. Because of these dependencies, you need to add
them to your project side by side of the dependency for this library.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Depending Your Mod

This library is using repsy for maven publishing system. Follow the guideline bellow to make dependency for your mod.

### ➤ For latest version, please visit the [WIKI](https://drkhodakarami.github.io/)

First you need to add the maven to your `build.gradle` repositories:

```Maven Repository
repositories 
{
	mavenCentral()
    maven { url 'https://repo.repsy.io/mvn/jiraiyah/jilibs' }
    maven {
        url "https://cursemaven.com"
        content {
            includeGroup "curse.maven"
        }
    }
}
```

then you need to add the dependency into your dependency section in `build.gradle`

```dependencies
dependencies 
{
	// Ji Lib Mods Dependency <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    modImplementation include("jiraiyah.reference:jireference:${jireference_version}")
    modImplementation include("jiraiyah.jiralib:jiralib:${jiralib_version}")
    modImplementation include("jiraiyah.inventory:jinventory:${jinventory_version}")
    modImplementation include("jiraiyah.fluid:jifluid:${jifluid_version}")
    modImplementation include("jiraiyah.energy:jienergy:${jienergy_version}")
    modImplementation include("jiraiyah.machina:jimachina:${jimachina_version}")
	
	// Energy API Handling Dependency <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    include modApi("teamreborn:energy:${project.energy_version}") {
        exclude(group: "net.fabricmc.fabric-api")
    }
}
```

Finally, we need to add an entry inside `gradle.properties` using the version from the maven repository. The version should look like x.x.x

Look into [MAVEN REPOSITORY](https://repo.repsy.io/mvn/jiraiyah/jilibs/jiraiyah/machina/) for the proper versioning.
Look into [MAVEN REPOSITORY ROOT](https://repo.repsy.io/mvn/jiraiyah/jilibs/jiraiyah/) for other libraries (mine) versioning.
Look into [ENERGY API MAVEN](https://maven.fabricmc.net/teamreborn/energy/) for energy api versioning

```gradle.properties
jireference_version=x.x.x
jiralib_version=x.x.x+MC_x.x.x
jinventory_version=x.x.x+MC_x.x.x
jifluid_version=x.x.x+MC_x.x.x
jienergy_version=x.x.x+MC_x.x.x
jimachina_version=x.x.x

energy_version=x.x.x
```

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#contributors)

## ➤ Contributors

| [<img alt="Alireza Khodakarami" src="https://avatars.githubusercontent.com/u/77685668?v=4" width="100">](https://www.youtube.com/@YourTradeMaster) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                          [Alireza Khodakarami](https://www.youtube.com/@YourTradeMaster)                                           |
|                                          [khodakarami_dr@outlook.com](mailto:khodakarami_dr@outlook.com)                                           |
|                                                                        🔥🔧                                                                        |

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#license)

## ➤ License

Licensed under [MIT](https://opensource.org/licenses/MIT).

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#table-of-contents)

## ➤ Table of Contents

* [➤ The Library Info](#-thelibrary)
* [➤ Depending to Library](#-dependency)
* [➤ Contributors](#-contributors)
* [➤ License](#-license)