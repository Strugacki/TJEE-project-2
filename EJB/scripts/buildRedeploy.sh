#!/bin/sh

echo "************ UNDEPLOYING *******************"
/home/marcin/EJB/glassfish3/glassfish/bin/asadmin undeploy EJB
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
/home/marcin/EJB/glassfish3/glassfish/bin/asadmin deploy target/EJB.war
