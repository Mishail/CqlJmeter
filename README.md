CqlJmeter
=========

CQL Sampler (Cassandra 2.x is required) for JMeter



Install
--------

* Get a release
* Unpack into Jmeter folder


Quickstart
---------
There is a sample test plan in _/samples_ folder

Basically you need 4 items:

1. Thread group to simulate users
2. C* Cluster config element to define connection properties
3. One (or several) CQL statements to send
4. Listener to gather results


