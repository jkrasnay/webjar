# WebJar Project Skeleton

A WebJar is a web application built using Java Servlet technology but without
using the WAR archive format. Instead, a WebJar is an executable JAR that
embeds the Jetty web server.


## Motivation

WebJars have a number of advantages over regular WARs.

- They are easy to deploy. Just drop the JAR on a server and run `java -jar
  myapp-1.0.jar`. You don't need to configure a separate Servlet container and
  wire it up to your WAR.

- They are simple to debug. Just run the Main class in your debugger. Also,
  there's only a single classloader, so no more classloading issues.

- The embedded Jetty server can be configured with multiple handlers, so you
  can, for example, have a servlet container alongside a
  [Restlet](http://www.restlet.org) handler in the same container, without
  forcing Restlet calls through a servlet. This might also let you elegantly
  handle web socket or long-polling HTTP requests, but I don't know much about
  that.

The main disadvantage is that you can't use JSPs, but all the cool kids are
using [Wicket](http://wicket.apache.org/) these days. Why not be cool, too?


## Usage

To run from the command line:

    mvn package
    java -jar target/webjar-1.0-SNAPSHOT.jar

Then point your browser to http://localhost:8888/.

You can also run `mvn eclipse:eclipse`, import the project into Eclipse, and debug the `Main` class.


John Krasnay
john@krasnay.ca
