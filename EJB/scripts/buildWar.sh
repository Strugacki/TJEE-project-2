#!/bin/sh

echo 
sh ~/EJB/glassfish3/glassfish/bin/asadmin undeploy EJB
echo 
mvn package
echo 
sh ~/EJB/glassfish3/glassfish/bin/asadmin deploy target/EJB.war
