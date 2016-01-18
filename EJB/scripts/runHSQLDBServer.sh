#!/bin/bash

java -cp /home/marcin/workspace/TJEE-project-2/EJB/scripts/hsqldb-2.2.4.jar org.hsqldb.server.Server --database.0 mem:mydb --dbname.0 workdb
