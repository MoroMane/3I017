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

mongodb = use tang_fabien // show collections
mongoexport --db tang_fabien --collection message --out tang_fabien.json
mongoimport (à voir sur internet)
ssh -X ppti-14-308-05

SQL PB de MDP ROOT

Follow the steps below.

    Start the MySQL server instance or daemon with the --skip-grant-tables option (security setting).

    $ mysqld --skip-grant-tables

    Execute these statements.

    $ mysql -u root mysql
    $mysql> UPDATE user SET Password=PASSWORD('my_password') where USER='root';
    $mysql> FLUSH PRIVILEGES;

If you face the unknown field Password error above use:

update user set authentication_string=password('my_password') where user='root';

    Finally, restart the instance/daemon without the --skip-grant-tables option.

    $ /etc/init.d/mysql restart

You should now be able to connect with your new password.

$ mysql -u root -p

Enter password: my_password
