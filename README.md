<p align="center">
<a href="https://discord.gg/jEtwguzZ4R"><img alt="" src="https://img.shields.io/badge/Discord-Channel-blue" height="20"/></a>
<a href="https://www.youtube.com/@YourTradeMaster"><img alt="" src="https://img.shields.io/badge/Youtube-Channel-db2e73" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/github/commit-activity/t/drkhodakarami/___PROJECTS___" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/github/last-commit/drkhodakarami/___PROJECTS___" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/github/downloads/drkhodakarami/___PROJECTS___/total" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/github/license/drkhodakarami/___PROJECTS___" height="20"/></a>
<a href=""><img alt="" src="https://img.shields.io/badge/Maintained-YES-31ad31" height="20"/></a>
	</p>

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#thelibrary)
# ➤ Latest Versions

#### ➤ Ji Base&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>
#### ➤ Ji Logger&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>
#### ➤ Ji Reference&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>
#### ➤ Ji Config&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>
#### ➤ Ji Register&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>

#### ➤ Ji Tic Logic_*(WIP)*_&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>
#### ➤ Jira Lib&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>

#### ➤ Ji Fluid_*(WIP)*_&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>

#### ➤ Ji Energy_*(WIP)*_&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>

#### ➤ J Inventory_*(WIP)*_&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>

#### ➤ Ji Machina_*(WIP)*_&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>

#### ➤ Ultra IO_*(WIP)*_&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=""><img alt="" src="https://img.shields.io/badge/1.0.0+MC--1.21.5-8A2BE2" height="18" style="margin-bottom: -5px"/></a>


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#thelibrary)

## ➤ What is this?

This is the main project folder and structure for all of my Minecraft mod development. In this hierarchy, you will find some libraries that are being used in other libraries or mods. At the same time, there are
main mods that I develop and are present in their own folder. Each folder is a separate project and there is no parent/child relationship between them.

Some of the codes in the libraries, are taken from **TurtyWurty's** [REPOSITORY](https://github.com/DaRealTurtyWurty/Industria) and are copied directly here with or without some modifications and addition. You can refer to his licensing if you need to.
Each file that is using his code in any shape or condition, has a credit and link to his repository on top of the file.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Base

This is a simple yet useful library that provides annotations, exceptions, constant values, enums, functions, interfaces and other infrastructure code that will be used by all of my other libraries.
Every library in the system is depending on the base library.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Logger

This is a simple yet useful library for logging your information to the development console or any log file that you would normally use for modding. The library adds a new abstract class that you can instantiate
and use it's many different helper methods for logging with different styles. This is a wrapper around the Logging system provided by Minecraft and FabricMC.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Reference

This is a simple yet useful library for adding a reference class that has helper methods for creating tags, and will carry the mod id of your mod. In your main mod, you will extend this class, replace the ModID
attribute with your mod id one, and then you can add anything you need to the inherited class.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Config

This is a simple yet useful library for adding a server side config system to your mod. This library will not provide a config system that shows up in the game GUI. The library will provide config's .ini file in
the config folder. The current library has no means to provide config system per world. Players don't need to install this library as a separate mod. This library **depends on Ji Logger**

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Register

This is a simple yet useful library for registering everything in your Fabric mod. There are lots of register overload methods inside the Registers class that you can utilize. The class is heavily documented and
should be self explanatory. You just need to add a static import to the subclass and call different register methods as you need and have easier life registering your entries into Minecraft's Registry system.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Jira Lib

This is a simple yet useful library that contains some base repetitively used helper methods, network payload and non payload records, interfaces and abstract classes for blocks and block entities.
Using the ITickBE you can easily generate a ticking block entity and by extending the block entity from UpdatableBE, you can easily sync information between server and client, no more need to send custom
network packets to sync the fluid/energy values!

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Fluid

This is a simple yet useful library for handling your fluid container needs. The library provides a very powerful helper method that handles most of your needs for transfering fluid in tank and buckets in the
inventory slot back and forth or handling player's interaction with a fluid containing block. The library has a wrapper providing a very powerful sided fluid container (**based on TurtyWurty's code**) and some
useful interfaces.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Energy

This is a simple yet useful library that provides wrappers for energy storages. The helper methods will significantly help you when working with energy API provided by tech reborn development team. Remember that
you need to add the dependency for tech reborn energy API in your mod side by side with this library.

This library is using the **energy API provided by tech reborn team**. Because of this dependency, you need to add this dependency to your mod side by side the library.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Inventory

This is a simple yet useful library for handling inventories in your mod. It contains the well known Implemented Inventory interface (renamed to IInventory). The library has a powerful wrapper class for handling
sided inventories (**based on TurtyWurty's code**). You can add your custom inventories with ease utilizing what is already generated in this library. Also, there are some predicate slots that you can use to make
your life easier when it comes to handling inventory management in your block entities.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ji Machina

This is a simple yet useful library for any mod that may want advance machines which has energy, fluid, or inventory in themselves. The library provides abstract classes carrying some boiler plate functionality.

The library is depending on **Energy API from tech reborn team**, **JiraLib**, **JInventory**, **JiFluid**, and **JiEnergy**. Because of these dependencies, you need to add them to your project side by side of
the dependency for this library.

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Ultra IO

This is my main mod. The theme is almost tech and industrial but without the depth of industrialization and technical processing you see in some of the tech mods out there. The idea is to have a harder
start up (not as hard as greg tech but harder than vanilla) and make all the recipe much more resource consuming. In return, you will get some OP armor and tools, useful gadgets, and a nice and powerful yet
simple transfer system and storage management.

The process of having more resources is the tech aspect of the mod. The processing phase is not too much industrialized and the goal is to have something between an industrialized approach and what we had in
Tinkers Construct without the complexity of those mods and stay closer to vanilla way of playing the game.

If you don't want to have easier game play with OP armor and tools, you may want to stay away from this mod. Although it makes almost every recipe really resource consuming, but the armor and tools are OP and
make your life much easier when playing mid game. This will give you a feel of playing creative mod without really playing a creative game and you still have to work for resources but much easier.
Also, you can't have resources with only passage of time like some tech mods do (with an approach of miners that will mine huge areas). Unlike those mods, you can't sit around and let the time pass and get resources.
You still need to be active. But the process will be much much easier.

Another aspect of having OP armor is that it will make your game play feel like playing in peaceful mode, but in reality, you still have mobs spawn and you can farm for their resources. You just don't take
much damage in battles and have easier time slaughtering them!

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#dependency)

## ➤ Depending Your Mod

All libraries are using repsy for maven publishing system. Follow the guideline bellow to make dependency for your mod. Some libraries are depending on other libraries so you should add it to your main mod
too (for dependencies, check the build.gradle files in each library).

First you need to add the maven to your `build.gradle` repositories:

```groovy
repositories 
{
    mavenCentral()
    // For JiLibs
    maven { url 'https://repo.repsy.io/mvn/jiraiyah/jilibs' }
    // For Energy API
	maven {
        url "https://cursemaven.com"
        content {
            includeGroup "curse.maven"
        }
    }
}
```

then you need to add the dependency into your dependency section in `build.gradle`

```groovy
dependencies 
{
    // Ji Libs ===============================================================================================================================
    modImplementation include("jiraiyah.base:jibase:${jibase_version}")
    modImplementation include("jiraiyah.logger:jilogger:${jilogger_version}")
    modImplementation include("jiraiyah.reference:jireference:${jireference_version}")
    modImplementation include("jiraiyah.config:jiconfig:${jiconfig_version}")
    modImplementation include("jiraiyah.register:jiregister:${jiregister_version}")
    modImplementation include("jiraiyah.jiralib:jiralib:${jiralib_version}")
    modImplementation include("jiraiyah.fluid:jifluid:${jifluid_version}")
    modImplementation include("jiraiyah.energy:jienergy:${jienergy_version}")
    modImplementation include("jiraiyah.inventory:jinventory:${jinventory_version}")
    modImplementation include("jiraiyah.machina:jimachina:${jimachina_version}")

    // Energy API ============================================================================================================================
    include modApi("teamreborn:energy:${project.energy_version}") {
        exclude(group: "net.fabricmc.fabric-api")
    }
}
```

Finally, we need to add an entry inside `gradle.properties` using the version from the maven repository.

Look into [MAVEN REPOSITORY](https://repo.repsy.io/mvn/jiraiyah/jilibs/jiraiyah/register/) for the proper versioning.

```groovy
jibase_version=1.0.0+MC-1.21.5
jilogger_version=1.0.0+MC-1.21.5
jireference_version=1.0.0+MC-1.21.5
jiconfig_version=1.0.0+MC-1.21.5
jiregister_version=1.0.0+MC-1.21.5
jiralib_version=1.0.0+MC-1.21.5
jifluid_version=1.0.0+MC-1.21.5
jienergy_version=1.0.0+MC-1.21.5
jinventory_version=1.0.0+MC-1.21.5
jimachina_version=1.0.0+MC-1.21.5
```

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#contributors)

## ➤ Contributors

| [<img alt="Alireza Khodakarami" src="https://avatars.githubusercontent.com/u/77685668?v=4" width="100">](https://www.youtube.com/@YourTradeMaster) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                          [Alireza Khodakarami](https://www.youtube.com/@YourTradeMaster)                                           |
|                                          [khodakarami_dr@outlook.com](mailto:khodakarami_dr@outlook.com)                                           |
|                                                                        🔥<a href="https://discord.gg/jEtwguzZ4R"><img alt="" src="https://img.shields.io/badge/Discord-Channel-blue" height="20" style="margin-bottom: -5px"/></a>🔧                                                                        |

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#license)

## ➤ License

Licensed under [MIT](https://opensource.org/licenses/MIT).

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)](#table-of-contents)

## ➤ Table of Contents

* [➤ The Library Info](#-thelibrary)
* [➤ Depending to Library](#-dependency)
* [➤ Contributors](#-contributors)
* [➤ License](#-license)