#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy EJB
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/EJB.war
