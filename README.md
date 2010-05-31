fbus - A file bussing system
============================

Overview
--------

FBus is a file bussing system based on Spring and [Spring Integration][1]. This
project is extremely experimental and is meant to:

* Demonstrate one way to integration Hadoop / HDFS with existing systems using
file system queues.
* Scratch an itch.

The hope is that people find this useful as both an example and a project. If
this is true, development will continue.

[1]: http://www.springsource.org/spring-integration

Building
--------

This is a Maven project and can be built by running `mvn assembly:assembly`. A
number of artifacts will be available in the target directory including a jar
without the dependencies and one with the dependencies included.

The [Spring Source bundle repository][2] is used 

[2]: http://www.springsource.com/repository/app/

Configuration
-------------

See the example configuration fbus.xml in `src/test/resources` for a sample of
how to wire together various components. Additional docs forthcoming.

Author
------

E. Sammer - <esammer@cloudera.com>

Copyright / License / Disclaimer
--------------------------------

This code is released under the Apache Software License. While some package
names contain the name "Cloudera," this software is unsupported by Cloudera. I
just happened to work there and needed a unique package space to use during
development.

Absolutely everything is subject to change and comes without warranty.
