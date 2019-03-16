# GST-Compliance-Software

Prerequisite :-

Need a MySQL Database in PC.<br>
Need to have username and password as root respectively.<br>
Need to fire the following command before execution of Main page i.e Home.java

mysql> delimiter //<br>
mysql> create trigger trig after delete on bill<br>
mysql> for each row begin<br>
mysql> insert into stock(pid,pname,pprice,pqty,pcat,date) values(old.pid,old.pname,old.pprice,old.pqty,old.pcat,sysdate());<br>
mysql> end;<br>
mysql> delimiter;<br>
