CqlJmeter
=========

CQL Sampler (Cassandra 1.2.x or 2.x is required) for JMeter



Install
--------

* Get a release
* From TGZ:
 * Unpack _/lib_ folder from the release into the JMeter's folder, for example
```tar -xjf CqlJmeter-2.0.5-release.tar.gz -C apache-jmeter-2.11/```
* Using all-in-one JAR:
 * drop the JAR file into JMeter's ```lib/ext``` folder

Components
----------
See [Components](https://github.com/Mishail/CqlJmeter/wiki)


Quickstart
---------
There are sample test plans in _/samples_ folder. Read more at [Walk through the samples](https://github.com/Mishail/CqlJmeter/wiki/Walkthrough)

Basically you need 4 components:

1. _Thread group_ to simulate users
2. _C* Cluster_ config element to define connection properties
3. One (or several) _CQL statements_ (single or batch) to send
4. One of the _listeners_ to gather results


More information
------
* http://jmeter.apache.org/usermanual/index.html
* http://jmeter.apache.org/usermanual/component_reference.html - buildig blocks
* http://jmeter.apache.org/usermanual/functions.html - you can use functions and variables in CQL Samplers
