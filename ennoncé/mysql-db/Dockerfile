FROM mysql:latest

MAINTAINER zyra83@hotmail.com

ENV MYSQL_ROOT_PASSWORD rootroot

COPY cars-jpa.sql /docker-entrypoint-initdb.d/
COPY my.cnf /etc/mysql/conf.d/config-file.cnf

EXPOSE 3306
