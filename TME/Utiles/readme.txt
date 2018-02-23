Tomcat
A rajouter dans fichier config 
<role rolename="manager-gui"/>
<user username="tomcat" password="tomcat" roles="manager-gui"/>
</tomcat-users>

SQL
mysqladmin -u root password 'root password goes here'
C:\wamp\apps\phpmyadmin\config.inc.php
==>$cfg['Servers'][$i]['password']  = '';  // MySQL password (only needed)

Friends
from		int(11)
to		int(11)	
time		timestamp		(current_timestamp)

Sessions
id_user		int(11)
time		timestamp 		(current_timestamp)
key		varchar(32)
isRoot		tinyint(1) (boolean)
expire		tinyint(1) (boolean)

Users
Id		int(11)			(auto_increment)
login		varchar(64)
password	blob
prenom		varchar(255)
nom		varchar(255)

ssh -X ppti-14-308-05
