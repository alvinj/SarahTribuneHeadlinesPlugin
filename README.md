
Sarah 'Tribune Headlines' Plugin
================================

This plugin gets sports headlines from the Chicago Tribune, filtering them slightly.


Files
-----

The jar file built by this project needs to be copied to the Sarah plugins directory.
On my computer that directory is _/Users/al/Sarah/plugins/DDTribuneHeadlines_.

Files in that directory should be:

    TribuneHeadlines.info
    TribuneHeadlines.jar

The _Twitter.info_ file currently contains these contents:

    main_class = com.devdaily.sarah.plugin.chicagotribune.TribuneSportsHeadlinesPlugin
    plugin_name = Tribune Sports Headlines


To-Do
-----

This plugin can be extended to get "headlines" from many other websites. You just need to specify:

* The URL to read from
* The XPath expression(s) to use to get the headlines (this is the only "hard" part)
* Regex's you want to use to filter those results

The plugin can also be made to be a little more general-purpose by returning a `Seq` rather than
doing the extra string-munging work.

I also need to improve the Sarah2 jar-building process, because this plugin and all
other plugins are dependent on that jar, but that's more of a Sarah2 "to do" than 
anything that needs to be done here. 


Developers - Building this Plugin
---------------------------------

You can build this plugin using the shell script named _build-jar.sh. It currently looks like this:

    #!/bin/bash

    sbt package

    if [ $? != 0 ]
    then
        echo "'sbt package' failed, exiting now"
        exit 1
    fi

    cp target/scala-2.10/tribuneheadlines_2.10-0.1.jar TribuneHeadlines.jar

    ls -l TribuneHeadlines.jar

    echo ""
    echo "Created TribuneHeadlines.jar. Copy that file to /Users/al/Sarah/plugins/DDTribuneHeadlines, like this:"
    echo "cp TribuneHeadlines.jar /Users/al/Sarah/plugins/DDTribuneHeadlines"


Dependencies
------------

This plugin depends on:

* The Sarah2.jar file.
* The Akka/Scala actors. The actor version needs to be kept in sync with whatever actor version
  Sarah2 uses.

As mentioned above, I need to improve the process of requiring and using the Sarah2.jar file,
but that's more of a problem for the Sarah2 project than for this project. 









