#!/usr/bin/env bash
sed -i 's/127.0.0.1:3306/'$DB_SERVER':'$DB_PORT'/g' /usr/local/tomcat/webapps/ROOT/WEB-INF/hibernate.properties
sed -i 's/rate/'$DB_NAME'/g' /usr/local/tomcat/webapps/ROOT/WEB-INF/hibernate.properties
sed -i 's/username=www/username='$DB_USER'/g' /usr/local/tomcat/webapps/ROOT/WEB-INF/hibernate.properties
sed -i 's/password=/password='$DB_PASSWORD'/g' /usr/local/tomcat/webapps/ROOT/WEB-INF/hibernate.properties
sh /usr/local/tomcat/bin/catalina.sh run
